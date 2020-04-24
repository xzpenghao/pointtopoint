package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.entity.SLBH;
import com.ztgeo.pointtopoint.handle.middleEntity.ZX;
import com.ztgeo.pointtopoint.mapper.mainMapper.HandleMapper;
import com.ztgeo.pointtopoint.service.mainService.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class HandleServiceImpl implements HandleService {

    @Autowired
    private HandleMapper handleMapper;

    @Override
    public List<SLBH> findSLBH(CXR_MSG cxr_msg) {
        return handleMapper.findSLBH(cxr_msg);
    }

    @Override
    public List<SLBH> findSLBHFirm(CXR_MSG cxr_msg) {
        return handleMapper.findSLBHFirm(cxr_msg);
    }

    @Override
    public List<SLBH> findSLBHAll(CXR_MSG cxr_msg) {
        return handleMapper.findSLBHAll(cxr_msg);
    }

    @Override
    public List<SLBH> findSLBHFirmAll(CXR_MSG cxr_msg) {
        return handleMapper.findSLBHFirmAll(cxr_msg);
    }

    @Override
    public int judgeDJ_DY(String slbh) {
        return handleMapper.judgeDJ_DY(slbh);
    }

    @Override
    public int judgeDJ_CF(String slbh) {
        return handleMapper.judgeDJ_CF(slbh);
    }

    @Override
    public List<String> judgeDY(String slbh) {
        return handleMapper.judgeDY(slbh);
    }

    @Override
    public List<String> judgeCF(String slbh) {
        return handleMapper.judgeCF(slbh);
    }

    @Override
    public List<String> judgeQS(String slbh) {
        return handleMapper.judgeQS(slbh);
    }

    @Override
    public List<ZX> zxdj(String slbh) {
        return handleMapper.zxdj(slbh);
    }

}
