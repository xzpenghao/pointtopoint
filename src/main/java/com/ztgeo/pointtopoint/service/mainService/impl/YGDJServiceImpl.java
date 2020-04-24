package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.DirectYGDJ;
import com.ztgeo.pointtopoint.handle.entity.YGDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.MYGDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.YGFWXG;
import com.ztgeo.pointtopoint.handle.middleEntity.YWR;
import com.ztgeo.pointtopoint.mapper.mainMapper.YGDJMapper;
import com.ztgeo.pointtopoint.service.mainService.YGDJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class YGDJServiceImpl implements YGDJService {

    @Autowired
    private YGDJMapper ygdjMapper;

    @Override
    public List<MYGDJ> findYGDJ(String slbh) {
        return ygdjMapper.findYGDJ(slbh);
    }

    @Override
    public List<YGFWXG> findYGFWXG(String tstybm) {
        return ygdjMapper.findYGFWXG(tstybm);
    }

    @Override
    public List<YWR> findYWR(String slbh) {
        return ygdjMapper.findYWR(slbh);
    }

    @Override
    public void saveToYGDJ(List<YGDJ> ygdjs) {
        ygdjMapper.saveToYGDJ(ygdjs);
    }

    @Override
    public List<DirectYGDJ> selectYGDJsByCXRId(String cxrId) {
        return ygdjMapper.selectYGDJsByCXRId(cxrId);
    }
}
