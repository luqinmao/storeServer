package com.lqm.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by lqm
 */
@Slf4j
public class TokenUtil {

    private final static String LOGIN_TOKEN = "login_token";
    public final static int TOKEN_EX_TIME = 60*60*12;


    public static String readLoginTokenByHeader(HttpServletRequest request){
        return request.getHeader(LOGIN_TOKEN);
    }

    public static String writeLoginTokenToRedis(String tokenKey){

        String tokenValue = UUID.randomUUID().toString();
        String status =  RedisShardedPoolUtil.setEx(tokenKey,tokenValue,TOKEN_EX_TIME);
        //TODO redis写入失败需要返回失败信息

        return tokenValue;

    }


}
