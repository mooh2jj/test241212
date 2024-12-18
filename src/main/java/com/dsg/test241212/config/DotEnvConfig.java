package com.dsg.test241212.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotEnvConfig {

    @Bean
    public Dotenv dotenv() {
        // .env 파일을 읽어서 환경변수로 사용
        return Dotenv.load();
    }
}