package com.ztgeo.pointtopoint.utils.callInterface;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.ztgeo.pointtopoint.controller.entity.*;
import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.entity.CXSQD;
import com.ztgeo.pointtopoint.entity.RESULT;
import com.ztgeo.pointtopoint.entity.Resulthead;
import com.ztgeo.pointtopoint.handle.Hand;
import com.ztgeo.pointtopoint.handle.HandleSearch;
import com.ztgeo.pointtopoint.handle.middleEntity.CXSQJG;
import com.ztgeo.pointtopoint.utils.save.SaveToDB;
import com.ztgeo.pointtopoint.service.mainService.CXR_MSGService;
import com.ztgeo.pointtopoint.service.mainService.CXSQDService;
import com.ztgeo.pointtopoint.utils.SendHttpClient;
import com.ztgeo.pointtopoint.utils.UUIDUtils;
import com.ztgeo.pointtopoint.utils.Util;
import com.ztgeo.pointtopoint.utils.json.RequestJSONString;
import com.ztgeo.pointtopoint.utils.json.ReturnJSONString;
import com.ztgeo.pointtopoint.utils.token.Token;
import com.ztgeo.pointtopoint.utils.token.TokenRedis;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Slf4j
@Component
public class CallInterface implements Runnable { //调用省厅提供的接口的类
    /**
     * 注入需要用到的service
     * 除controller以外的类不能直接注入，需要使用下面方法注入
     * 注意：setter方法必须是非static
     */
    private static TokenRedis tokenRedis;
    private static String qqccdz;//请求存储地址
    private static String receive_apply_url;
    private static String commit_apply_url;
    private static String commit_result_url;
    private static CXSQDService cxsqdService;
    private static CXR_MSGService cxr_msgService;
    private static String xzqdm;//行政区代码
    private static int timeout;
    private final LinkedList<CXSQD> qTasks = new LinkedList<>();
    private final JSONArray json_dataArray = new JSONArray();
    HandleSearch handleSearch = new HandleSearch();

    @Value("${url.commitResultUrl}")
    public void setCommit_result_url(String commit_result_url) {
        CallInterface.commit_result_url = commit_result_url;
    }

    @Value("${url.receiveApplyUrl}")
    public void setReceive_apply_url(String receive_apply_url) {
        CallInterface.receive_apply_url = receive_apply_url;
    }

    @Value("${url.commitApplyUrl}")
    public void setCommit_apply_url(String commit_apply_url) {
        CallInterface.commit_apply_url = commit_apply_url;
    }

    @Autowired
    public void setCxsqdService(CXSQDService cxsqdService) {
        CallInterface.cxsqdService = cxsqdService;
    }

    @Autowired
    public void setCxr_msgService(CXR_MSGService cxr_msgService) {
        CallInterface.cxr_msgService = cxr_msgService;
    }

    @Autowired
    public void setTokenRedis(TokenRedis tokenRedis) {
        CallInterface.tokenRedis = tokenRedis;
    }

    @Value("${timeout}")
    public void setTimeout(int timeout) {
        CallInterface.timeout = timeout;
    }

    @Value("${token.xzqdm}")//从配置文件中读取行政区代码
    public void setXzqdm(String xzqdm) {  //注入行政区代码,注意@Value()只能写在非静态属性或者方法上
        CallInterface.xzqdm = xzqdm;
    }

    @Value("${qqccdz}")
    public void setQqccdz(String qqccdz) {
        CallInterface.qqccdz = qqccdz;
    }

    /**
     * 获取省厅下发的请求
     *
     * @return 返回省厅下发的请求
     */
    public String request() {
        log.info("编写请求获取请求数据的报文...");
        String token = tokenRedis.getToken();
        String requestJSON = RequestJSONString.requestJSON(token, xzqdm);//编写调用接口的报文
        Map<String, String> obj = new HashMap<>();//组织发送报文
        obj.put("gxData", requestJSON);
        String responseJSON = null;
        try {
            responseJSON = SendHttpClient.sendHttpClient(receive_apply_url, obj, timeout); //发送请求
            while (StringUtils.isBlank(responseJSON) || responseJSON.startsWith("<html>")) {//如果调用接口报错，再次尝试
                responseJSON = SendHttpClient.sendHttpClient(receive_apply_url, obj, timeout);
            }
            Util.writeToFile(responseJSON, qqccdz); //请求数据写入文本文件
        } catch (IOException e) {
            log.error("获取请求报错：" + e);
            e.printStackTrace();
        }
        return responseJSON;
    }

    /**
     * 确认请求已接收的接口
     *
     * @param cxsqdhs 接收到的请求的查询申请单号
     * @param xzqdm   行政区代码
     * @param timeout 超时时间
     * @return 返回调用确认接口之后 接收到的反馈报文
     */
    public String confirm(List<String> cxsqdhs, String xzqdm, int timeout) {
        String token = tokenRedis.getToken();
        log.info("编写确认请求接收的json字符串...");
        String requestJSON = RequestJSONString.confirmRequestJSON(token, cxsqdhs, xzqdm);//组织确认请求接收的报文
        Map<String, String> obj = new HashMap<>();
        obj.put("gxData", requestJSON);
        String responseJSON = null;
        try {
            responseJSON = SendHttpClient.sendHttpClient(commit_apply_url, obj, timeout); //调用接口
            while (StringUtils.isBlank(responseJSON) || responseJSON.startsWith("<html>")) {
                responseJSON = SendHttpClient.sendHttpClient(commit_apply_url, obj, timeout);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("确认请求数据接收报错：" + e);
        }
        if (StringUtils.isEmpty(responseJSON)) {
            return "";
        }
        return responseJSON;
    }

    /**
     * 查询出的数据进行反馈到省厅
     */

    //保存请求数据到数据库并确认请求数据已接收
    public void saveAndConfirm(String responseJSON) {
        log.info("请求存入数据库...");
        SaveToDB saveToDB = new SaveToDB();
        saveToDB.addCXR_MSG(responseJSON); // 获取到的请求json解析后插入数据库表cxr_msg
        List<String> cxsqdhIds = cxsqdService.selectCxsqdhs();
        if (cxsqdhIds.size() < 1) {
            log.error("省厅无下发今日数据返回数据为"+responseJSON);
        } else {
            String result = confirm(cxsqdhIds, xzqdm, timeout); // 确认请求已接收
            if (StringUtils.isBlank(result)) {
                log.error("确认接收请求收到空反馈");
            } else {
                String code = RequestJSONString.confirmResponseJSON(result);
                if (code.equals("0000")) {
                    log.info("查询申请单号列表成功反馈给省厅");
                    cxsqdService.updateCXSQD(cxsqdhIds);//更新状态
                } else {
                    log.error("查询申请单号列表未成功反馈给省厅");
                    cxsqdService.updateCXSQD(cxsqdhIds);//更新状态
                }
            }
        }
    }

    public void response(String cxsqdh, int responseByCxsqdh) {
        log.info("推送数据...");
        SaveToDB saveToDB = new SaveToDB();
        while (cxsqdService.selectResponseCxsqdhs().size() > 0) { // 判断是否有未反馈的请求数据;
            String token = tokenRedis.getToken();
            log.info("token:" + token);
            JSONObject json = new JSONObject();  //组织请求json
            Resulthead head = new Resulthead();
            head.setToken(token);
            head.setXzqdm(xzqdm);
            json.put("head", head);
            Map map;
            if (responseByCxsqdh == 1) {
                map = responseByCxsqdh(cxsqdh);
            } else {
                map = jsonDataArray("", 0);
            }
            json.put("data", map.get("json_dataArray"));
            List<CXSQD> cxsqdhs = (List<CXSQD>) map.get("cxsqds");
            Gson gson = new Gson();
            String jsonString = gson.toJson(json);
            log.info("推送的数据:");
            log.info("jsonString:" + jsonString);
            Map<String, String> obj = new HashMap<>();  //组织请求报文
            obj.put("gxData", jsonString);
            String responseJSON = null;
            try {
                log.info("开始推送");
                responseJSON = SendHttpClient.sendHttpClient(commit_result_url, obj, 180000); //反馈数据
                while (responseJSON.startsWith("<html>")) {
                    responseJSON = SendHttpClient.sendHttpClient(commit_result_url, obj, 180000);
                    log.info("反馈结果出现异常1.2(需要再次推送)：");
                    log.info(responseJSON);
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.info("" + e);
            } catch (Exception e) {
                log.error("反馈结果出现异常2:" + e);
            }
            log.info("推送数据取得的结果:");
            log.info("responseJSON:" + responseJSON);

            ArrayList<RESULT> results = new ArrayList<>();   //分析结果数据
            if (!StringUtils.isBlank(responseJSON)) {
                log.info("解析response json字符串");
                results = ReturnJSONString.responseJSON(responseJSON, cxsqdhs); //解析结果数据
            } else {
                Date fksj = Util.getSaveDate();
                for (int i = 0; i < cxsqdhs.size(); i++) {
                    RESULT resultsingle = new RESULT(UUIDUtils.generateShortUuid(), "null", "接收到的反馈结果为空", cxsqdhs.get(i).getCxsqdh(), fksj);
                    results.add(resultsingle);
                }
            }
            saveToDB.addRESULT(results); //反馈结果存入数据库表RESULT
            for (int i = 0; i < results.size(); i++) {
                updateCXSQD(results.get(i));
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            log.info("推送结束");
        }
    }


    /**
     * 查询之后更新被查询人的记录zt字段
     *
     * @param result 存储查询结果
     *               代码 响应信息描述
     *               0000 成功
     *               1001 查询条件为空
     *               1002 查询条件格式错误
     *               1003 查询结果已反馈至相关部门
     *               2001 用户名密码验证错误
     *               2002 安全 token 错误
     *               2004 查询业务类别错误
     *               2005 查询结果不规范：详细缺失字段信 息。如，”房地产权信息中不动产 单元号不能为空！”（在所有字段 验证完后反馈）
     *               2006 查询申请单号错误
     *               2007 查询数据超过 10 条（针对相关部 门查询不动产信息的查询申请接 收接口）
     *               2008 文书编号错误
     *               2009 获取 token 依据错误
     *               2010 查询文书不存在
     *               2011 相关部门服务异常
     *               2013 申请单号结果已经被领取
     *               2014 文件不应大于 5M!
     *               2015 承办人名称为空
     *               2016 该请求无对应文书
     *               2019 参数格式错误或者不完整，请检查
     *               2020 OpenId 不合法
     *               3001 查询结果不存在
     *               3002 部分查询单号反馈失败
     *               3004 ES 中没有数据
     *               2005 查询参数中文书重复异常
     *               3006 查询结果尚未反馈
     *               3009 机构业务类别关系不存在
     *               3011 机构字段关系不存在
     *               3012 申请单号:反馈结果不全
     *               3013 获取民政 token 异常
     *               3014 入参参数有误
     *               9001 系统错误
     *               9002 还未从江苏省公安厅人口库查询 此居民信息，请稍后再发起查询 9003 未收到此居民身份证号查询请求
     *               9004 江苏省公安厅人口库未查询到此人
     */
    public static void updateCXSQD(RESULT result) {
        String zt = "";
        if ("0000".equals(result.getCode())) {
            zt = "3";
        } else {
            zt = "4";
        }
        cxsqdService.updateCXSQHDByResponseCode(zt, result.getCxsqdh(), Util.getSaveDate());
    }

    /**
     * 反馈报文数据组织入库
     */
    public void dataOrganization() {
        Hand hand = new Hand();
        hand.getRecord();
    }


    /**
     * 反馈给省厅的报文组织
     *
     * @param cxr_msgs
     * @return
     */
    public JSONArray responseDataOrganization(List<CXR_MSG> cxr_msgs) {
        List<DirectTDSYQ> tdsyq = new ArrayList<>();
        List<DirectFDCQ> fdcq = new ArrayList<>();
        List<DirectJSYDSYQ> jsydsyq = new ArrayList<>();
        List<DirectDYAQ> dyaq = new ArrayList<>();
        List<DirectCFDJ> cfdj = new ArrayList<>();
        List<DirectYGDJ> ygdj = new ArrayList<>();
        List<DirectGJZWSYQ> gjzwsyq = new ArrayList<>();
        List<DirectLQ> lq = new ArrayList<>();
        List<DirectHYSYQ> hysyq = new ArrayList<>();
        List<DirectYYDJ> yydj = new ArrayList<>();
        List<DirectNYDSYQ> nydsyq = new ArrayList<>();
        JSONArray json_cxsqjg = new JSONArray();
        String cxrid;
        for (CXR_MSG cxr_msg : cxr_msgs) {
            String wsbh = cxr_msg.getWsbh();
            cxrid = cxr_msg.getId();
            log.info("文书编号:" + wsbh + "查询人id:" + cxrid);
            if (handleSearch.selectCFDJsByCXRId(cxrid) != null && handleSearch.selectCFDJsByCXRId(cxrid).size() > 0) {
                cfdj = handleSearch.selectCFDJsByCXRId(cxrid);
            }
            if (handleSearch.selectDYAQsByCXRId(cxrid) != null && handleSearch.selectDYAQsByCXRId(cxrid).size() > 0) {
                dyaq = handleSearch.selectDYAQsByCXRId(cxrid);
            }
            if (handleSearch.selectFDCQsByCXRId(cxrid) != null && handleSearch.selectFDCQsByCXRId(cxrid).size() > 0) {
                fdcq = handleSearch.selectFDCQsByCXRId(cxrid);
            }
//            log.info("房地产权"+fdcq);
            if (handleSearch.selectGJZWSYQsByCXRId(cxrid) != null && handleSearch.selectGJZWSYQsByCXRId(cxrid).size() > 0) {
                gjzwsyq = handleSearch.selectGJZWSYQsByCXRId(cxrid);
            }
            if (handleSearch.selectTDSYQsByCXRId(cxrid) != null && handleSearch.selectTDSYQsByCXRId(cxrid).size() > 0) {
                tdsyq = handleSearch.selectTDSYQsByCXRId(cxrid);
            }
            if (handleSearch.selectYGDJsByCXRId(cxrid) != null && handleSearch.selectYGDJsByCXRId(cxrid).size() > 0) {
                ygdj = handleSearch.selectYGDJsByCXRId(cxrid);
            }
            if (handleSearch.selectYYDJsByCXRId(cxrid) != null && handleSearch.selectYYDJsByCXRId(cxrid).size() > 0) {
                yydj = handleSearch.selectYYDJsByCXRId(cxrid);
            }
            CXSQJG cxsqjg = new CXSQJG(wsbh, tdsyq, jsydsyq, fdcq, dyaq, ygdj, cfdj, hysyq, lq, gjzwsyq, yydj, nydsyq);
            log.info("查询申请结果" + cxsqjg);
            json_cxsqjg.add(cxsqjg);
            tdsyq = new ArrayList<>();
            jsydsyq = new ArrayList<>();
            fdcq = new ArrayList<>();
            dyaq = new ArrayList<>();
            ygdj = new ArrayList<>();
            cfdj = new ArrayList<>();
            hysyq = new ArrayList<>();
            lq = new ArrayList<>();
            gjzwsyq = new ArrayList<>();
            yydj = new ArrayList<>();
            nydsyq = new ArrayList<>();
        }
        return json_cxsqjg;
    }

    public Map jsonDataArray(String cxsqdh, int responseByCxsqdh) {
        List<CXSQD> cxsqds = new ArrayList<>();
        if (responseByCxsqdh == 1) {
            CXSQD cxsqd = cxsqdService.selectCXSQDByCxsqdh(cxsqdh).get(0);
            cxsqds.add(cxsqd);
        } else if (responseByCxsqdh == 0) {
            cxsqds = cxsqdService.selectResponseCxsqdhs();
        }
        qTasks.clear();
        for (CXSQD cxsqd : cxsqds) {
            qTasks.push(cxsqd);
        }
        json_dataArray.clear();
        int count = 20;
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(this);
            threads[i].start();
        }
        for (int i = 0; i < count; i++) {
            try {
                threads[i].join(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Map map = new HashMap();
        map.put("cxsqds", cxsqds);
        map.put("json_dataArray", json_dataArray);
        return map;
    }

    @Override
    public void run() {
        CXSQD cxsqd;
        synchronized (qTasks) {
            cxsqd = qTasks.poll();
        }
        while (null != cxsqd) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cxsqdh", cxsqd.getCxsqdh());
            List<CXR_MSG> cxr_msgs = cxr_msgService.selectMsgsByCxsqdhId(cxsqd.getId());
            jsonObject.put("cxsqjg", responseDataOrganization(cxr_msgs));
            synchronized (json_dataArray) {
                json_dataArray.add(jsonObject);
            }
            synchronized (qTasks) {
                cxsqd = qTasks.poll();
            }
        }
    }

    public Map responseByCxsqdh(String cxsqdh) {
        List<CXSQD> cxsqds = new ArrayList<>();
        CXSQD cxsqd = cxsqdService.selectCXSQDByCxsqdh(cxsqdh).get(0);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cxsqdh", cxsqd.getCxsqdh());
        List<CXR_MSG> cxr_msgs = cxr_msgService.selectMsgsByCxsqdhId(cxsqd.getId());
        jsonObject.put("cxsqjg", responseDataOrganization(cxr_msgs));
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        cxsqds.add(cxsqd);
        Map map = new HashMap();
        map.put("cxsqds", cxsqds);
        map.put("json_dataArray", jsonArray);
        return map;
    }


}
