package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.entity.SLBH;
import com.ztgeo.pointtopoint.handle.middleEntity.ZX;

import java.util.List;

public interface HandleMapper {
    List<SLBH> findSLBH(CXR_MSG cxr_msg);

    List<SLBH> findSLBHFirm(CXR_MSG cxr_msg);

    List<SLBH> findSLBHAll(CXR_MSG cxr_msg);

    List<SLBH> findSLBHFirmAll(CXR_MSG cxr_msg);

    int judgeDJ_DY(String slbh);

    int judgeDJ_CF(String slbh);

    List<String> judgeDY(String slbh);

    List<String> judgeCF(String slbh);

    List<String> judgeQS(String slbh);

    List<ZX> zxdj(String slbh);
}
