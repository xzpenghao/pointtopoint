package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.handle.middleEntity.DJ_TSGL;
import com.ztgeo.pointtopoint.mapper.mainMapper.DJ_TSGLMapper;
import com.ztgeo.pointtopoint.service.mainService.DJ_TSGLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class DJ_TSGLServiceImpl implements DJ_TSGLService {

    @Autowired
    private DJ_TSGLMapper dj_tsglMapper;
    @Override
    public List<DJ_TSGL> judgyCFOrDY(String tstybm) {
        return dj_tsglMapper.judgyCFOrDY(tstybm);
    }
}
