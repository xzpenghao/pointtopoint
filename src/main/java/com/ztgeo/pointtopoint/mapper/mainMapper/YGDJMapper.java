package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.controller.entity.DirectYGDJ;
import com.ztgeo.pointtopoint.handle.entity.TDSYQ;
import com.ztgeo.pointtopoint.handle.entity.YGDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.MYGDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.YGFWXG;
import com.ztgeo.pointtopoint.handle.middleEntity.YWR;

import java.util.List;

public interface YGDJMapper {
    List<MYGDJ> findYGDJ(String slbh);

    List<YGFWXG> findYGFWXG(String tstybm);

    List<YWR> findYWR(String slbh);

    void saveToYGDJ(List<YGDJ> ygdjs);

    List<DirectYGDJ> selectYGDJsByCXRId(String cxrId);
}
