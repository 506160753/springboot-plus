package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author liuxing
 * @version 1.0
 * @date 2019/12/28 17:17
 */
@RestController
public class TestController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("testCache")
    public void testCache() {
        userService.getUser(1L);
        userService.getUser(1L);
        userService.getUser(1L);
    }

    @GetMapping("testRequestMerge")
    public void testRequerstMerge() throws InterruptedException, ExecutionException {
        Future<User> f1 = userService.findUser(1L);
        Future<User> f2 = userService.findUser(2L);
        Future<User> f3 = userService.findUser(3L);
        f1.get();
        f2.get();
        f3.get();
        Thread.sleep(200);
        Future<User> f4 = userService.findUser(4L);
        f4.get();
    }

}
