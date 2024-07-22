package org.coolkid.framework.consumer.service;

import org.coolkid.framework.base.api.vo.Result;
import org.coolkid.framework.consumer.callback.HelloWorldServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by coolkid on 2021/11/25.
 */

@Component
@FeignClient(value = "PROVIDER-COOLKID",contextId = "demo", path = "/provider-coolkid", fallback = HelloWorldServiceHystrix.class)
public interface HelloWorldService {
    @GetMapping(value = "/api/helloworld")
    public Result helloworld();
}
