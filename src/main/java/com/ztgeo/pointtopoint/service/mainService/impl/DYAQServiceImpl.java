package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.DirectDYAQ;
import com.ztgeo.pointtopoint.handle.entity.DYAQ;
import com.ztgeo.pointtopoint.handle.middleEntity.FWXG;
import com.ztgeo.pointtopoint.handle.middleEntity.MDYAQ;
import com.ztgeo.pointtopoint.handle.middleEntity.TDXG;
import com.ztgeo.pointtopoint.mapper.mainMapper.DYAQMapper;
import com.ztgeo.pointtopoint.service.mainService.DYAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class DYAQServiceImpl implements DYAQService {

    @Autowired
    private DYAQMapper dyaqMapper;

    @Override
    public List<MDYAQ> findDYAQ(String slbh) {
        return dyaqMapper.findDYAQ(slbh);
    }

    @Override
    public List<FWXG> findFWXG(String tstybm) {
        return dyaqMapper.findFWXG(tstybm);
    }

    @Override
    public List<TDXG> findTDXG(String tstybm) {
        return dyaqMapper.findTDXG(tstybm);
    }

    @Override
    public List<String> findDYQR(String slbh) {
        return dyaqMapper.findDYQR(slbh);
    }

    @Override
    public void saveToDYAQ(List<DYAQ> dyaqs) {
        dyaqMapper.saveToDYAQ(dyaqs);
    }

    @Override
    public List<DirectDYAQ> selectDYAQsByCXRId(String cxrId) {
        return dyaqMapper.selectDYAQsByCXRId(cxrId);
    }
}
