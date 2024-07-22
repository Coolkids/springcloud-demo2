package org.coolkid.framework.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by coolkid on 2021/11/25.
 */

@SpringBootApplication
@ComponentScan(basePackages={"org.coolkid"})
@EnableFeignClients(basePackages = {"org.coolkid"})
@LoadBalancerClients
public class ConsumerRun {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRun.class);
    }
}
