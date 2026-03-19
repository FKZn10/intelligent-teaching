package com.rainng.coursesystem.config;

import com.rainng.coursesystem.config.themis.ThemisInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final ThemisInterceptor themisInterceptor;

    public WebConfig(ThemisInterceptor themisInterceptor) {
        this.themisInterceptor = themisInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(themisInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/uploads/**"); // 🌟 修改点 1：让拦截器放行 /uploads/ 下的所有图片
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedOrigins("*");
    }

    // 🌟 修改点 2：新增静态资源映射方法，把网络请求引流到你电脑的本地文件夹里
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadDirPath = System.getProperty("user.dir") + "/uploads/";
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadDirPath);
    }
}