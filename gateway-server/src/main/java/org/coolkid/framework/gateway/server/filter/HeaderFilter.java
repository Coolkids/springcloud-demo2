package org.coolkid.framework.gateway.server.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created by coolkid on 2021/12/2.
 */

@Component
@Slf4j
public class HeaderFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest host = request.mutate().headers(httpHeaders -> httpHeaders.add("addvcd", "440000,442000")).build();
        ServerWebExchange build = exchange.mutate().request(host).build();
        log.info("gateway add header");
        return chain.filter(build);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
