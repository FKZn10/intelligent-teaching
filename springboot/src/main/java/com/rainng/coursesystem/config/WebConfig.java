package com.rainng.coursesystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取与 Controller 中一致的上传目录绝对路径
        String path = System.getProperty("user.dir") + "/uploads/";

        // 映射规则：将请求路径 /uploads/** 映射到本地物理路径 file:...+path
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + path);
    }
}