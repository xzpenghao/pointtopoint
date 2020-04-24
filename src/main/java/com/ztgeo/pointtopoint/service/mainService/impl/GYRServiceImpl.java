package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.handle.middleEntity.GYR;
import com.ztgeo.pointtopoint.mapper.mainMapper.GYRMapper;
import com.ztgeo.pointtopoint.service.mainService.GYRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class GYRServiceImpl implements GYRService {

    @Autowired
    private GYRMapper gyrMapper;

    @Override
    public List<GYR> findGYQK(String slbh) {
        return gyrMapper.findGYQK(slbh);
    }
}
