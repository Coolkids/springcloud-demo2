package org.coolkid.framework.gateway.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

/**
 * Created by coolkid on 2021/11/29.
 */

@Configuration
public class GatewayConfig {
    @Value("${spring.session.cookie-name:'GATEWAY-SESSION'}")
    private String cookieName;

    @Bean
    public WebSessionIdResolver webSessionIdResolver() {
        CookieWebSessionIdResolver resolver = new CookieWebSessionIdResolver();
        // 重写定义 cookie 名字
        resolver.setCookieName(cookieName);
        return resolver;
    }
}
