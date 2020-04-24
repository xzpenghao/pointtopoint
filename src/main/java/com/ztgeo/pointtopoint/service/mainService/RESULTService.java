package com.ztgeo.pointtopoint.service.mainService;

import com.ztgeo.pointtopoint.entity.RESULT;

import java.util.List;


public interface RESULTService {
    void saveToRESULT(List<RESULT> results);

    void deleteRESULTByCxsqds(List<String> cxsqds);
}
