package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.DirectTDSYQ;
import com.ztgeo.pointtopoint.handle.entity.TDSYQ;
import com.ztgeo.pointtopoint.handle.middleEntity.MTDSYQ;
import com.ztgeo.pointtopoint.mapper.mainMapper.TDSYQMapper;
import com.ztgeo.pointtopoint.service.mainService.TDSYQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class TDSYQServiceImpl implements TDSYQService {

    @Autowired
    private TDSYQMapper tdsyqMapper;

    @Override
    public List<MTDSYQ> findTDSYQ(String slbh) {
        return tdsyqMapper.findTDSYQ(slbh);
    }

    @Override
    public void saveToTDSYQ(List<TDSYQ> tdsyqs) {
        tdsyqMapper.saveToTDSYQ(tdsyqs);
    }

    @Override
    public List<DirectTDSYQ> selectTDSYQsByCXRId(String cxrId) {
        return tdsyqMapper.selectTDSYQsByCXRId(cxrId);
    }

}
