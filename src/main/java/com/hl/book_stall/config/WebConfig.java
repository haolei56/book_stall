package com.hl.book_stall.config;

import com.hl.book_stall.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author:HL
 * Date:2025/2/20 002023:08
 **/
//将springmvc中的配置放至该配置类中
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //配置多媒体文件解析器 用于文件上传
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5242880); // 设置上传文件的最大尺寸为5MB
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
    }
}
