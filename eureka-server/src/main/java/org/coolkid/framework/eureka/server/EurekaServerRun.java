package org.coolkid.framework.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by coolkid on 2021/11/24.
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerRun {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerRun.class);
    }
}
