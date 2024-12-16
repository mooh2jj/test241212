package com.dsg.test241212.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${app.aws.ec2.instance-front-url}")
    private String frontInstanceURL;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins(frontInstanceURL)   // 모든 도메인에 대해 허용
                .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(300)    // 300초 동안 캐싱
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type");
    }


}
