package com.ztgeo.pointtopoint.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ztgeo.pointtopoint.controller.entity.CXR_MSGDirect;
import com.ztgeo.pointtopoint.utils.save.SaveToDB;
import com.ztgeo.pointtopoint.utils.Util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class HandleCXR_MSGDirect {
    private Logger log = LoggerFactory.getLogger(HandleCXR_MSGDirect.class);

    private static String openIdUrl;

    @Value("${url.openIdUrl}")
    public void setOpenIdUrl(String openIdUrl) {
        HandleCXR_MSGDirect.openIdUrl = openIdUrl;
    }

    /**
     * 解析请求的数据，入库并解析出反馈格式返回
     *
     * @param demand 接收到的查询报文
     * @return 返回组织的需要查询的请求人的list
     */
    public CXR_MSGDirect saveCXR_MSGDirect(String demand) {
        List<CXR_MSGDirect> cxr_msgDirects = new ArrayList<CXR_MSGDirect>();
        JSONObject jsonObject = JSONObject.parseObject(demand); //解析请求报文
        String cxjgbs = jsonObject.getJSONObject("head").getString("cxjgbs");
        String openid = jsonObject.getJSONObject("head").getString("openid");
        log.info("验证openid");
        int valid = isValid(openid); //验证openid的准确性
        CXR_MSGDirect cxr_msgDirect = null;
        if (valid == 1) { //验证通过
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object object : jsonArray) {
                JSONObject json = (JSONObject) object;
                String cxsqdh = json.getString("cxsqdh") == null ? "" : json .getString("cxsqdh");
                String xz = json.getString("xz") == null ? "" : json.getString("xz");
                String xm = json.getString("xm") == null ? "" : json.getString("xm");
                String zjzl = json.getString("zjzl") == null ? "" : json.getString("zjzl");
                String zjhm = json.getString("zjhm") == null ? "" : json.getString("zjhm");
                String bdcqzh = json.getString("bdcqzh") == null ? "" : json.getString("bdcqzh");
//                String bdcdyh = json.getString("bdcdyh") == null ? "" : json.getString("bdcdyh");
                String zl = json.getString("zl") == null ? "" : json.getString("zl");
                String cxqy = json.getString("cxqy") == null ? "" : json.getString("cxqy");
                String cxfw = json.getString("cxfw") == null ? "" : json.getString("cxfw");
                String wsbh = json.getString("wsbh") == null ? "" : json.getString("wsbh");
                //组织需要查询的请求人list
                if (StringUtils.isBlank(cxfw)) {
                    cxfw = "1";
                }
                String bdcdyh="";
                //不为空dyh判断
                if (StringUtils.isNotEmpty(json.getString("bdcdyh"))){
                    if (Util.IsLength(json.getString("bdcdyh")) && Util.IsBdcDyh(json.getString("bdcdyh"))){
                         bdcdyh = jsonObject.getString("bdcyh");
                    }
                }
                //组织入库的请求人list
                cxr_msgDirect = new CXR_MSGDirect(cxjgbs, openid, cxsqdh, xz, xm, Integer.parseInt(zjzl), zjhm, bdcqzh, bdcdyh, zl, cxqy, Integer.parseInt(cxfw), wsbh, "", Util.getSaveDate(), demand);
                cxr_msgDirects.add(cxr_msgDirect);
            }
        }
        log.info("请求数据入库");
        SaveToDB saveToDB = new SaveToDB();
        saveToDB.addCXR_MSGDirect(cxr_msgDirects);//网络直接查询请求人入库-》表cxr_msgDirect
        return cxr_msgDirect;
    }

    /**
     * 验证openid是否正确
     *
     * @param openid openid
     * @return 返回验证结果
     */
    public int isValid(String openid) {
        String url = openIdUrl + openid;//验证接口
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        try {
            client.executeMethod(method);
            InputStream inputStream = method.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String json = "";
            while ((json = br.readLine()) != null) {
                stringBuffer.append(json);
            }
            String validString = stringBuffer.toString();
            JSONObject object = JSONObject.parseObject(validString);
            String valid = object.getJSONObject("data").getString("valid");
            return Integer.parseInt(valid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
