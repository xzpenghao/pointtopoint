package com.ztgeo.pointtopoint.service.mainService;

import com.ztgeo.pointtopoint.controller.entity.DirectTDSYQ;
import com.ztgeo.pointtopoint.handle.entity.TDSYQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MTDSYQ;

import java.util.List;

public interface TDSYQService {
    List<MTDSYQ> findTDSYQ(String slbh);

    void saveToTDSYQ(List<TDSYQ> tdsyqs);

    List<DirectTDSYQ> selectTDSYQsByCXRId(String cxrId);
}
