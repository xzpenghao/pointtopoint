package com.ztgeo.pointtopoint.service.mainService;

import com.ztgeo.pointtopoint.controller.entity.DirectGJZWSYQ;
import com.ztgeo.pointtopoint.handle.entity.GJZWSYQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MGJZWSYQ;

import java.util.List;

public interface GJZWSYQService {
    List<MGJZWSYQ> findGJZWSYQ(String slbh);

    void saveToGJZWSYQ(List<GJZWSYQ> gjzwsyqs);

    List<DirectGJZWSYQ> selectGJZWSYQsByCXRId(String cxrId);
}
