package com.instance.layanglayangserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LayangLayangApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayangLayangApplication.class, args);
    }

}
