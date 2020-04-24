package com.ztgeo.pointtopoint.handle;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ztgeo.pointtopoint.controller.entity.*;
import com.ztgeo.pointtopoint.entity.*;
import com.ztgeo.pointtopoint.handle.entity.*;
import com.ztgeo.pointtopoint.handle.middleEntity.*;
import com.ztgeo.pointtopoint.utils.save.SaveToDB;
import com.ztgeo.pointtopoint.service.mainService.*;
import com.ztgeo.pointtopoint.utils.Dict;
import com.ztgeo.pointtopoint.utils.UUIDUtils;
import com.ztgeo.pointtopoint.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Hand {
    private Logger log = LoggerFactory.getLogger(getClass());
    private static String xzqdm;//行政区代码
    SaveToDB saveToDB = new SaveToDB();
    HandleSearch handleSearch = new HandleSearch();
    private static CXSQDService cxsqdService;
    private static CXR_MSGService cxr_msgService;

    @Value("${token.xzqdm}")//从配置文件中读取行政区代码
    public void setXzqdm(String xzqdm) {  //注入行政区代码,注意@Value()只能写在非静态属性或者方法上
        Hand.xzqdm = xzqdm;
    }

    @Autowired
    public void setCxsqdService(CXSQDService cxsqdService) {
        Hand.cxsqdService = cxsqdService;
    }

    @Autowired
    public void setCxr_msgService(CXR_MSGService cxr_msgService) {
        Hand.cxr_msgService = cxr_msgService;
    }

    public void getRecord() {
        int cfxh = 1;
        List<CXSQD> cxsqds = cxsqdService.selectCXSQDHS();
        for (CXSQD cxsqd : cxsqds) {
            int cxfw = cxsqd.getCxfw();
            List<CXR_MSG> cxr_msgs = cxr_msgService.selectMsgsByCxsqdhId(cxsqd.getId());
            try {
                for (CXR_MSG cxr_msg : cxr_msgs) {
                    ArrayList<String> slbhList = new ArrayList<>();
                    HandleUtil handleUtil = new HandleUtil();
                    slbhList = handleUtil.getSLBH(cxfw, cxr_msg);
                    tdsyq(slbhList, cxr_msg, 0);
                    fdcq(slbhList, cxr_msg, 0);
                    gjzwsyq(slbhList, cxr_msg, 0);
                    dyaq(slbhList, cxr_msg, 0);
                    ygdj(slbhList, cxr_msg, 0);
                    cfdj(slbhList, cfxh, cxr_msg, 0);
                    yydj(slbhList, cxr_msg, 0);
                }
                cxsqdService.updateCXSQDById(cxsqd.getId());
            } catch (Exception e) {
                log.error("反馈报文组织入库异常-->{}", e.getLocalizedMessage());
            }
        }
        log.info("反馈报文组织入库完毕...");
    }

    /**
     * 网络直接查询响应报文数据组织
     *
     * @return
     */
    public JSONArray getDirectRecord(CXR_MSGDirect cxr_msgDirect) {
        JSONObject json_data = new JSONObject();
        String cxsqdh = cxr_msgDirect.getCxsqdh();
        json_data.put("cxsqdh", cxsqdh);
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
        int cfxh = 1;
        String wsbh = cxr_msgDirect.getWsbh();
        log.info("文书编号:" + wsbh);
        ArrayList<String> slbhList = new ArrayList<String>();
        HandleUtil handleUtil = new HandleUtil();
        CXR_MSG cxr_msg = new CXR_MSG("", "", cxr_msgDirect.getXm(), cxr_msgDirect.getZjhm(), cxr_msgDirect.getCxqy(), cxr_msgDirect.getZjzl(), cxr_msgDirect.getWsbh());
        slbhList = handleUtil.getSLBH(cxr_msgDirect.getCxfw(), cxr_msg);
        log.info("受理编号:" + slbhList);
        tdsyq = tdsyq(slbhList, cxr_msg, 1);
        fdcq = fdcq(slbhList, cxr_msg, 1);
        gjzwsyq = gjzwsyq(slbhList, cxr_msg, 1); // 存有疑问
        dyaq = dyaq(slbhList, cxr_msg, 1);
        ygdj = ygdj(slbhList, cxr_msg, 1);
        cfxh = 1;
        cfdj = cfdj(slbhList, cfxh, cxr_msg, 1);
        yydj = yydj(slbhList, cxr_msg, 1);
        JSONArray json_dataArray = new JSONArray();
        JSONArray json_cxsqjg = new JSONArray();
        CXSQJG cxsqjg = new CXSQJG(cxr_msg.getWsbh(), tdsyq, jsydsyq, fdcq, dyaq, ygdj, cfdj, hysyq, lq, gjzwsyq, yydj, nydsyq);
        log.info("网络直接查询接口权利人反馈报文信息------->>>>>>" + cxsqjg);
        json_cxsqjg.add(cxsqjg);
        json_data.put("cxsqjg", json_cxsqjg);
        json_dataArray.add(json_data);
        return json_dataArray;
    }

    public JSONObject getHouseByPeople(CXR_MSG cxrMsg) {
        JSONObject json_data = new JSONObject();
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
        int cfxh = 1;
        ArrayList<String> slbhList = new ArrayList<String>();
        HandleUtil handleUtil = new HandleUtil();
        slbhList = handleUtil.getSLBH(0, cxrMsg);
        log.info("受理编号:" + slbhList);
        tdsyq = tdsyq(slbhList, cxrMsg, 1);
        fdcq = fdcq(slbhList, cxrMsg, 1);
        gjzwsyq = gjzwsyq(slbhList, cxrMsg, 1); // 存有疑问
        dyaq = dyaq(slbhList, cxrMsg, 1);
        ygdj = ygdj(slbhList, cxrMsg, 1);
        cfxh = 1;
        cfdj = cfdj(slbhList, cfxh, cxrMsg, 1);
        yydj = yydj(slbhList, cxrMsg, 1);
        CXSQJG cxsqjg = new CXSQJG(cxrMsg.getWsbh(), tdsyq, jsydsyq, fdcq, dyaq, ygdj, cfdj, hysyq, lq, gjzwsyq, yydj, nydsyq);
        json_data.put("cxsqjg", cxsqjg);
        return json_data;
    }

    /**
     * 土地所有权
     *
     * @param slbhList
     * @param cxr_msg
     * @return
     */
    private <T> T tdsyq(ArrayList<String> slbhList, CXR_MSG cxr_msg, int direct) {
        log.info("\t\t查询土地使用权...");
        int tdbh = 1;
        // 土地挂到房屋上会出现ql_tdxg中有房屋的slbh但是zf_qsdc中没有土地数据
        ArrayList<TDSYQ> tdsyqs = new ArrayList<>();
        ArrayList<DirectTDSYQ> directTDSYQS = new ArrayList<>();
        for (int i = 0; i < slbhList.size(); i++) {
            List<MTDSYQ> tdsyqList = handleSearch.findTDSYQ(slbhList.get(i));
            for (MTDSYQ mtdsyq : tdsyqList) {
                String bdcdyh = mtdsyq.getBdcdyh() == null ? "" : mtdsyq.getBdcdyh();
                String tstybm = mtdsyq.getTstybm() == null ? "" : mtdsyq.getTstybm();
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = tstybm;
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = "notFound" + tdbh++;
                }
                String zl = mtdsyq.getZl() == null ? "" : mtdsyq.getZl();
                String zdmj = mtdsyq.getZdmj() == null ? "" : mtdsyq.getZdmj();
                String mjdw = "";
                String yt = mtdsyq.getYt() == null ? "" : mtdsyq.getYt();
                String qlxz = mtdsyq.getQlxz() == null ? "" : mtdsyq.getQlxz();
                String qllx = mtdsyq.getQllx() == null ? "" : mtdsyq.getQllx();
                // mjdw = DBUtil.changeMJDW(mjdw);
                yt = Dict.changeYT(yt);
                qlxz = Dict.changeQLXZ(qlxz);
                qllx = Dict.changeQLLX(qllx);
                String bdcqzh = mtdsyq.getBdcqzh() == null ? "" : mtdsyq.getBdcqzh();
                String djjg = mtdsyq.getDjjg() == null ? "" : mtdsyq.getDjjg();
                String djsj = mtdsyq.getDjsj() == null ? "" : mtdsyq.getDjsj();
                djsj = Util.dateFormat(djsj);
                zdmj = Util.getDigitFormat(zdmj);
                String gyfs = mtdsyq.getGyfs() == null ? "" : mtdsyq.getGyfs();
                gyfs = Dict.changeGYFS(gyfs);
                String qsztString = mtdsyq.getQszt() == null ? "" : mtdsyq.getQszt();
                int qszt = 10;
                if (StringUtils.isNotBlank(qsztString)) {
                    qszt = Integer.parseInt(qsztString);
                }
                if (StringUtils.isBlank(qsztString) || qszt == 0) {
                    qsztString = "1";
                } else if (qszt == 1) {
                    qsztString = "2";
                } else if (qszt == -1) {
                    qsztString = "0";
                } else {
                    qsztString = "";
                }
                String ywh = mtdsyq.getYwh() == null ? "" : mtdsyq.getYwh();
                String qxdm = xzqdm;
                String sfdy = "";
                String sfcf = "";
                if (StringUtils.isNotBlank(tstybm)) {
                    sfdy = "0";
                    sfcf = "0";
                    List<DJ_TSGL> djTsgls = handleSearch.findDJ_TSGL(tstybm);
                    for (DJ_TSGL djTsgl : djTsgls) {
                        if ("抵押".equals(djTsgl.getDjzl())) {
                            sfdy = "1";
                        }
                        if ("查封".equals(djTsgl.getDjzl())) {
                            sfcf = "1";
                        }
                    }
                }
                String gyqk = "";
                String gyr = "";
                String qlrdh = "";
                List<GYR> gyrs = handleSearch.findGYQK(slbhList.get(i));
                for (GYR gyrI : gyrs) {
                    if (gyrI != null) {//宿迁此处报错 应该是list中的查询结果都是null list中添加了null对象
                        if (!cxr_msg.getQlrmc().equals(gyrI.getQlrmc())) {
                            gyr = gyrI.getQlrmc() + "," + gyrI.getZjhm() + ";";
                        } else {
                            qlrdh = gyrI.getDh() == null ? "" : gyrI.getDh();
                        }
                        gyqk = gyrI.getQlrmc() + "," + gyrI.getGyfe() + ";";
                    }

                }
                if (direct == 0) {
                    String cxrid = cxr_msg.getId();
                    TDSYQ tdsyq1 = new TDSYQ(UUIDUtils.generateShortUuid(), cxrid, bdcdyh, zl, zdmj, mjdw, yt, qlxz, bdcqzh, djjg, djsj, gyfs, gyr, gyqk, qsztString, ywh, qlrdh, qxdm, qllx, sfdy, sfcf);
                    int flag = 0;
                    for (TDSYQ td : tdsyqs) {
                        if (td.getBdcdyh().equals(tdsyq1.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        tdsyqs.add(tdsyq1);
                    }
                } else {
                    DirectTDSYQ tdsyq = new DirectTDSYQ(bdcdyh, zl, zdmj, mjdw, yt, qlxz, bdcqzh, djjg, djsj, gyfs, gyr, gyqk, qsztString, ywh, qlrdh, qxdm, qllx, sfdy, sfcf);
                    int flag = 0;
                    for (DirectTDSYQ td : directTDSYQS) {
                        if (td.getBdcdyh().equals(tdsyq.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        directTDSYQS.add(tdsyq);
                    }
                }
            }
        }
        if (tdsyqs != null && tdsyqs.size() > 0) {
            if (direct == 0) {
                saveToDB.addTDSYQ(tdsyqs);

            }
        }
        log.info("土地使用权:" + tdsyqs);
        return (T) directTDSYQS;
    }


    /**
     * 房地产权
     *
     * @param slbhList
     * @param cxr_msg
     * @return
     */
    private <T> T fdcq(ArrayList<String> slbhList, CXR_MSG cxr_msg, int direct) {
        log.info("\t\t查询房地产权...");
        int fcbh = 1;
        ArrayList<FDCQ> fdcqs = new ArrayList<>();
        ArrayList<DirectFDCQ> directFDCQS = new ArrayList<>();
        for (int i = 0; i < slbhList.size(); i++) {
            List<MFDCQ> mfdcqs = handleSearch.findFDCQ(slbhList.get(i));
            for (MFDCQ mfdcq : mfdcqs) {
                String bdcdyh = mfdcq.getBdcdyh() == null ? "" : mfdcq.getBdcdyh();
                String tstybm = mfdcq.getTstybm() == null ? "" : mfdcq.getTstybm();
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = tstybm;
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = "notFound" + fcbh++;
                }
                String fdzl = mfdcq.getFdzl() == null ? "" : mfdcq.getFdzl();
                String jzmj = mfdcq.getJzmj() == null ? "" : mfdcq.getJzmj();
                jzmj = Util.getDigitFormat(jzmj);
                String ghyt = mfdcq.getGhyt() == null ? "" : mfdcq.getGhyt();
                String fwxz = mfdcq.getFwxz() == null ? "" : mfdcq.getFwxz();
                ghyt = Dict.changeGHYT(ghyt);
                fwxz = Dict.changeFWXZ(fwxz);
                String jgsj = mfdcq.getJgsj() == null ? "" : mfdcq.getJgsj();
                jgsj = Util.dateFormat(jgsj);
                String tdsyqssj = mfdcq.getTdsyqssj() == null ? "" : mfdcq.getTdsyqssj();
                tdsyqssj = Util.dateFormat(tdsyqssj);
                String tdsyjssj = mfdcq.getTdsyjssj() == null ? "" : mfdcq.getTdsyjssj();
                tdsyjssj = Util.dateFormat(tdsyjssj);
                String bdcqzh = mfdcq.getBdcqzh() == null ? "" : mfdcq.getBdcqzh();
                String djjg = mfdcq.getDjjg() == null ? "" : mfdcq.getDjjg();
                String zyjzmj = mfdcq.getZyjzmj() == null ? "" : mfdcq.getZyjzmj();
                zyjzmj = Util.getDigitFormat(zyjzmj);
                String ftjzmj = mfdcq.getFtjzmj() == null ? "" : mfdcq.getFtjzmj();
                ftjzmj = Util.getDigitFormat(ftjzmj);
                String djsj = mfdcq.getDjsj() == null ? "" : mfdcq.getDjsj();
                djsj = Util.dateFormat(djsj);
                String gyfs = mfdcq.getGyfs() == null ? "" : mfdcq.getGyfs();
                gyfs = Dict.changeGYFS(gyfs);
                String fdcjyjg = mfdcq.getFdcjyjg() == null ? "" : mfdcq.getFdcjyjg();
                fdcjyjg = Util.getDigitFormat(fdcjyjg);
                String fwjg = mfdcq.getFwjg() == null ? "" : mfdcq.getFwjg();
                fwjg = Dict.changeFWJG(fwjg);
                String fwlx = mfdcq.getFwlx() == null ? "" : mfdcq.getFwlx();
                fwlx = Dict.changeFWLX(fwlx);
                String gyqk = "";
                String gyr = "";
                String qlrdh = "";
                List<GYR> gyrs = handleSearch.findGYQK(slbhList.get(i));
                for (GYR gyrI : gyrs) {
                    //有可能此处发生为null 需要做实体类null的判断 泗洪发现此处问题
                    if (gyrI != null) {
                        if (!cxr_msg.getQlrmc().equals(gyrI.getQlrmc())) {
                            gyr = gyrI.getQlrmc() + "," + gyrI.getZjhm() + ";";
                        } else {
                            qlrdh = gyrI.getDh() == null ? "" : gyrI.getDh();
                        }
                        gyqk = gyrI.getQlrmc() + "," + gyrI.getGyfe() + ";";
                    }

                }
                String qsztString = mfdcq.getQszt() == null ? "" : mfdcq.getQszt();
                int qszt = 10;
                if (StringUtils.isNotBlank(qsztString)) {
                    qszt = Integer.parseInt(qsztString);
                }
                if (StringUtils.isBlank(qsztString) || qszt == 0) {
                    qsztString = "1";
                } else if (qszt == 1) {
                    qsztString = "2";
                } else if (qszt == -1) {
                    qsztString = "0";
                } else {
                    qsztString = "";
                }
                String ywh = mfdcq.getYwh() == null ? "" : mfdcq.getYwh();
                String qxdm = xzqdm;
                String qllx = mfdcq.getQllx() == null ? "" : mfdcq.getQllx();
                qllx = Dict.changeQLLX(qllx);
                String sfdy = "";
                String sfcf = "";
                if (StringUtils.isNotBlank(tstybm)) {
                    sfdy = "0";
                    sfcf = "0";
                    List<DJ_TSGL> djTsgls = handleSearch.findDJ_TSGL(tstybm);
                    for (DJ_TSGL djTsgl : djTsgls) {
                        if ("抵押".equals(djTsgl.getDjzl())) {
                            sfdy = "1";
                        }
                        if ("查封".equals(djTsgl.getDjzl())) {
                            sfcf = "1";
                        }
                    }
                }
                String tdqlxz = mfdcq.getTdqlxz() == null ? "" : mfdcq.getTdqlxz();
                String tdsyqr = mfdcq.getTdsyqr() == null ? "" : mfdcq.getTdsyqr();
                String dytdmj = mfdcq.getDytdmj() == null ? "" : mfdcq.getDytdmj();
                dytdmj = Util.getDigitFormat(dytdmj);
                String fttdmj = mfdcq.getFttdmj() == null ? "" : mfdcq.getFttdmj();
                fttdmj = Util.getDigitFormat(fttdmj);
                if (direct == 0) {
                    String cxrid = cxr_msg.getId();
                    FDCQ fdcq = new FDCQ(UUIDUtils.generateShortUuid(), cxrid, bdcdyh, fdzl, jzmj, ghyt, fwxz, jgsj, tdsyqssj, tdsyjssj, bdcqzh, djjg, zyjzmj, ftjzmj, djsj, gyfs, fdcjyjg, fwjg, fwlx, gyr, gyqk, qsztString, ywh, qlrdh, qxdm, qllx, sfdy, sfcf, tdqlxz, tdsyqr, dytdmj, fttdmj);
                    int flag = 0;
                    for (FDCQ fc : fdcqs) {
                        if (fc.getBdcdyh().equals(fdcq.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        fdcqs.add(fdcq);
                    }
                } else {
                    DirectFDCQ fdcq = new DirectFDCQ(bdcdyh, fdzl, jzmj, ghyt, fwxz, jgsj, tdsyqssj, tdsyjssj, bdcqzh, djjg, zyjzmj, ftjzmj, djsj, gyfs, fdcjyjg, fwjg, fwlx, gyr, gyqk, qsztString, ywh, qlrdh, qxdm, qllx, sfdy, sfcf, tdqlxz, tdsyqr, dytdmj, fttdmj);
                    int flag = 0;
                    for (DirectFDCQ fc : directFDCQS) {
                        if (fc.getBdcdyh().equals(fdcq.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        directFDCQS.add(fdcq);
                    }
                }
            }
        }
        if (fdcqs != null && fdcqs.size() > 0) {
            if (direct == 0) {
                saveToDB.addFDCQ(fdcqs);
            }
        }
        log.info("房地产权:" + fdcqs);
        return (T) directFDCQS;
    }

    /**
     * 构建筑物所有权
     *
     * @param slbhList
     * @param cxr_msg
     * @return
     */
    private <T> T gjzwsyq(ArrayList<String> slbhList, CXR_MSG cxr_msg, int direct) {
        log.info("\t\t查询构建筑物所有权...");
        int gjzwbh = 1;
        ArrayList<GJZWSYQ> gjzwsyqs = new ArrayList<>();
        ArrayList<DirectGJZWSYQ> directGJZWSYQS = new ArrayList<>();
        for (int i = 0; i < slbhList.size(); i++) {
            List<MGJZWSYQ> mgjzwsyqs = handleSearch.findGJZWSYQ(slbhList.get(i));
            for (MGJZWSYQ mgjzwsyq : mgjzwsyqs) {
                String bdcdyh = mgjzwsyq.getBdcdyh() == null ? "" : mgjzwsyq.getBdcdyh();
                String tstybm = mgjzwsyq.getTstybm() == null ? "" : mgjzwsyq.getTstybm();
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = tstybm;
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = "notFound" + gjzwbh++;
                }
                String zl = mgjzwsyq.getZl() == null ? "" : mgjzwsyq.getZl();
                String gjzwghyt = mgjzwsyq.getGjzwghyt() == null ? "" : mgjzwsyq.getGjzwghyt();
                gjzwghyt = Dict.changeGHYT(gjzwghyt);
                String gjzwmj = mgjzwsyq.getGjzwmj() == null ? "" : mgjzwsyq.getGjzwmj();
                gjzwmj = Util.getDigitFormat(gjzwmj);
                String tdhysyqssj = mgjzwsyq.getTdhysyqssj() == null ? "" : mgjzwsyq.getTdhysyqssj();
                tdhysyqssj = Util.dateFormat(tdhysyqssj);
                String tdhysyjssj = mgjzwsyq.getTdhysyjssj() == null ? "" : mgjzwsyq.getTdhysyjssj();
                tdhysyjssj = Util.dateFormat(tdhysyjssj);
                String bdcqzh = mgjzwsyq.getBdcqzh() == null ? "" : mgjzwsyq.getBdcqzh();
                String djjg = mgjzwsyq.getDjjg() == null ? "" : mgjzwsyq.getDjjg();
                String djsj = mgjzwsyq.getDjsj() == null ? "" : mgjzwsyq.getDjsj();
                djsj = Util.dateFormat(djsj);
                String gyfs = mgjzwsyq.getGyfs() == null ? "" : mgjzwsyq.getGyfs();
                gyfs = Dict.changeGYFS(gyfs);
                String gyqk = "";
                String gyr = "";
                String qlrdh = "";
                List<GYR> gyrs = handleSearch.findGYQK(slbhList.get(i));
                for (GYR gyrI : gyrs) {
                    if (!cxr_msg.getQlrmc().equals(gyrI.getQlrmc())) {
                        gyr = gyrI.getQlrmc() + "," + gyrI.getZjhm() + ";";
                    } else {
                        qlrdh = gyrI.getDh() == null ? "" : gyrI.getDh();
                    }
                    gyqk = gyrI.getQlrmc() + "," + gyrI.getGyfe() + ";";
                }
                String qsztString = mgjzwsyq.getQszt() == null ? "" : mgjzwsyq.getQszt();
                int qszt = 10;
                if (StringUtils.isNotBlank(qsztString)) {
                    qszt = Integer.parseInt(qsztString);
                }
                if (StringUtils.isBlank(qsztString) || qszt == 0) {
                    qsztString = "1";
                } else if (qszt == 1) {
                    qsztString = "2";
                } else if (qszt == -1) {
                    qsztString = "0";
                } else {
                    qsztString = "";
                }
                String ywh = mgjzwsyq.getYwh() == null ? "" : mgjzwsyq.getYwh();
                String qxdm = xzqdm;
                String gjzwlx = mgjzwsyq.getGjzwlx() == null ? "" : mgjzwsyq.getGjzwlx();
                String qllx = mgjzwsyq.getQllx() == null ? "" : mgjzwsyq.getQllx();
                qllx = Dict.changeQLLX(qllx);
                String sfdy = "";
                String sfcf = "";
                if (StringUtils.isNotBlank(tstybm)) {
                    sfdy = "0";
                    sfcf = "0";
                    List<DJ_TSGL> djTsgls = handleSearch.findDJ_TSGL(tstybm);
                    for (DJ_TSGL djTsgl : djTsgls) {
                        if ("抵押".equals(djTsgl.getDjzl())) {
                            sfdy = "1";
                        }
                        if ("查封".equals(djTsgl.getDjzl())) {
                            sfcf = "1";
                        }
                    }
                }

                String tdhysyqr = mgjzwsyq.getTdhysyqr() == null ? "" : mgjzwsyq.getTdhysyqr();
                String tdhysymj = mgjzwsyq.getTdhysymj() == null ? "" : mgjzwsyq.getTdhysymj();
                tdhysymj = Util.getDigitFormat(tdhysymj);
                if (direct == 0) {
                    String cxrid = cxr_msg.getId();
                    GJZWSYQ gjzwsyq = new GJZWSYQ(UUIDUtils.generateShortUuid(), cxrid, bdcdyh, zl, gjzwghyt, gjzwmj, tdhysyqssj, tdhysyjssj, bdcqzh, djjg, djsj, gyfs, gyr, gyqk, qsztString, ywh, qlrdh, qxdm, gjzwlx, qllx, sfdy, sfcf, tdhysyqr, tdhysymj);
                    int flag = 0;
                    for (GJZWSYQ g : gjzwsyqs) {
                        if (g.getBdcdyh().equals(gjzwsyq.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        gjzwsyqs.add(gjzwsyq);
                    }
                } else {
                    DirectGJZWSYQ gjzwsyq = new DirectGJZWSYQ(bdcdyh, zl, gjzwghyt, gjzwmj, tdhysyqssj, tdhysyjssj, bdcqzh, djjg, djsj, gyfs, gyr, gyqk, qsztString, ywh, qlrdh, qxdm, gjzwlx, qllx, sfdy, sfcf, tdhysyqr, tdhysymj);
                    int flag = 0;
                    for (DirectGJZWSYQ g : directGJZWSYQS) {
                        if (g.getBdcdyh().equals(gjzwsyq.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        directGJZWSYQS.add(gjzwsyq);
                    }
                }
            }
        }
        if (gjzwsyqs != null && gjzwsyqs.size() > 0) {
            if (direct == 0) {
                saveToDB.addGJZWSYQ(gjzwsyqs);

            }
        }
        log.info("构建筑物所有权:" + gjzwsyqs);
        return (T) directGJZWSYQS;
    }


    /**
     * 抵押权
     *
     * @param slbhList
     * @param
     * @param cxr_msg
     * @return
     */
    private <T> T dyaq(ArrayList<String> slbhList, CXR_MSG cxr_msg, int direct) {
        log.info("\t\t查询抵押权...");
        int dybh = 1;
        ArrayList<DYAQ> dyaqs = new ArrayList<>();
        ArrayList<DirectDYAQ> directDYAQS = new ArrayList<>();
        for (int i = 0; i < slbhList.size(); i++) {
            List<MDYAQ> mdyaqs = handleSearch.findDYAQ(slbhList.get(i));
            for (MDYAQ mdyaq : mdyaqs) {
                String bdcdyh = "";
                String tstybm = mdyaq.getTstybm() == null ? "" : mdyaq.getTstybm();
                String zl = "";
                String dybdclx = mdyaq.getDybdclx() == null ? "" : mdyaq.getDybdclx();
                if ("宗地".equals(dybdclx)) {
                    List<TDXG> tdxgs = handleSearch.findTDXG(tstybm);
                    if (tdxgs.size() > 0 && tdxgs.get(0) != null) { //睢宁此处空指针
                        TDXG tdxg = tdxgs.get(0);
                        bdcdyh = tdxg.getBdcdyh();
                        tstybm = tdxg.getTstybm();
                        zl = tdxg.getZl();
                    }
                } else {
                    List<FWXG> fwxgs = handleSearch.findFWXG(tstybm);
                    if (fwxgs.size() > 0 && fwxgs.get(0) != null) { //未发现null 提前预防
                        FWXG fwxg = fwxgs.get(0);
                        bdcdyh = fwxg.getBdcdyh();
                        tstybm = fwxg.getTstybm();
                        zl = fwxg.getZl();
                    }
                }
                dybdclx = Dict.changeDYBDCLX(dybdclx);
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = tstybm;
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = "notFound" + dybh++;
                }
                String dyr = cxr_msg.getQlrmc();
                String dyfs = mdyaq.getDyfs() == null ? "" : mdyaq.getDyfs();
                dyfs = Dict.changeDYFS(dyfs);
                String bdbzzqse = mdyaq.getBdbzzqse() == null ? "" : mdyaq.getBdbzzqse();
                bdbzzqse = Util.getDigitFormat(bdbzzqse);

                String zwlxqssj = mdyaq.getZwlxqssj() == null ? "" : mdyaq.getZwlxqssj();
                zwlxqssj = Util.dateFormat(zwlxqssj);
                String zwlxjssj = mdyaq.getZwlxjssj() == null ? "" : mdyaq.getZwlxjssj();
                zwlxjssj = Util.dateFormat(zwlxjssj);
                String bdcdjzmh = mdyaq.getBdcdjzmh();
                String djjg = mdyaq.getDjjg() == null ? "" : mdyaq.getDjjg();
                String djsj = mdyaq.getDjsj() == null ? "" : mdyaq.getDjsj();
                djsj = Util.dateFormat(djsj);
                String dyqr = "";
                List<String> strings = handleSearch.findDYQR(slbhList.get(i));
                if (strings.size() > 0 && strings.get(0) != null) {//未发现异常，提前预防
                    dyqr = strings.get(0);
                }
                dyqr = dyqr == null ? "" : dyqr;
                ZX zx = new ZX();
                List<ZX> zxs = handleSearch.zxdj(slbhList.get(i));
                if (zxs.size() > 0 && zxs.get(0) != null) {
                    zx = zxs.get(0);
                }
                String zxsj = zx.getDjsj() == null ? "" : zx.getDjsj();
                zxsj = Util.dateFormat(zxsj);
                String ywh = mdyaq.getYwh() == null ? "" : mdyaq.getYwh();
                String qxdm = xzqdm;
                String qsztString = mdyaq.getQszt() == null ? "" : mdyaq.getQszt();
                int qszt = 10;
                if (StringUtils.isNotBlank(qsztString)) {
                    qszt = Integer.parseInt(qsztString);
                }
                if (StringUtils.isBlank(qsztString) || qszt == 0) {
                    qsztString = "1";
                } else if (qszt == 1) {
                    qsztString = "2";
                } else if (qszt == -1) {
                    qsztString = "0";
                } else {
                    qsztString = "";
                }
                String zjjzwzl = mdyaq.getZjjzwzl() == null ? "" : mdyaq.getZjjzwzl();
                String zjjzwdyfw = mdyaq.getZjjzwdyfw() == null ? "" : mdyaq.getZjjzwdyfw();
                String zgzqse = mdyaq.getZgzqse() == null ? "" : mdyaq.getZgzqse();
                if (direct == 0) {
                    String cxrid = cxr_msg.getId();
                    DYAQ dyaq = new DYAQ(UUIDUtils.generateShortUuid(), cxrid, bdcdyh, dybdclx, zl, dyr, dyfs, bdbzzqse, zwlxqssj, zwlxjssj, bdcdjzmh, djjg, djsj, dyqr, zxsj, ywh, qsztString, qxdm, zjjzwzl, zjjzwdyfw, zgzqse);
                    dyaqs.add(dyaq);
                } else {
                    DirectDYAQ dyaq = new DirectDYAQ(bdcdyh, dybdclx, zl, dyr, dyfs, bdbzzqse, zwlxqssj, zwlxjssj, bdcdjzmh, djjg, djsj, dyqr, zxsj, ywh, qsztString, qxdm, zjjzwzl, zjjzwdyfw, zgzqse);
                    directDYAQS.add(dyaq);
                }
            }
        }
        if (dyaqs != null && dyaqs.size() > 0) {
            if (direct == 0) {
                saveToDB.addDYAQ(dyaqs);

            }
        }
        log.info("抵押权:" + dyaqs);
        return (T) directDYAQS;
    }

    /**
     * 预告登记
     *
     * @param slbhList
     * @param cxr_msg
     * @return
     */
    private <T> T ygdj(ArrayList<String> slbhList, CXR_MSG cxr_msg, int direct) {
        log.info("\t\t查询预告登记...");
        int ygbh = 1;
        ArrayList<YGDJ> ygdjs = new ArrayList<YGDJ>();
        ArrayList<DirectYGDJ> directYGDJS = new ArrayList<>();
        for (int i = 0; i < slbhList.size(); i++) {
            List<MYGDJ> mygdjs = handleSearch.findYGDJ(slbhList.get(i));
            for (MYGDJ mygdj : mygdjs) {
                String tstybm = mygdj.getTstybm() == null ? "" : mygdj.getTstybm();
                YGFWXG ygfwxg = new YGFWXG();
                List<YGFWXG> ygfwxgs = handleSearch.findYGFWXG(tstybm);
                if (ygfwxgs.size() > 0 && ygfwxgs.get(0) != null) {//判断第一个对象是非空对象 徐州出现此处空指针
                    ygfwxg = ygfwxgs.get(0);
                }
                String bdcdyh = ygfwxg.getBdcdyh() == null ? "" : ygfwxg.getBdcdyh();
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = tstybm;
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = "notFound" + ygbh++;
                }
                String ygdjzl = mygdj.getYgdjzl() == null ? "" : mygdj.getYgdjzl();
                ygdjzl = Dict.changeYGDJZL(ygdjzl);

                String zl = ygfwxg.getZl() == null ? "" : ygfwxg.getZl();
                String ghyt = ygfwxg.getGhyt() == null ? "" : ygfwxg.getGhyt();
                ghyt = Dict.changeGHYT(ghyt);
                String jzmj = ygfwxg.getJzmj() == null ? "" : ygfwxg.getJzmj();
                jzmj = Util.getDigitFormat(jzmj);
                String bdcdjzmh = mygdj.getBdcdjzmh() == null ? "" : mygdj.getBdcdjzmh();
                String djjg = mygdj.getDjjg() == null ? "" : mygdj.getDjjg();
                String djsj = mygdj.getDjsj() == null ? "" : mygdj.getDjsj();
                djsj = Util.dateFormat(djsj);
                ZX zx = new ZX();
                List<ZX> zxs = handleSearch.zxdj(slbhList.get(i));
                if (zxs.size() > 0 && zxs.get(0) != null) {
                    zx = zxs.get(0);
                }
                String zxsj = zx.getDjsj() == null ? "" : zx.getDjsj();
                zxsj = Util.dateFormat(zxsj);
                String ywh = mygdj.getYwh() == null ? "" : mygdj.getYwh();
                String gyfs = mygdj.getGyfs() == null ? "" : mygdj.getGyfs();
                gyfs = Dict.changeGYFS(gyfs);
                String qxdm = xzqdm;
                String gyqk = "";
                String gyr = "";
                String qlrdh = "";
                List<GYR> gyrs = handleSearch.findGYQK(slbhList.get(i));
                for (GYR gyrI : gyrs) {
                    if (!cxr_msg.getQlrmc().equals(gyrI.getQlrmc())) {
                        gyr = gyrI.getQlrmc() + "," + gyrI.getZjhm() + ";";
                    } else {
                        qlrdh = gyrI.getDh() == null ? "" : gyrI.getDh();
                    }
                    gyqk = gyrI.getQlrmc() + "," + gyrI.getGyfe() + ";";
                }
                String qsztString = mygdj.getQszt() == null ? "" : mygdj.getQszt();
                int qszt = 10;
                if (StringUtils.isNotBlank(qsztString)) {
                    qszt = Integer.parseInt(qsztString);
                }
                if (StringUtils.isBlank(qsztString) || qszt == 0) {
                    qsztString = "1";
                } else if (qszt == 1) {
                    qsztString = "2";
                } else if (qszt == -1) {
                    qsztString = "0";
                } else {
                    qsztString = "";
                }
                YWR ywrObject = new YWR();
                List<YWR> ywrs = handleSearch.findYWR(slbhList.get(i));
                if (ywrs.size() > 0 && ywrs.get(0) != null) {//未发现异常 提前预防
                    ywrObject = ywrs.get(0);
                }
                String ywr = ywrObject.getQlrmc() == null ? "" : ywrObject.getQlrmc();
                String ywrzjzl = ywrObject.getZjzl() == null ? "" : ywrObject.getZjzl();
                ywrzjzl = Dict.changeZJZL(ywrzjzl);
                String ywrzjh = ywrObject.getZjhm() == null ? "" : ywrObject.getZjhm();
                String tdsyqr = ygfwxg.getTdsyqr() == null ? "" : ygfwxg.getTdsyqr();
                String fwxz = ygfwxg.getFwxz() == null ? "" : ygfwxg.getFwxz();
                fwxz = Dict.changeFWXZ(fwxz);
                String fwjg = ygfwxg.getFwjg() == null ? "" : ygfwxg.getFwjg();
                fwjg = Dict.changeFWJG(fwjg);
                String qdjg = ygfwxg.getQdjg() == null ? "" : ygfwxg.getQdjg();
                if (direct == 0) {
                    String cxrid = cxr_msg.getId();
                    YGDJ ygdj = new YGDJ(UUIDUtils.generateShortUuid(), cxrid, bdcdyh, ygdjzl, zl, ghyt, jzmj, bdcdjzmh, djjg, djsj, zxsj, ywh, qsztString, qlrdh, qxdm, gyfs, gyr, gyqk, ywr, ywrzjzl, ywrzjh, tdsyqr, fwxz, fwjg, qdjg);
                    int flag = 0;
                    for (YGDJ yg : ygdjs) {
                        if (yg.getBdcdyh().equals(ygdj.getBdcdyh()) && yg.getBdcdjzmh().equals(ygdj.getBdcdjzmh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        ygdjs.add(ygdj);
                    }
                } else {
                    DirectYGDJ ygdj = new DirectYGDJ(bdcdyh, ygdjzl, zl, ghyt, jzmj, bdcdjzmh, djjg, djsj, zxsj, ywh, qsztString, qlrdh, qxdm, gyfs, gyr, gyqk, ywr, ywrzjzl, ywrzjh, tdsyqr, fwxz, fwjg, qdjg);
                    int flag = 0;
                    for (DirectYGDJ yg : directYGDJS) {
                        if (yg.getBdcdyh().equals(ygdj.getBdcdyh()) && yg.getBdcdjzmh().equals(ygdj.getBdcdjzmh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        directYGDJS.add(ygdj);
                    }
                }
            }
        }
        if (ygdjs != null && ygdjs.size() > 0) {
            if (direct == 0) {
                saveToDB.addYGDJ(ygdjs);
            }
        }
        log.info("预告登记:" + ygdjs);
        return (T) directYGDJS;
    }

    /**
     * 查封登记
     *
     * @param slbhList
     * @param cfxh
     * @param cxr_msg
     * @return
     */
    private <T> T cfdj(ArrayList<String> slbhList, int cfxh, CXR_MSG cxr_msg, int direct) {
        log.info("\t\t查询查封登记...");
        int cfbh = 1;
        ArrayList<CFDJ> cfdjs = new ArrayList<CFDJ>();
        ArrayList<DirectCFDJ> directCFDJS = new ArrayList<>();
        for (int i = 0; i < slbhList.size(); i++) {
            List<MCFDJ> mcfdjs = handleSearch.findCFDJ(slbhList.get(i));
            for (MCFDJ mcfdj : mcfdjs) {
                String bdclx = mcfdj.getBdclx() == null ? "" : mcfdj.getBdclx();
                String bdcdyh = mcfdj.getBdcdyh() == null ? "" : mcfdj.getBdcdyh();
                String tstybm = mcfdj.getTstybm() == null ? "" : mcfdj.getTstybm();
                String zl = "";
                if ("宗地".equals(bdclx)) {
                    List<TDXG> tdxgs = handleSearch.findTDXG(tstybm);
                    if (tdxgs.size() > 0 && tdxgs.get(0) != null) { //宿迁此处报null已修改
                        TDXG tdxg = tdxgs.get(0);
                        zl = tdxg.getZl();
                    }
                } else {
                    List<FWXG> fwxgs = handleSearch.findFWXG(tstybm);
                    if (fwxgs.size() > 0 && fwxgs.get(0) != null) { //宿迁此处报null已修改
                        FWXG fwxg = fwxgs.get(0);
                        zl = fwxg.getZl();
                    }
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = tstybm;
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = "notFound" + cfbh++;
                }
                String cfjg = mcfdj.getCfjg() == null ? "" : mcfdj.getCfjg();
                String cflx = mcfdj.getCflx() == null ? "" : mcfdj.getCflx();
                cflx = Dict.changeCFLX(cflx);
                String cfwh = mcfdj.getCfwh() == null ? "" : mcfdj.getCfwh();
                String cfqssj = mcfdj.getCfqssj() == null ? "" : mcfdj.getCfqssj();
                cfqssj = Util.dateFormat(cfqssj);
                String cfjssj = mcfdj.getCfjssj() == null ? "" : mcfdj.getCfjssj();
                cfjssj = Util.dateFormat(cfjssj);
                String djjg = mcfdj.getDjjg() == null ? "" : mcfdj.getDjjg();
                String djsj = mcfdj.getDjsj() == null ? "" : mcfdj.getDjsj();
                djsj = Util.dateFormat(djsj);
                String ywh = mcfdj.getYwh() == null ? "" : mcfdj.getYwh();
                String qsztString = mcfdj.getQszt() == null ? "" : mcfdj.getQszt();
                int qszt = 10;
                if (StringUtils.isNotBlank(qsztString)) {
                    qszt = Integer.parseInt(qsztString);
                }
                if (StringUtils.isBlank(qsztString) || qszt == 0) {
                    qsztString = "1";
                } else if (qszt == 1) {
                    qsztString = "2";
                } else if (qszt == -1) {
                    qsztString = "0";
                } else {
                    qsztString = "";
                }
                String qxdm = xzqdm;
                String cffw = mcfdj.getCffw() == null ? "" : mcfdj.getCffw();
                List<ZX> zxs = handleSearch.zxdj(slbhList.get(i));
                ZX zx = new ZX();
                if (zxs.size() > 0 && zxs.get(0) != null) {//未发现异常 提前异常
                    zx = zxs.get(0);
                }
                String jfdjsj = zx.getDjsj() == null ? "" : zx.getDjsj();
                jfdjsj = Util.dateFormat(jfdjsj);
                String jfwh = zx.getXgwh() == null ? "" : zx.getXgwh();
                if (direct == 0) {
                    String cxrid = cxr_msg.getId();
                    CFDJ cfdj = new CFDJ(UUIDUtils.generateShortUuid(), cxrid, bdcdyh, zl, cfjg, cflx, cfwh, cfqssj, cfjssj, djjg, cfxh, djsj, jfdjsj, ywh, qsztString, qxdm, cffw, jfwh);
                    cfdjs.add(cfdj);
                    cfxh++;
                } else {
                    DirectCFDJ cfdj = new DirectCFDJ(bdcdyh, zl, cfjg, cflx, cfwh, cfqssj, cfjssj, djjg, cfxh, djsj, jfdjsj, ywh, qsztString, qxdm, cffw, jfwh);
                    directCFDJS.add(cfdj);
                    cfxh++;
                }
            }
        }
        if (cfdjs != null && cfdjs.size() > 0) {
            if (direct == 0) {
                saveToDB.addCFDJ(cfdjs);
            }
        }
        log.info("查封登记:" + cfdjs);
        return (T) directCFDJS;
    }

    /**
     * 异议登记
     *
     * @param slbhList
     * @param cxr_msg
     * @return
     */
    private <T> T yydj(ArrayList<String> slbhList, CXR_MSG cxr_msg, int direct) {
        log.info("\t\t查询异议登记...");
        int yybh = 1;
        ArrayList<DirectYYDJ> directYYDJS = new ArrayList<>();
        ArrayList<YYDJ> yydjs = new ArrayList<YYDJ>();
        for (int i = 0; i < slbhList.size(); i++) {
            List<MYYDJ> myydjs = handleSearch.findYYDJ(slbhList.get(i));
            for (MYYDJ myydj : myydjs) {
                String bdclx = myydj.getBdclx() == null ? "" : myydj.getBdclx();
                String bdcdyh = myydj.getBdcdyh() == null ? "" : myydj.getBdcdyh();
                String tstybm = myydj.getTstybm() == null ? "" : myydj.getTstybm();
                String zl = "";
                List<TDXG> tdxgs = handleSearch.findTDXG(tstybm);
                if ("宗地".equals(bdclx)) {
                    if (tdxgs.size() > 0 && tdxgs.get(0) != null) {//未发现异常 提前预防
                        TDXG tdxg = tdxgs.get(0);
                        zl = tdxg.getZl();
                    }
                } else {
                    List<FWXG> fwxgs = handleSearch.findFWXG(tstybm);
                    if (fwxgs.size() > 0 && fwxgs.get(0) != null) {//未发现异常 提前预防
                        FWXG fwxg = fwxgs.get(0);
                        zl = fwxg.getZl();
                    }
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = tstybm;
                }
                if (StringUtils.isBlank(bdcdyh)) {
                    bdcdyh = "notFound" + yybh++;
                }
                String yysx = myydj.getYysx() == null ? "" : myydj.getYysx();
                String bdcdjzmh = myydj.getBdcdjzmh() == null ? "" : myydj.getBdcdjzmh();
                String djjg = myydj.getDjjg() == null ? "" : myydj.getDjjg();
                String djsj = myydj.getDjsj() == null ? "" : myydj.getDjsj();
                djsj = Util.dateFormat(djsj);
                List<ZX> zxs = handleSearch.zxdj(slbhList.get(i));
                ZX zx = new ZX();
                if (zxs.size() > 0 && zxs.get(0) != null) {//未发现异常，提前预防
                    zx = zxs.get(0);
                }
                String zxsj = zx.getDjsj() == null ? "" : zx.getDjsj();
                zxsj = Util.dateFormat(zxsj);
                String ywh = myydj.getYwh() == null ? "" : myydj.getYwh();
                String qsztString = myydj.getQszt() == null ? "" : myydj.getQszt();
                int qszt = 10;
                if (StringUtils.isNotBlank(qsztString)) {
                    qszt = Integer.parseInt(qsztString);
                }
                if (StringUtils.isBlank(qsztString) || qszt == 0) {
                    qsztString = "1";
                } else if (qszt == 1) {
                    qsztString = "2";
                } else if (qszt == -1) {
                    qsztString = "0";
                } else {
                    qsztString = "";
                }
                String qxdm = xzqdm;
                if (direct == 0) {
                    String cxrid = cxr_msg.getId();
                    YYDJ yydj = new YYDJ(UUIDUtils.generateShortUuid(), cxrid, bdcdyh, zl, yysx, bdcdjzmh, djjg, djsj, qsztString, ywh, zxsj, qxdm);
                    int flag = 0;
                    for (YYDJ yy : yydjs) {
                        if (yy.getBdcdyh().equals(yydj.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        yydjs.add(yydj);
                    }
                } else {
                    DirectYYDJ yydj = new DirectYYDJ(bdcdyh, zl, yysx, bdcdjzmh, djjg, djsj, qsztString, ywh, zxsj, qxdm);
                    int flag = 0;
                    for (DirectYYDJ yy : directYYDJS) {
                        if (yy.getBdcdyh().equals(yydj.getBdcdyh())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        directYYDJS.add(yydj);
                    }
                }
            }
        }
        if (yydjs != null && yydjs.size() > 0) {
            if (direct == 0) {
                saveToDB.addYYDJ(yydjs);
            }
        }
        log.info("异议登记:" + yydjs);
        return (T) yydjs;
    }
}
