package com.ztgeo.pointtopoint.service.mainService;

import com.ztgeo.pointtopoint.controller.entity.DirectYYDJ;
import com.ztgeo.pointtopoint.handle.entity.YYDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.MYYDJ;

import java.util.List;

public interface YYDJService {
    List<MYYDJ> findYYDJ(String slbh);

    void saveToYYDJ(List<YYDJ> yydjs);

    List<DirectYYDJ> selectYYDJsByCXRId(String cxrId);
}
