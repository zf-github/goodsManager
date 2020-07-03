package com.zf.goods.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CustomWebConfiguration implements WebMvcConfigurer {
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String filePath = System.getProperty("user.dir");
        filePath = filePath + "\\src\\main\\resources\\static\\images\\";
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+filePath);
    }
}
