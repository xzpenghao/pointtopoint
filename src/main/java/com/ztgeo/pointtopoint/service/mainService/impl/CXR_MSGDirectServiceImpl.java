package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.controller.entity.CXR_MSGDirect;
import com.ztgeo.pointtopoint.mapper.mainMapper.CXR_MSGDirectMapper;
import com.ztgeo.pointtopoint.service.mainService.CXR_MSGDirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class CXR_MSGDirectServiceImpl implements CXR_MSGDirectService {

    @Autowired
    private CXR_MSGDirectMapper cxr_msgDirectMapper;

//    @Override
//    public void saveToCXR_MSGDirect(CXR_MSGDirect cxr_msgDirect) {
//        System.out.println(cxr_msgDirect);
//        cxr_msgDirectMapper.saveToCXR_MSGDirect(cxr_msgDirect);
//    }

    @Override
    public void saveToCXR_MSGDirect(List<CXR_MSGDirect> cxr_msgDirects) {
        cxr_msgDirectMapper.saveToCXR_MSGDirect(cxr_msgDirects);
    }

}
