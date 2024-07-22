package org.coolkid.framework.consumer.callback;

import org.coolkid.framework.base.api.vo.Result;
import org.coolkid.framework.consumer.service.HelloWorldService;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by coolkid on 2021/11/26.
 */

@Component
public class HelloWorldServiceHystrix implements HelloWorldService {
    @Override
    public Result helloworld() {
        return new Result("error", new Date(), "-1", "no session");
    }
}
