package com.ztgeo.pointtopoint.handle;

import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.entity.SLBH;
import com.ztgeo.pointtopoint.service.mainService.HandleService;
import com.ztgeo.pointtopoint.utils.IDCardUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询工具类
 */
@Slf4j
@Component
public class HandleUtil {

    private static HandleService handleService;

    @Autowired
    public void setHandleService(HandleService handleService) {
        this.handleService = handleService;
    }

    /**
     * 获取受理编号
     *
     * @param cxr_msg 请求人记录
     * @return
     */
    public ArrayList<String> getSLBH(int cxfw, CXR_MSG cxr_msg) {
        ArrayList<String> slbhs = new ArrayList<String>();
        List<SLBH> slbhList = new ArrayList<>();
        List<SLBH> slbhList1 = new ArrayList<>();
        if (!StringUtils.isBlank(cxr_msg.getQlrmc()) && !StringUtils.isBlank(cxr_msg.getQlrzjh())) {
            slbhList = searchSLBH(cxr_msg, cxfw);
            if(IDCardUtil.isIdCardNo(cxr_msg.getQlrzjh())){
            cxr_msg.setQlrzjh(IDCardUtil.from18to15(cxr_msg.getQlrzjh()));
            slbhList1 = searchSLBH(cxr_msg, cxfw);
            }
            slbhList.addAll(slbhList1);
        } else {
            log.error("权利人姓名或证件号参数缺失");
        }
        if (slbhList != null && slbhList.size() > 0) {
            log.info("受理编号" + slbhList);
            for (SLBH slbhAll : slbhList) {
                String slbh = slbhAll.getSlbh();
                String bdclx = slbhAll.getBdclx();
                if ("宗地".equals(bdclx)) {
                    if (DJ_DY(slbh)) {
                        log.info("土地抵押受理编号:" + slbh);
                        boolean b = judgeDY(slbh, cxr_msg.getQlrmc());
                        if (b) {
                            slbhs.add(slbh);
                        }
                    } else if (DJ_CF(slbh)) {
                        log.info("土地查封受理编号:" + slbh);
                        boolean b = judgeCF(slbh, cxr_msg.getQlrmc());
                        if (b) {
                            slbhs.add(slbh);
                        }
                    } else {
                        log.info("土地权属受理编号:" + slbh);
                        boolean b = judgeQS(slbh, cxr_msg.getQlrmc());
                        if (b) {
                            slbhs.add(slbh);
                        }
                    }
                } else {
                    slbhs.add(slbh);
                }
            }
        }
        return slbhs;
    }

    public List<SLBH> searchSLBH(CXR_MSG cxr_msg, int cxfw) {
        List<SLBH> slbhList = new ArrayList<SLBH>();
        if (1 == cxr_msg.getQlrzjlx()) {
            if (0 == cxfw) {
                slbhList = handleService.findSLBHAll(cxr_msg);
            } else {
                slbhList = handleService.findSLBH(cxr_msg);
            }
        } else {
            if (0 == cxfw) {
                slbhList = handleService.findSLBHFirmAll(cxr_msg);
            } else {
                slbhList = handleService.findSLBHFirm(cxr_msg);
            }
        }
        return slbhList;
    }

    /**
     * 判断是否是抵押数据
     *
     * @param slbh 受理编号
     * @return
     */
    public boolean DJ_DY(String slbh) {
        int num = handleService.judgeDJ_DY(slbh);
        if (num > 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否时查封数据
     *
     * @param slbh 受理编号
     * @return
     */
    public boolean DJ_CF(String slbh) {
        int num = handleService.judgeDJ_CF(slbh);
        if (num > 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是本人的抵押记录
     *
     * @param slbh 受理编号
     * @param name 姓名
     * @return
     */
    public boolean judgeDY(String slbh, String name) {
        List<String> qlrmcs = handleService.judgeDY(slbh);
        for (String qlrmc : qlrmcs) {
            if (StringUtils.isBlank(qlrmc)) {
                return true;
            } else if (qlrmc.contains(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是本人的查封
     *
     * @param slbh 受理编号
     * @param name 姓名
     * @return
     */
    public boolean judgeCF(String slbh, String name) {
        List<String> qlrmcs = handleService.judgeCF(slbh);
        for (int i = 0; i < qlrmcs.size(); i++) {
            if (qlrmcs.size() > 1) {
                String qlrmc = qlrmcs.get(0);
                String qlrmc2 = qlrmcs.get(1);
                if (StringUtils.isBlank(qlrmc)) {
                    qlrmc = "";
                }
                if (StringUtils.isBlank(qlrmc2)) {
                    qlrmc2 = "";
                }
                if (StringUtils.isBlank(qlrmc) && StringUtils.isBlank(qlrmc2)) {
                    return true;
                } else if (qlrmc.contains(name)) {
                    return true;
                } else if (qlrmc2.contains(name)) {
                    return true;
                }
            } else {
                String qlrmc = qlrmcs.get(0);
                if (StringUtils.isBlank(qlrmc)) {
                    qlrmc = "";
                }
                if (StringUtils.isBlank(qlrmc)) {
                    return true;
                } else if (qlrmc.contains(name)) {
                    return true;
                }
            }
            break;
        }
        return false;
    }

    /**
     * 判断是否是本人的权属
     *
     * @param slbh 受理编号
     * @param name 姓名
     * @return
     */
    public boolean judgeQS(String slbh, String name) {
        List<String> qlrmcs = handleService.judgeQS(slbh);
        for (String qlrmc : qlrmcs) {
            if (StringUtils.isBlank(qlrmc)) {
                return true;
            } else if (qlrmc.contains(name)) {
                return true;
            }
        }
        return false;
    }
}
