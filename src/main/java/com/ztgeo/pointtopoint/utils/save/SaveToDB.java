package com.ztgeo.pointtopoint.utils.save;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ztgeo.pointtopoint.controller.entity.CXR_MSGDirect;
import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.entity.CXSQD;
import com.ztgeo.pointtopoint.entity.RESULT;
import com.ztgeo.pointtopoint.handle.entity.*;
import com.ztgeo.pointtopoint.service.mainService.*;
import com.ztgeo.pointtopoint.utils.Dict;
import com.ztgeo.pointtopoint.utils.UUIDUtils;
import com.ztgeo.pointtopoint.utils.Util;
import com.ztgeo.pointtopoint.utils.json.RequestJSONString;
import com.ztgeo.pointtopoint.utils.json.entity.CXYWCS;
import com.ztgeo.pointtopoint.utils.json.entity.Response;
import com.ztgeo.pointtopoint.utils.json.entity.Responsedata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 保存到数据库
 */
@Slf4j
@Component
public class SaveToDB {

    private static CXR_MSGService cxrMsgService;
    private static RESULTService resultService;
    private static CXR_MSGDirectService cxr_msgDirectService;
    private static CXSQDService cxsqdService;
    private static CFDJService cfdjService;
    private static DYAQService dyaqService;
    private static FDCQService fdcqService;
    private static GJZWSYQService gjzwsyqService;
    private static TDSYQService tdsyqService;
    private static YGDJService ygdjService;
    private static YYDJService yydjService;

    @Autowired
    public void setCxrMsgService(CXR_MSGService cxrMsgService) {
        SaveToDB.cxrMsgService = cxrMsgService;
    }

    @Autowired
    public void setHeadService(RESULTService headService) {
        SaveToDB.resultService = headService;
    }

    @Autowired
    public void setCxr_msgDirectService(CXR_MSGDirectService cxr_msgDirectService) {
        SaveToDB.cxr_msgDirectService = cxr_msgDirectService;
    }

    @Autowired
    public void setCxsqdService(CXSQDService cxsqdService) {
        SaveToDB.cxsqdService = cxsqdService;
    }

    @Autowired
    public void setResultService(RESULTService resultService) {
        SaveToDB.resultService = resultService;
    }

    @Autowired
    public void setCfdjService(CFDJService cfdjService) {
        SaveToDB.cfdjService = cfdjService;
    }

    @Autowired
    public void setDyaqService(DYAQService dyaqService) {
        SaveToDB.dyaqService = dyaqService;
    }

    @Autowired
    public void setFdcqService(FDCQService fdcqService) {
        SaveToDB.fdcqService = fdcqService;
    }

    @Autowired
    public void setGjzwsyqService(GJZWSYQService gjzwsyqService) {
        SaveToDB.gjzwsyqService = gjzwsyqService;
    }

    @Autowired
    public void setTdsyqService(TDSYQService tdsyqService) {
        SaveToDB.tdsyqService = tdsyqService;
    }

    @Autowired
    public void setYgdjService(YGDJService ygdjService) {
        SaveToDB.ygdjService = ygdjService;
    }

    @Autowired
    public void setYydjService(YYDJService yydjService) {
        SaveToDB.yydjService = yydjService;
    }

    /**
     * 保存请求人数据
     *
     * @param jsonString 带有请求人数据的json字符串
     * @return
     */
    public void addCXR_MSG(String jsonString) {
        log.info("解析请求数据的JSON......");
        try {
            String jsonObject = JSONObject.parseObject(jsonString).getJSONObject("head").getString("code");
            log.info("接收到的数据状态码（CODE）" + jsonObject);
            log.info("解析请求数据");
            Response response = RequestJSONString.responseJSON(jsonString);
            log.info("解析完成");
            List<CXSQD> cxsqds = new ArrayList<>();
            List<CXR_MSG> cxr_msgs = new ArrayList<>();
            for (int i = 0; i < response.getDatas().size(); i++) {
                Responsedata data = response.getDatas().get(i);
                String cxqqdh = data.getCxsqdh();
                String cxjgbs = data.getCxjgbs();
                String cxywlb = data.getCxywlb();
                int cxfw = data.getCxfw();
                cxywlb = Dict.changeCXYWLB(cxywlb);
                String primary_key = UUIDUtils.generateShortUuid();
                //判断查询申请单号是否存在数据库，若存在，直接continue
                if (cxsqdService.judgeCxsqdhIsExist(cxqqdh) > 0) {
                    continue;
                }
                cxsqds.add(new CXSQD(primary_key, cxqqdh, Util.getSaveDate(), "", cxywlb, cxfw, Util.getSaveDate(), cxjgbs));
                List<CXSQD>  cxsqd= cxsqdService.selectCXSQDByCxsqdh(cxqqdh);
                for (int j = 0; j < data.getCxywcss().size(); j++) {
                    CXYWCS cxywcs = data.getCxywcss().get(j);
                    String qlrmc = cxywcs.getQlrmc();
                    String qlrzjh = cxywcs.getQlrzjh();
                    int qlrzjlx = cxywcs.getQlrzjlx();
                    String wsbh = cxywcs.getWsbh();
                    String cxqy = cxywcs.getCxqy();
                    String cxr_primary_key = UUIDUtils.generateShortUuid();
                    CXR_MSG cxr_msg = new CXR_MSG(cxr_primary_key, cxsqd.get(0).getId(), qlrmc, qlrzjh, cxqy, qlrzjlx, wsbh);
                    cxr_msgs.add(cxr_msg);
                }
            }
            try {
                if (cxsqds != null && cxsqds.size() > 0) {
                    addCXSQD(cxsqds);
                }
                if (cxr_msgs != null && cxr_msgs.size() > 0) {
                    addCXR_MSG(cxr_msgs);
                }
            } catch (Exception e) {
                log.error("反馈报文数据入库时发生捕捉到异常CXR_MSG-->{}{}{}", cxsqds.toString(), cxr_msgs.toString(), e.getLocalizedMessage());
            }

        } catch (Exception e) {
            log.error("解析接收到的请求转换报错:" + e);
        }
    }




    /**
     * 保存请求人数据
     *
     * @param jsonString 带有请求人数据的json字符串
     * @return
     */
    public void addCXR_MSG_Only(String jsonString) {
        log.info("解析请求数据的JSON......");
        try {
            String jsonObject = JSONObject.parseObject(jsonString).getJSONObject("head").getString("code");
            log.info("接收到的数据状态码（CODE）" + jsonObject);
            log.info("解析请求数据");
            Response response = RequestJSONString.responseJSON(jsonString);
            log.info("解析完成");
            List<CXSQD> cxsqds = new ArrayList<>();
            List<CXR_MSG> cxr_msgs = new ArrayList<>();
            for (int i = 0; i < response.getDatas().size(); i++) {
                Responsedata data = response.getDatas().get(i);
                log.info(data.getCxsqdh());
                String cxqqdh = data.getCxsqdh();
                List<CXSQD>  cxsqd= cxsqdService.selectCXSQDByCxsqdh(cxqqdh);
                for (int j = 0; j < data.getCxywcss().size(); j++) {
                    CXYWCS cxywcs = data.getCxywcss().get(j);
                    String qlrmc = cxywcs.getQlrmc();
                    String qlrzjh = cxywcs.getQlrzjh();
                    int qlrzjlx = cxywcs.getQlrzjlx();
                    String wsbh = cxywcs.getWsbh();
                    String cxqy = cxywcs.getCxqy();
                    String cxr_primary_key = UUIDUtils.generateShortUuid();
                    CXR_MSG cxr_msg = new CXR_MSG(cxr_primary_key, cxsqd.get(0).getId(), qlrmc, qlrzjh, cxqy, qlrzjlx, wsbh);
                    cxr_msgs.add(cxr_msg);
                    System.out.println(cxr_msgs.size());
                }
            }
            try {
                if (cxr_msgs != null && cxr_msgs.size() > 0) {
                    addCXR_MSG(cxr_msgs);
                }
            } catch (Exception e) {
                log.error("反馈报文数据入库时发生捕捉到异常CXR_MSG-->{}{}{}", cxsqds.toString(), cxr_msgs.toString(), e.getLocalizedMessage());
            }
        } catch (Exception e) {
            log.error("解析接收到的请求转换报错:" + e);
        }
    }













    public void addRESULT(ArrayList<RESULT> results) {
        if (0 < results.size()) {
            if (results.size() <= 2000) {
                resultService.saveToRESULT(results);//插入表格HEAD的数据库的service
            } else {
                int times = (int) Math.ceil(results.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    resultService.saveToRESULT(results.subList(i * 2000, Math.min((i + 1) * 2000, results.size() - 1)));
                }
            }
        }
    }

    /**
     * 网络直接查询接口
     *
     * @param cxr_msgDirects 网络直接查询人list
     */
    public void addCXR_MSGDirect(List<CXR_MSGDirect> cxr_msgDirects) {
        if (0 < cxr_msgDirects.size()) {
            cxr_msgDirectService.saveToCXR_MSGDirect(cxr_msgDirects);
        }
    }

    /**
     * 存储查询申请单号相关数据信息到GX_CXSQD表
     */
    public void addCXSQD(List<CXSQD> cxsqds) {
        if (0 < cxsqds.size()) {
            if (cxsqds.size() <= 2000) {
                cxsqdService.saveToCXSQD(cxsqds);
            } else {
                int times = (int) Math.ceil(cxsqds.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    cxsqdService.saveToCXSQD(cxsqds.subList(i * 2000, Math.min((i + 1) * 2000, cxsqds.size() - 1)));
                }
            }
        }
    }

    /**
     * 存储权利人相关数据信息到GX_CXR_MSG表
     */
    public void addCXR_MSG(List<CXR_MSG> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                cxrMsgService.saveToCXR_MSG(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    cxrMsgService.saveToCXR_MSG(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }

    public void addCFDJ(List<CFDJ> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                cfdjService.saveToCFDJ(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    cfdjService.saveToCFDJ(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }

    public void addDYAQ(List<DYAQ> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                dyaqService.saveToDYAQ(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    dyaqService.saveToDYAQ(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }

    public void addFDCQ(List<FDCQ> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                fdcqService.saveToFDCQ(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    fdcqService.saveToFDCQ(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }

    public void addGJZWSYQ(List<GJZWSYQ> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                gjzwsyqService.saveToGJZWSYQ(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    gjzwsyqService.saveToGJZWSYQ(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }

    public void addTDSYQ(List<TDSYQ> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                tdsyqService.saveToTDSYQ(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    tdsyqService.saveToTDSYQ(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }

    public void addYGDJ(List<YGDJ> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                ygdjService.saveToYGDJ(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    ygdjService.saveToYGDJ(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }

    public void addYYDJ(List<YYDJ> cxr_msgs) {
        if (0 < cxr_msgs.size()) {
            if (cxr_msgs.size() <= 2000) {
                yydjService.saveToYYDJ(cxr_msgs);
            } else {
                int times = (int) Math.ceil(cxr_msgs.size() / 2000.0);
                for (int i = 0; i < times; i++) {
                    yydjService.saveToYYDJ(cxr_msgs.subList(i * 2000, Math.min((i + 1) * 2000, cxr_msgs.size() - 1)));
                }
            }
        }
    }
}
