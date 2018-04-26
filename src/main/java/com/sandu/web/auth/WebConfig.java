package com.sandu.web.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author by bvvy
 * @date 2018/4/26
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/**").excludePathPatterns("/logout/**");
    }
}
