package com.ztgeo.pointtopoint.utils.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ztgeo.pointtopoint.entity.CXSQD;
import com.ztgeo.pointtopoint.entity.RESULT;
import com.ztgeo.pointtopoint.utils.UUIDUtils;
import com.ztgeo.pointtopoint.utils.Util;
import org.apache.commons.lang3.StringUtils;

/**
 * 解析反馈接口的json
 */
public class ReturnJSONString {

    /**
     * 解析返回结果
     *
     * @param jsonString
     * @param cxsqdhList
     * @return
     */
    public static ArrayList<RESULT> responseJSON(String jsonString, List<CXSQD> cxsqdhList) {
        ArrayList<RESULT> results = new ArrayList<>();
        Object jsonObject = JSON.parse(jsonString);
        if (jsonObject instanceof JSONArray) {
            JSONArray json = (JSONArray) jsonObject;
            for (int i = 0; i < json.size(); i++) {
                JSONObject json_single = json.getJSONObject(i);
                JSONObject json_head = json_single.getJSONObject("head");
                String code = json_head.getString("code");
                String msg = json_head.getString("msg");
                //msg长度进行限制 正常情况msg存储的字数有限，在省厅接口报错会把日志打印返回 比较多 需要判断截取 否则msg数据库字段500容量存不下
                if (StringUtils.isNotBlank(msg) && msg.length() > 500) {
                    msg = msg.substring(0, 200);
                }
                String cxsqdh = json_head.getString("sqdh");
                Date fksj = Util.getSaveDate();
                RESULT result = new RESULT(UUIDUtils.generateShortUuid(), code, msg, cxsqdh, fksj);
                results.add(result);
            }
        } else if (jsonObject instanceof JSONObject) {
            for (int i = 0; i < cxsqdhList.size(); i++) {
                Date fksj = Util.getSaveDate();
                RESULT result = new RESULT(UUIDUtils.generateShortUuid(), "3007", "系统异常,请联系管理员!", cxsqdhList.get(i).getCxsqdh(), fksj);
                results.add(result);
            }
        }
        return results;
    }
}
