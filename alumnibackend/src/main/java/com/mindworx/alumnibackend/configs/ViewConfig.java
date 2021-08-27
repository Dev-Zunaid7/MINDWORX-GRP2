package com.mindworx.alumnibackend.configs;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ViewConfig implements WebMvcConfigurer {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path profileImageDir    = Paths.get("./userprofileImg");
        String profileImagePath =profileImageDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/userprofileImg/**").addResourceLocations("file:/" + profileImagePath +"/");
    }
}