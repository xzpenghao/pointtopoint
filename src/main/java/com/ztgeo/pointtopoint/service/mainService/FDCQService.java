package com.ztgeo.pointtopoint.service.mainService;

import com.ztgeo.pointtopoint.controller.entity.DirectFDCQ;
import com.ztgeo.pointtopoint.handle.entity.FDCQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MFDCQ;

import java.util.List;

public interface FDCQService {
    List<MFDCQ> findFDCQ(String slbh);

    void saveToFDCQ(List<FDCQ> fdcqs);

    List<DirectFDCQ> selectFDCQsByCXRId(String cxrId);
}
