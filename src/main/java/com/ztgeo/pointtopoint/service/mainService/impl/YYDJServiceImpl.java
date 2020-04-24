package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.DirectYYDJ;
import com.ztgeo.pointtopoint.handle.entity.YYDJ;
import com.ztgeo.pointtopoint.handle.middleEntity.MYYDJ;
import com.ztgeo.pointtopoint.mapper.mainMapper.YYDJMapper;
import com.ztgeo.pointtopoint.service.mainService.YYDJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class YYDJServiceImpl implements YYDJService {
    @Autowired
    private YYDJMapper yydjMapper;

    @Override
    public List<MYYDJ> findYYDJ(String slbh) {
        return yydjMapper.findYYDJ(slbh);
    }

    @Override
    public void saveToYYDJ(List<YYDJ> yydjs) {
        yydjMapper.saveToYYDJ(yydjs);
    }

    @Override
    public List<DirectYYDJ> selectYYDJsByCXRId(String cxrId) {
        return yydjMapper.selectYYDJsByCXRId(cxrId);
    }
}
