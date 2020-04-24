package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.handle.middleEntity.DJ_TSGL;

import java.util.List;

public interface DJ_TSGLMapper {
    List<DJ_TSGL> judgyCFOrDY(String tstybm);
}