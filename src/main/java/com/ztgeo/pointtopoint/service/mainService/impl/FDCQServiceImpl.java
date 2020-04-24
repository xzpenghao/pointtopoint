package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.DirectFDCQ;
import com.ztgeo.pointtopoint.handle.entity.FDCQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MFDCQ;
import com.ztgeo.pointtopoint.mapper.mainMapper.FDCQMapper;
import com.ztgeo.pointtopoint.service.mainService.FDCQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class FDCQServiceImpl implements FDCQService {

    @Autowired
    private FDCQMapper fdcqMapper;

    @Override
    public List<MFDCQ> findFDCQ(String slbh) {
        return fdcqMapper.findFDCQ(slbh);
    }

    @Override
    public void saveToFDCQ(List<FDCQ> fdcqs) {
        fdcqMapper.saveToFDCQ(fdcqs);
    }

    @Override
    public List<DirectFDCQ> selectFDCQsByCXRId(String cxrId) {
        return fdcqMapper.selectFDCQsByCXRId(cxrId);
    }

}
