package com.ztgeo.pointtopoint.utils.token;

import com.ztgeo.pointtopoint.utils.SendHttpClient;
import com.ztgeo.pointtopoint.utils.json.RequestJSONString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class Token {
    public static String token_url;

    @Value("${url.tokenUrl}")//从配置文件中token的地址
    public void setToken_url(String tokenUrl) {
        Token.token_url = tokenUrl;
    }

    public String getToken_url() {
        return token_url;
    }

    /**
     * 获取安全密钥token
     *
     * @param xzqdm    行政区代码
     * @param username 用户名
     * @param password 密码
     * @param timeout  超时时间
     * @return 返回获取到的带有token的json
     */
    public static String getTokenString(String xzqdm, String username, String password, int timeout) {
        String token = "";
//        String token_url = "http://10.0.0.6:8090/realestate-supervise-exchange/api/v1/bdc/token";  //获取token的接口地址
        String json = "{\"head\": {\"xzqdm\": \"" + xzqdm + "\"},\"data\":{\"username\": \"" + username
                + "\",\"password\":\"" + password + "\"}}";
        log.info("获取token的请求报文：" + json);
        Map<String, String> obj = new HashMap<>();  //组织请求token的报文
        obj.put("gxData", json);
        String jsonToken = "";
        try {
            jsonToken = SendHttpClient.sendHttpClient(token_url, obj, timeout);  //调用接口
        } catch (IOException e) {
            e.printStackTrace();
            log.error("获取token出错" + e);
        }
        log.info("Token JSON:" + jsonToken);
        token = "未获取到token";
        if (StringUtils.isNotBlank(jsonToken)) {
            token = RequestJSONString.getToken(jsonToken);
        } else {
            log.error("未获取到token");
        }
        return token;
    }
}
