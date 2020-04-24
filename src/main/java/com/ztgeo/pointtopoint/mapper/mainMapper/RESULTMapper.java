package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.entity.RESULT;

import java.util.List;

public interface RESULTMapper {
    void saveToRESULT(List<RESULT> head);

    void deleteRESULTByCxsqds(List<String> cxsqds);
}
