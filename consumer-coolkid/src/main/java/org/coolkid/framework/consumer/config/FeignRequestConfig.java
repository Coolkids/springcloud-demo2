package org.coolkid.framework.consumer.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.Objects;

/**
 * Created by coolkid on 2021/11/26.
 */

/**
 * 处理feign 传递header
 */

@Configuration
public class FeignRequestConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames == null) {
            return;
        }
        //处理上游请求头信息，传递时继续携带
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String values = request.getHeader(name);
            requestTemplate.header(name, values);
        }
    }
}
