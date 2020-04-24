package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.DirectGJZWSYQ;
import com.ztgeo.pointtopoint.handle.entity.GJZWSYQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MGJZWSYQ;
import com.ztgeo.pointtopoint.mapper.mainMapper.GJZWSYQMapper;
import com.ztgeo.pointtopoint.service.mainService.GJZWSYQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class GJZWSYQServiceImpl implements GJZWSYQService {

    @Autowired
    private GJZWSYQMapper gjzwsyqMapper;

    @Override
    public List<MGJZWSYQ> findGJZWSYQ(String slbh) {
        return gjzwsyqMapper.findGJZWSYQ(slbh);
    }

    @Override
    public void saveToGJZWSYQ(List<GJZWSYQ> gjzwsyqs) {
        gjzwsyqMapper.saveToGJZWSYQ(gjzwsyqs);
    }

    @Override
    public List<DirectGJZWSYQ> selectGJZWSYQsByCXRId(String cxrId) {
        return gjzwsyqMapper.selectGJZWSYQsByCXRId(cxrId);
    }
}
