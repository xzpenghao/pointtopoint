package com.ztgeo.pointtopoint.utils.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenRedisImpl implements TokenRedis {
    
    private static String xzqdm;//行政区代码
    private static String username;//用户名
    private static String password;//密码
    private static int timeout;

    @Value("${token.xzqdm}")//从配置文件中读取行政区代码
    public void setXzqdm(String xzqdm) {  //注入行政区代码,注意@Value()只能写在非静态属性或者方法上
        TokenRedisImpl.xzqdm = xzqdm;
    }

    @Value("${token.username}")//从配置文件中读取用户名
    public void setUsername(String username) { //注入用户名
        TokenRedisImpl.username = username;
    }

    @Value("${token.password}")//从配置文件中读取密码
    public void setPassword(String password) {  //注入密码
        TokenRedisImpl.password = password;
    }

    @Value("${timeout}")
    public void setTimeout(int timeout) {
        TokenRedisImpl.timeout = timeout;
    }

    @Override
    public String getToken() {
        return Token.getTokenString(xzqdm, username, password, timeout);
    }
}
