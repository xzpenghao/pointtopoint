package com.ztgeo.pointtopoint.handle;

import com.ztgeo.pointtopoint.controller.entity.*;
import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.entity.SLBH;
import com.ztgeo.pointtopoint.handle.entity.*;
import com.ztgeo.pointtopoint.handle.middleEntity.DJ_TSGL;
import com.ztgeo.pointtopoint.handle.middleEntity.*;
import com.ztgeo.pointtopoint.service.mainService.*;
import com.ztgeo.pointtopoint.utils.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理主查询数据库的交互数据查询，mybatis
 */
@Component
public class HandleSearch {

    private static HandleService handleService;//获取受理编号与注销登记信息
    private static CXR_MSGService cxrMsgService;//取出申请查询人数据
    private static TDSYQService tdsyqService;//土地所有权
    private static FDCQService fdcqService;//房地产权
    private static GJZWSYQService gjzwsyqService;//构建筑物所有权
    private static DJ_TSGLService djTsglService;//图属关联，去除非本人所有宗地受理编号
    private static GYRService gyrService;//共有人
    private static DYAQService dyaqService;//抵押权
    private static YGDJService ygdjService;//预告登记
    private static CFDJService cfdjService;//查封登记
    private static YYDJService yydjService;//异议登记
    private Dict dict = new Dict();

    @Autowired
    public void setHandleService(HandleService handleService) {
        HandleSearch.handleService = handleService;
    }

    @Autowired
    public void setCxrMsgService(CXR_MSGService cxrMsgService) {
        HandleSearch.cxrMsgService = cxrMsgService;
    }

    @Autowired
    public void setTdsyqService(TDSYQService tdsyqService) {
        HandleSearch.tdsyqService = tdsyqService;
    }

    @Autowired
    public void setFdcqService(FDCQService fdcqService) {
        HandleSearch.fdcqService = fdcqService;
    }

    @Autowired
    public void setGjzwsyqService(GJZWSYQService gjzwsyqService) {
        HandleSearch.gjzwsyqService = gjzwsyqService;
    }

    @Autowired
    public void setDjTsglService(DJ_TSGLService djTsglService) {
        HandleSearch.djTsglService = djTsglService;
    }

    @Autowired
    public void setGyrService(GYRService gyrService) {
        HandleSearch.gyrService = gyrService;
    }

    @Autowired
    public void setDyaqService(DYAQService dyaqService) {
        HandleSearch.dyaqService = dyaqService;
    }

    @Autowired
    public void setYgdjService(YGDJService ygdjService) {
        HandleSearch.ygdjService = ygdjService;
    }

    @Autowired
    public void setCfdjService(CFDJService cfdjService) {
        HandleSearch.cfdjService = cfdjService;
    }

    @Autowired
    public void setYydjService(YYDJService yydjService) {
        HandleSearch.yydjService = yydjService;
    }

    public List<SLBH> findSLBH(CXR_MSG cxr_msg) {
        return handleService.findSLBH(cxr_msg);
    }

    public List<ZX> zxdj(String slbh) {
        return handleService.zxdj(slbh);
    }

    public List<MTDSYQ> findTDSYQ(String slbh) {
        return tdsyqService.findTDSYQ(slbh);
    }

    public List<MFDCQ> findFDCQ(String slbh) {
        return fdcqService.findFDCQ(slbh);
    }

    public List<MGJZWSYQ> findGJZWSYQ(String slbh) {
        return gjzwsyqService.findGJZWSYQ(slbh);
    }

    public List<DJ_TSGL> findDJ_TSGL(String tstybm) {
        return djTsglService.judgyCFOrDY(tstybm);
    }

    public List<GYR> findGYQK(String slbh) {
        return gyrService.findGYQK(slbh);
    }

    public List<MDYAQ> findDYAQ(String slbh) {
        return dyaqService.findDYAQ(slbh);
    }

    public List<FWXG> findFWXG(String tstybm) {
        return dyaqService.findFWXG(tstybm);
    }

    public List<TDXG> findTDXG(String tstybm) {
        return dyaqService.findTDXG(tstybm);
    }

    public List<String> findDYQR(String slbh) {
        return dyaqService.findDYQR(slbh);
    }

    public List<MYGDJ> findYGDJ(String slbh) {
        return ygdjService.findYGDJ(slbh);
    }

    public List<YGFWXG> findYGFWXG(String tstybm) {
        return ygdjService.findYGFWXG(tstybm);
    }

    public List<YWR> findYWR(String slbh) {
        return ygdjService.findYWR(slbh);
    }

    public List<MCFDJ> findCFDJ(String slbh) {
        return cfdjService.findCFDJ(slbh);
    }

    public List<MYYDJ> findYYDJ(String slbh) {
        return yydjService.findYYDJ(slbh);
    }


    public List<DirectTDSYQ> selectTDSYQsByCXRId(String cxrid) {
        List<DirectTDSYQ> tdsyqs = tdsyqService.selectTDSYQsByCXRId(cxrid);
        List<DirectTDSYQ> tdsyqs1 = new ArrayList<>();
        for (DirectTDSYQ tdsyq : tdsyqs) {
            DirectTDSYQ tdsyq1 = dict.tdsyqConversion(tdsyq);
            if (!tdsyqs1.contains(tdsyq1)) {
                tdsyqs1.add(tdsyq1);
            }
        }
        return tdsyqs1;
    }


    public List<DirectFDCQ> selectFDCQsByCXRId(String cxrid) {
        List<DirectFDCQ> directFDCQS = fdcqService.selectFDCQsByCXRId(cxrid);
        List<DirectFDCQ> directFDCQS1 = new ArrayList<>();
        for (DirectFDCQ directFDCQ : directFDCQS) {
            DirectFDCQ directFDCQ1 = dict.fdcqConversion(directFDCQ);
            if (!directFDCQS1.contains(directFDCQ1)) {
                directFDCQS1.add(directFDCQ1);
            }
        }
        return directFDCQS1;
    }

    public List<DirectGJZWSYQ> selectGJZWSYQsByCXRId(String cxrid) {
        List<DirectGJZWSYQ> directGJZWSYQS = gjzwsyqService.selectGJZWSYQsByCXRId(cxrid);
        List<DirectGJZWSYQ> directGJZWSYQS1 = new ArrayList<>();
        for (DirectGJZWSYQ directGJZWSYQ : directGJZWSYQS) {
            DirectGJZWSYQ directGJZWSYQ1 = dict.gjzwsyqConversion(directGJZWSYQ);
            if (!directGJZWSYQS1.contains(directGJZWSYQ1)) {
                directGJZWSYQS1.add(directGJZWSYQ1);
            }
        }
        return directGJZWSYQS1;
    }

    public List<DirectDYAQ> selectDYAQsByCXRId(String cxrid) {
        List<DirectDYAQ> directDYAQS = dyaqService.selectDYAQsByCXRId(cxrid);
        List<DirectDYAQ> directDYAQS1 = new ArrayList<>();
        for (DirectDYAQ directDYAQ : directDYAQS) {
            DirectDYAQ directDYAQ1 = dict.dyaqConversion(directDYAQ);
            if (!directDYAQS1.contains(directDYAQ1)) {
                directDYAQS1.add(directDYAQ1);
            }
        }
        return directDYAQS1;
    }

    public List<DirectYGDJ> selectYGDJsByCXRId(String cxrid) {
        List<DirectYGDJ> directYGDJS = ygdjService.selectYGDJsByCXRId(cxrid);
        List<DirectYGDJ> directYGDJS1 = new ArrayList<>();
        for (DirectYGDJ directYGDJ : directYGDJS) {
            DirectYGDJ directYGDJ1 = dict.ygdjConversion(directYGDJ);
            if (!directYGDJS1.contains(directYGDJ1)) {
                directYGDJS1.add(directYGDJ1);
            }
        }
        return directYGDJS1;
    }

    public List<DirectCFDJ> selectCFDJsByCXRId(String cxrid) {
        List<DirectCFDJ> directCFDJS = cfdjService.selectCFDJsByCXRId(cxrid);
        List<DirectCFDJ> directCFDJS1 = new ArrayList<>();
        for (DirectCFDJ directCFDJ : directCFDJS) {
            DirectCFDJ directCFDJ1 = dict.cfdjConversion(directCFDJ);
            if (!directCFDJS1.contains(directCFDJ1)) {
                directCFDJS1.add(directCFDJ1);
            }
        }
        return directCFDJS1;
    }

    public List<DirectYYDJ> selectYYDJsByCXRId(String cxrid) {
        List<DirectYYDJ> directYYDJS = yydjService.selectYYDJsByCXRId(cxrid);
        List<DirectYYDJ> directYYDJS1 = new ArrayList<>();
        for (DirectYYDJ directYYDJ : directYYDJS) {
            DirectYYDJ directYYDJ1 = dict.yydjConversion(directYYDJ);
            if (!directYYDJS1.contains(directYYDJ1)) {
                directYYDJS1.add(directYYDJ1);
            }
        }
        return directYYDJS1;
    }

}
