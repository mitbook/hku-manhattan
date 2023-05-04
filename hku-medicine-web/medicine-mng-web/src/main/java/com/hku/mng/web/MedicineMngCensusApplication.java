package com.hku.mng.web;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author pengzhengfa
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class MedicineMngCensusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicineMngCensusApplication.class, args);
    }

}
