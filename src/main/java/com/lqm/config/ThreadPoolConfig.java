package com.lqm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description: 线程池配置类
 */

@Configuration
@EnableAsync
public class ThreadPoolConfig {
    
    @Bean(name = "defaultThreadPool")
    public static ThreadPoolTaskExecutor defaultThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //线程池活跃的线程数
        executor.setCorePoolSize(10);
        //线程池最大活跃的线程数
        executor.setMaxPoolSize(10);
        //线程名称前缀
        executor.setThreadNamePrefix("asyncThread");
        //线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(3);
        //核心线程池也会请0
        executor.setAllowCoreThreadTimeOut(true);
        //线程池拒绝机制，抛弃最久的线程
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //线程池队列
        executor.setQueueCapacity(1000);
        executor.initialize();
        
        return executor;
    }
}
