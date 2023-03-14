package com.example.springsecuritysample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.springsecuritysample.repository")
//@EntityScan(basePackages = {"com.example.springsecuritysample.entity"})
public class SpringSecuritySampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecuritySampleApplication.class, args);
    }

}
