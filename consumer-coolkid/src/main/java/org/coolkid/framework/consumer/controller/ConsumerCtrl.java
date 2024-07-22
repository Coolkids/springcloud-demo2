package org.coolkid.framework.consumer.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.coolkid.framework.base.api.vo.Result;
import org.coolkid.framework.consumer.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by coolkid on 2021/11/25.
 */
@RestController
@RequestMapping("/client")
@Slf4j
@Data
public class ConsumerCtrl {
    private final HelloWorldService helloWorldService;

    @GetMapping(value = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result helloWorld(HttpSession session, HttpServletRequest request){
        log.info("consumer sessionid:{}", session.getId());
        if(Objects.isNull(session.getAttribute("id"))){
            session.setAttribute("id", UUID.randomUUID().toString());
        }
        log.info("consumer header addvcd:{}", request.getHeader("addvcd"));
        log.info("consumer header addvcd2:{}", request.getHeader("addvcd2"));
        return helloWorldService.helloworld();
    }

}
