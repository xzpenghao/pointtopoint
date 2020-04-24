package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.mapper.mainMapper.CXR_MSGMapper;
import com.ztgeo.pointtopoint.service.mainService.CXR_MSGService;
import com.ztgeo.pointtopoint.utils.Dict;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(value = "dbMainTransactionManager")
public class CXR_MSGServiceImpl implements CXR_MSGService {

    @Autowired
    private CXR_MSGMapper msgMapper;


    @Override
    public int insert(CXR_MSG record) {
        return msgMapper.insert(record);
    }

    @Override
    public List<CXR_MSG> selectMsgsByCxsqdhId(String cxsqdhId) {
        return msgMapper.selectMsgsByCxsqdhId(cxsqdhId);
    }

    @Override
    public void saveToCXR_MSG(List<CXR_MSG> cxr_msgs) {
        msgMapper.saveToCXR_MSG(cxr_msgs);
    }

    @Override
    public List<String> getQlrzjlx(String qlrmc, String qlrzjh) {
        return msgMapper.getQlrzjlx(qlrmc, qlrzjh);
    }
}
