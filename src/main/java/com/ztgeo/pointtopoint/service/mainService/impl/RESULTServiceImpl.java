package com.ztgeo.pointtopoint.service.mainService.impl;

import com.ztgeo.pointtopoint.entity.RESULT;
import com.ztgeo.pointtopoint.mapper.mainMapper.RESULTMapper;
import com.ztgeo.pointtopoint.service.mainService.RESULTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "dbMainTransactionManager")
public class RESULTServiceImpl implements RESULTService {

    @Autowired
    private RESULTMapper resultMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveToRESULT(List<RESULT> results) {
        resultMapper.saveToRESULT(results);
    }

    @Override
    public void deleteRESULTByCxsqds(List<String> cxsqds) {
        String ss = getSqlStrByList(cxsqds, 500, "CXSQDH");
        jdbcTemplate.update(ss);
    }

    private static String getSqlStrByList(List sqhList, int splitNum,
                                          String columnName) {
        if (splitNum > 500) // 因为数据库的列表sql限制，不能超过1000.
            return null;
        StringBuffer ids = new StringBuffer("");
        if (sqhList != null) {
            ids.append("" +
                    "delete from GX_RESULT where ").append(columnName).append(" IN ( ");
            for (int i = 0; i < sqhList.size(); i++) {
                ids.append("'").append(sqhList.get(i) + "',");
                if ((i + 1) % splitNum == 0 && (i + 1) < sqhList.size()) {
                    ids.deleteCharAt(ids.length() - 1);
                    ids.append(" ) OR ").append(columnName).append(" IN (");
                }
            }
            ids.deleteCharAt(ids.length() - 1);
            ids.append(" )");
        }
        return ids.toString();
    }

}
