package com.hku.mng.web;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pengzhengfa
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MedicineMngApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicineMngApplication.class, args);
    }

}
