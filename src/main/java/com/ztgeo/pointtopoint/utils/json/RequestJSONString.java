package com.ztgeo.pointtopoint.utils.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ztgeo.pointtopoint.utils.json.entity.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 解析请求接口的json
 */
@Slf4j
public class RequestJSONString {

    /**
     * 解析获取到的带有token的json
     *
     * @param jsonString
     * @return
     */
    public static String getToken(String jsonString) {
        log.info("解析Token JSON...");
        JSONObject json = JSONObject.parseObject(jsonString);
        JSONObject json_data = json.getJSONObject("data");
        String token = json_data.getString("token");
        log.info("token:" + token);
        return token;
    }

    /**
     * 解析请求数据
     *
     * @param jsonString
     * @return
     */
    public static Response responseJSON(String jsonString) {
        Response response = new Response();
        ResponseString responseString = FAST.parseObject(jsonString, ResponseString.class);
        Responsehead head = FAST.parseObject(responseString.getHead(), Responsehead.class);
        ArrayList<Responsedata> datas = new ArrayList<Responsedata>();
        ArrayList<ResponsedataString> dataList = (ArrayList<ResponsedataString>) JSONArray.parseArray(responseString.getData(), ResponsedataString.class);
        for (int i = 0; i < dataList.size(); i++) {
            ResponsedataString json_data = dataList.get(i);
            Responsedata data = new Responsedata();
            data.setCxsqdh(json_data.getCxsqdh());
            data.setCxjgbs(json_data.getCxjgbs());
            data.setCxywlb(json_data.getCxywlb());
            data.setCxfw(Integer.parseInt(json_data.getCxfw()));
            ArrayList<CXYWCS> cxywcss = (ArrayList<CXYWCS>) JSONArray.parseArray(json_data.getCxywcs(), CXYWCS.class);
            data.setCxywcss(cxywcss);
            datas.add(data);
        }
        response.setHead(head);
        response.setDatas(datas);
        return response;
    }

    /**
     * 组织请求报文
     *
     * @param token
     * @param xzqdm
     * @return
     */
    public static String requestJSON(String token, String xzqdm) {
        JSONObject json = new JSONObject();
        Requesthead head = new Requesthead();
        head.setToken(token);
        head.setXzqdm(xzqdm);
        json.put("head", head);
        Requestdata data = new Requestdata();
        json.put("data", data);
        return json.toString();
    }

    /**
     * 组织确认请求的报文
     *
     * @param token
     * @param cxsqdhs
     * @param xzqdm
     * @return
     */
    public static String confirmRequestJSON(String token, List<String> cxsqdhs, String xzqdm) {
        JSONObject head = new JSONObject();
        head.put("xzqdm", xzqdm);
        head.put("token", token);
        JSONObject data = new JSONObject();
        data.put("cxsqdhs", cxsqdhs);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("head", head);
        jsonObject.put("data", data);
        return jsonObject.toString();
    }

    /**
     * 确认请求接收的结果
     *
     * @param jsonString
     * @return
     */
    public static String confirmResponseJSON(String jsonString) {
        JSONObject jsonObject = JSONObject.parseObject(jsonString);////使用fastjson，属性空值的问题需要考虑
        JSONObject json_head = jsonObject.getJSONObject("head");
        String code = json_head.getString("code");
        return code;
    }
}
