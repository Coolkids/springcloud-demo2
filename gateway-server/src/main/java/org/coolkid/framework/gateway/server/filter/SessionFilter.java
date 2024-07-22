package org.coolkid.framework.gateway.server.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by coolkid on 2021/11/26.
 */

@Component
@Slf4j
public class SessionFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("gateway filter");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest host = request.mutate().headers(httpHeaders -> httpHeaders.add("addvcd2", "lalala")).build();
        ServerWebExchange build = exchange.mutate().request(host).build();
        return build.getSession().flatMap(
                session -> {
                    if (Objects.isNull(session.getAttribute("id2"))) {
                        session.getAttributes().put("id2", UUID.randomUUID().toString());
                    }
                    log.info("gateway session id2:{}", session.getAttributes().get("id2"));
                    log.info("gateway sessionid:{}", session.getId());
                    return chain.filter(build);
                }
        ).then(Mono.fromRunnable(() -> log.info("this is a post filter")));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
