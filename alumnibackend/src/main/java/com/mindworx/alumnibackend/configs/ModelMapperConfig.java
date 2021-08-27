package com.mindworx.alumnibackend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMap modelMapper() {
        return new ModelMap();
        }
        
}
