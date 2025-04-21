package com.hl.book_stall.config;

import com.hl.book_stall.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author:HL
 * Date:2025/2/20 002023:08
 **/
// 将 Spring MVC 的配置放置在该配置类中
// 实现 WebMvcConfigurer 接口以自定义配置
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 配置多媒体文件解析器，用于文件上传
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        // 创建文件上传解析器实例
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        // 设置上传文件的最大尺寸为 5MB
        multipartResolver.setMaxUploadSize(5242880);
        // 设置默认编码为 UTF-8
        multipartResolver.setDefaultEncoding("utf-8");
        return multipartResolver;
    }

    // 配置拦截器，用于拦截请求，没有前后端分离时通过这个配置访问项目下的前端页面
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     // 添加自定义的管理员拦截器
    //     registry.addInterceptor(new AdminInterceptor())
            //设置拦截的路径为 /admin/** 下的所有请求
    //             .addPathPatterns("/admin/**");
    // }

    // 配置跨域资源共享 (CORS)，用于前后端分离
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径
                .allowedOrigins("http://localhost:3000") // 设置允许的来源为前端项目的地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 设置允许的 HTTP 方法
                .allowCredentials(true); // 允许发送凭据（如 Cookie）
    }

}
