package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.controller.entity.DirectTDSYQ;
import com.ztgeo.pointtopoint.handle.entity.CFDJ;
import com.ztgeo.pointtopoint.handle.entity.GJZWSYQ;
import com.ztgeo.pointtopoint.handle.entity.TDSYQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MTDSYQ;

import java.util.List;

public interface TDSYQMapper {
    List<MTDSYQ> findTDSYQ(String slbh);

    void saveToTDSYQ(List<TDSYQ> tdsyqs);

    List<DirectTDSYQ> selectTDSYQsByCXRId(String cxrId);
}
