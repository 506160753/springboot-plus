package com.example.demo.controller;

import com.example.demo.domian.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxing
 * @version 1.0
 * @date 2019/12/27 17:34
 */
@RestController
@RequestMapping("user")
public class TestController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{id:\\d+}")
    public User get(@PathVariable Long id) {
        log.info("获取用户id为 " + id + "的信息");
        return new User(id, "test", "123456");
    }

    @GetMapping("users")
    public List<User> get(String ids) {
        log.info("批量获取用户信息");
        List<User> list = new ArrayList<>();
        for (String id : ids.split(",")) {
            list.add(new User(Long.valueOf(id), "user" + id, "123456"));
        }
        return list;
    }

    @GetMapping
    public List<User> get() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "test", "123456"));
        list.add(new User(2L, "scott", "123456"));
        log.info("获取用户信息 " + list);
        return list;
    }

    @PostMapping
    public void add(@RequestBody User user) {
        log.info("新增用户成功 " + user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        log.info("更新用户成功 " + user);
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable Long id) {
        log.info("删除用户成功 " + id);
    }
}