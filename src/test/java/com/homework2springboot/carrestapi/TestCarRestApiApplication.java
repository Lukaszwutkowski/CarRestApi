package com.homework2springboot.carrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCarRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(CarRestApiApplication::main).with(TestCarRestApiApplication.class).run(args);
    }

}
