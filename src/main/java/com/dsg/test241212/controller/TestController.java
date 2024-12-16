package com.dsg.test241212.controller;

import com.dsg.test241212.dto.TestDTO;
import com.dsg.test241212.entity.Test;
import com.dsg.test241212.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/test")
    public List<TestDTO> test() {
        return testRepository.findAll().stream()
                .map(test -> TestDTO.builder()
                        .id(test.getId())
                        .title(test.getTitle())
                        .build())
                .toList();
    }

    @GetMapping
    public String testHello() {
        return "Hello World!";
    }

}
