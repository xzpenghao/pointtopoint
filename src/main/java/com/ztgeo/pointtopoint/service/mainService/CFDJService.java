package com.ztgeo.pointtopoint.service.mainService;

import com.ztgeo.pointtopoint.controller.entity.DirectCFDJ;
import com.ztgeo.pointtopoint.handle.entity.CFDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.MCFDJ;

import java.util.List;

public interface CFDJService {
    List<MCFDJ> findCFDJ(String slbh);

    void saveToCFDJ(List<CFDJ> cfdjs);

    List<DirectCFDJ> selectCFDJsByCXRId(String cxrId);
}
