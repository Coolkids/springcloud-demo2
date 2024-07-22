package org.coolkid.framework.provider.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.coolkid.framework.base.api.vo.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by coolkid on 2021/11/25.
 */

@RestController
@RequestMapping("/api")
@Slf4j
public class HelloWorldCtrl {
    @SneakyThrows
    @GetMapping(value = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result helloWorld(HttpSession session, HttpServletRequest request) {
        log.info("provider1 sessionid:{}", session.getId());
        log.info("provider1 header addvcd:{}", request.getHeader("addvcd"));
        log.info("provider1 header addvcd2:{}", request.getHeader("addvcd2"));
        Object id = session.getAttribute("id");
        Result result = new Result();
        result.setMsg("hello world");
        result.setTs(new Date());
        result.setMid("1");
        result.setSessionId(String.valueOf(id));
        return result;
    }
}
