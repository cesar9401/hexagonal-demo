package com.hexagonal.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HexagonalDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalDemoApplication.class, args);
    }
}
