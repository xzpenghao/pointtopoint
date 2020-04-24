package com.ztgeo.pointtopoint.service.mainService;


import com.ztgeo.pointtopoint.entity.CXR_MSG;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CXR_MSGService {
    int insert(CXR_MSG record);

    List<CXR_MSG> selectMsgsByCxsqdhId(String cxsqdhId);

    void saveToCXR_MSG(List<CXR_MSG> cxr_msgs);

    List<String> getQlrzjlx(String qlrmc, String qlrzjh);
}
