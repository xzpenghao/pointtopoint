package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.DirectCFDJ;
import com.ztgeo.pointtopoint.handle.entity.CFDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.MCFDJ;
import com.ztgeo.pointtopoint.mapper.mainMapper.CFDJMapper;
import com.ztgeo.pointtopoint.service.mainService.CFDJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class CFDJServiceImpl implements CFDJService {

    @Autowired
    private CFDJMapper cfdjMapper;

    @Override
    public List<MCFDJ> findCFDJ(String slbh) {
        return cfdjMapper.findCFDJ(slbh);
    }

    @Override
    public void saveToCFDJ(List<CFDJ> cfdjs) {
        cfdjMapper.saveToCFDJ(cfdjs);
    }

    @Override
    public List<DirectCFDJ> selectCFDJsByCXRId(String cxrId) {
        return cfdjMapper.selectCFDJsByCXRId(cxrId);
    }
}
