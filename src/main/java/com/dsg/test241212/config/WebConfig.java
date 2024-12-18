package com.dsg.test241212.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {


    private final Environment env;

    @Value("${app.aws.ec2.instance-front-url}")
    private String frontInstanceURL;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
         String allowedOrigins = null;

         if(env.getActiveProfiles()[0].equals("prod")) {
             allowedOrigins = frontInstanceURL;
         } else {
             allowedOrigins = "http://localhost:3000";
         }

        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)   // 모든 도메인에 대해 허용
                .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(300)    // 300초 동안 캐싱
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type");
    }


}
