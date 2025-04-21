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

    /*
    拦截特定路径的请求：  在 WebConfig 中，AdminInterceptor 被配置为拦截 /admin/** 路径下的所有请求。这意味着所有以 /admin/ 开头的请求都会经过这个拦截器。
    检查用户登录状态：  拦截器的主要功能是检查用户是否已登录。如果用户未登录，则会重定向到 login.jsp 页面，阻止未授权的访问。
    放行特定资源：  对于静态资源（如 css/、js/、img/）以及登录相关的路径,如 login 和 logout，拦截器会直接放行，不进行拦截。

    当浏览器发起一个 HTTP 请求时，以下是拦截器的具体工作流程：
    Spring MVC 会根据 WebConfig 中的配置，检查请求的路径是否匹配 /admin/**。如果路径不匹配，则不会触发拦截器，直接进入后续的处理流程。
    如果路径匹配 /admin/**，请求会进入 AdminInterceptor 的 preHandle 方法。
    检查静态资源和登录路径：
    preHandle 方法首先检查请求的 URI 是否包含 css/、js/、img/、login 或 logout。
    如果匹配这些路径，拦截器直接返回 true，表示放行，继续后续的处理流程。
    检查登录状态：
    如果请求不属于上述放行的路径，拦截器会从 HttpSession 中获取 username 属性。
    如果 username 存在且非空，表示用户已登录，拦截器返回 true，请求继续处理。
    未登录处理：
    如果 username 不存在或为空，拦截器会调用 response.sendRedirect("login.jsp")，将用户重定向到登录页面。
    同时返回 false，终止后续的处理流程
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义的管理员拦截器
        registry.addInterceptor(new AdminInterceptor())
            //设置拦截的路径为 /admin/** 下的所有请求
                .addPathPatterns("/admin/**");
    }

    // 配置跨域资源共享 (CORS)，用于前后端分离
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径
                .allowedOrigins("http://localhost:3000") // 设置允许的来源为前端项目的地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 设置允许的 HTTP 方法
                .allowCredentials(true); // 允许发送凭据（如 Cookie）
    }

}
