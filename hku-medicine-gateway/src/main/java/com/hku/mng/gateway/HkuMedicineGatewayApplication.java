package com.hku.mng.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pengzhengfa
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HkuMedicineGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HkuMedicineGatewayApplication.class, args);
    }

}
