package com.lqm.config;


import com.lqm.config.interceptor.AuthorityInterceptor;
import com.lqm.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 将AuthorityInterceptor拦截器、LoginInterceptor拦截器 添加到SpringBoot的配置中
 */
@Configuration
public class AuthorityInterceptorConfig  implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor()).addPathPatterns("/manage/**");

        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/user/**")
                .addPathPatterns("/cart/**")
                .addPathPatterns("/order/**")
                .addPathPatterns("/product/**")
                .addPathPatterns("/shipping/**");
    }

    /**
     * addPathPatterns("/manage/**"):只拦截/manage/**下的所有路径，其他路径不拦截
     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorityInterceptor()).addPathPatterns("/manage/**");
//
//
//        registry.addInterceptor(loginInterceptor())
//                .addPathPatterns("/user/**")
//                .addPathPatterns("/cart/**")
//                .addPathPatterns("/order/**")
//                .addPathPatterns("/product/**")
//                .addPathPatterns("/shipping/**");;
//
//
//        super.addInterceptors(registry);
//    }

    @Bean
    public AuthorityInterceptor authorityInterceptor() {
        return new AuthorityInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

}
