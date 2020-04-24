package com.ztgeo.pointtopoint.service.mainService;

import com.ztgeo.pointtopoint.entity.CXSQD;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CXSQDService {
    int insert(CXSQD record);

    void saveToCXSQD(List<CXSQD> cxsqds);

    void updateCXSQD(List<String> cxsqdhIds);

    List<String> selectCxsqdhs();

    List<CXSQD> selectCXSQDHS();

    void updateCXSQDById(String cxsqdhId);

    List<CXSQD> selectResponseCxsqdhs();

    void updateCXSQHDByResponseCode(@Param("zt") String zt, @Param("cxsqdh") String cxsqdh, @Param("updatetime") Date updatetime);

    List<CXSQD> selectFailureData();

    void updateFailureZtByCxsqdh(List<String> cxsqdhs);

    int judgeCxsqdhIsExist(String cxsqdh);

    int getTotalDataByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    int getSuccessDataByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    int getFailureDataByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    int getNoFeedbackDataByTime();

    List<Map<String, Object>> getErrorInfos(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<CXSQD> selectCXSQDByCxsqdh(String cxsqdh);
}
