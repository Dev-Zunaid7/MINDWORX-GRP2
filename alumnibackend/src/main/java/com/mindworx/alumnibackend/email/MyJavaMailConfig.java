package com.mindworx.alumnibackend.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MyJavaMailConfig {
    @Bean
    public JavaMailSender javaMailSender() { 
          return new JavaMailSenderImpl();
    }
}
