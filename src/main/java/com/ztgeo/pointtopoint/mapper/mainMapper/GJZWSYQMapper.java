package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.controller.entity.DirectGJZWSYQ;
import com.ztgeo.pointtopoint.handle.entity.FDCQ;
import com.ztgeo.pointtopoint.handle.entity.GJZWSYQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MGJZWSYQ;

import java.util.List;

public interface GJZWSYQMapper {
    List<MGJZWSYQ> findGJZWSYQ(String slbh);

    void saveToGJZWSYQ(List<GJZWSYQ> gjzwsyqs);

    List<DirectGJZWSYQ> selectGJZWSYQsByCXRId(String cxrId);
}
