package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.controller.entity.DirectDYAQ;
import com.ztgeo.pointtopoint.handle.entity.DYAQ;
import com.ztgeo.pointtopoint.handle.middleEntity.FWXG;
import com.ztgeo.pointtopoint.handle.middleEntity.MDYAQ;
import com.ztgeo.pointtopoint.handle.middleEntity.TDXG;

import java.util.List;

public interface DYAQMapper {
    List<MDYAQ> findDYAQ(String slbh);

    List<FWXG> findFWXG(String tstybm);

    List<TDXG> findTDXG(String tstybm);

    List<String> findDYQR(String slbh);

    void saveToDYAQ(List<DYAQ> dyaqs);

    List<DirectDYAQ> selectDYAQsByCXRId(String cxrId);
}
