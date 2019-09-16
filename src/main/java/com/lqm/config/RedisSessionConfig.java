package com.lqm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Spring session 配置类，  session托管到redis
 */
@Configuration
//RedisFlushMode有两个参数：ON_SAVE（表示在response commit前刷新缓存），IMMEDIATE（表示只要有更新，就刷新缓存）
@EnableRedisHttpSession(
        maxInactiveIntervalInSeconds= 1800,
        redisFlushMode = RedisFlushMode.ON_SAVE,
        redisNamespace = "sessionSpace"
)
public class RedisSessionConfig {


    /** cooikes 设置 */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSIONID");//cookies名称
        serializer.setCookiePath("/");
        serializer.setCookieMaxAge(1800);//过期时间(秒)
//        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        return serializer;
    }

}
