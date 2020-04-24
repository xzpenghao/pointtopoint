package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.entity.CXSQD;
import com.ztgeo.pointtopoint.mapper.mainMapper.CXSQDMapper;
import com.ztgeo.pointtopoint.service.mainService.CXSQDService;
import com.ztgeo.pointtopoint.utils.Dict;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CXSQDServiceImpl implements CXSQDService {
    @Autowired
    private CXSQDMapper cxsqdMapper;

    @Override
    public int insert(CXSQD record) {
        return cxsqdMapper.insert(record);
    }

    @Override
    public void saveToCXSQD(List<CXSQD> cxsqds) {
        cxsqdMapper.saveToCXSQD(cxsqds);
    }

    @Override
    public void updateCXSQD(List<String> cxsqdhIds) {
        cxsqdMapper.updateCXSQD(cxsqdhIds);
    }

    @Override
    public List<String> selectCxsqdhs() {
        return cxsqdMapper.selectCxsqdhs();
    }

    @Override
    public List<CXSQD> selectCXSQDHS() {
        return cxsqdMapper.selectCXSQDHS();
    }

    @Override
    public void updateCXSQDById(String cxsqdhId) {
        cxsqdMapper.updateCXSQDById(cxsqdhId);
    }

    @Override
    public List<CXSQD> selectResponseCxsqdhs() {
        return cxsqdMapper.selectResponseCxsqdhs();
    }

    @Override
    public void updateCXSQHDByResponseCode(String zt, String cxsqdh, Date updatetime) {
        cxsqdMapper.updateCXSQHDByResponseCode(zt, cxsqdh, updatetime);
    }

    @Override
    public List<CXSQD> selectFailureData() {
        return cxsqdMapper.selectFailureData();
    }

    @Override
    public void updateFailureZtByCxsqdh(List<String> cxsqdhs) {
        cxsqdMapper.updateFailureZtByCxsqdh(cxsqdhs);
    }

    @Override
    public int judgeCxsqdhIsExist(String cxsqdh) {
        return cxsqdMapper.judgeCxsqdhIsExist(cxsqdh);
    }

    @Override
    public int getTotalDataByTime(String startTime, String endTime) {
        return cxsqdMapper.getTotalDataByTime(startTime, endTime);
    }

    @Override
    public int getSuccessDataByTime(String startTime, String endTime) {
        return cxsqdMapper.getSuccessDataByTime(startTime, endTime);
    }

    @Override
    public int getFailureDataByTime(String startTime, String endTime) {
        return cxsqdMapper.getFailureDataByTime(startTime, endTime);
    }

    @Override
    public int getNoFeedbackDataByTime() {
        return cxsqdMapper.getNoFeedbackDataByTime();
    }

    @Override
    public List<Map<String, Object>> getErrorInfos(String startTime, String endTime) {
        return cxsqdMapper.getErrorInfos(startTime, endTime);
    }

    @Override
    public List<CXSQD> selectCXSQDByCxsqdh(String cxsqdh) {
        return cxsqdMapper.selectCXSQDByCxsqdh(cxsqdh);
    }
}
