package com.ztgeo.pointtopoint.mapper.mainMapper;

import com.ztgeo.pointtopoint.entity.CXR_MSG;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CXR_MSGMapper {
    int insert(CXR_MSG record);

    List<CXR_MSG> selectMsgsByCxsqdhId(String cxsqdhId);

    void saveToCXR_MSG(List<CXR_MSG> cxr_msgs);

    List<String> getQlrzjlx(@Param("qlrmc") String qlrmc, @Param("qlrzjh") String qlrzjh);
}