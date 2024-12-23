package com.dsg.test241212.init;

import com.dsg.test241212.entity.Test;
import com.dsg.test241212.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.LongStream;

@Slf4j
@Configuration
@RequiredArgsConstructor
//@Profile("!prod")
public class NotProd {

    private final TestRepository testRepository;

    @Bean
    CommandLineRunner initData() {
        return (args) -> {
            log.info("init data start...");

            if(testRepository.count() > 0) {
                log.info("init data already exists...");
                return;
            }
            LongStream.rangeClosed(1, 5).forEach(i -> {
                // test data
                Test test = Test.builder()
                        .title("title_" + i)
                        .build();

                testRepository.save(test);

            });
        };
    }
}
