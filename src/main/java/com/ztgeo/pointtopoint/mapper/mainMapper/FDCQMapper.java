package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.controller.entity.DirectFDCQ;
import com.ztgeo.pointtopoint.handle.entity.DYAQ;
import com.ztgeo.pointtopoint.handle.entity.FDCQ;
import com.ztgeo.pointtopoint.handle.entity.YYDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.MFDCQ;

import java.util.List;

public interface FDCQMapper {
    List<MFDCQ> findFDCQ(String slbh);

    void saveToFDCQ(List<FDCQ> fdcqs);

    List<DirectFDCQ> selectFDCQsByCXRId(String cxrId);
}
