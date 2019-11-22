package com.example.demo.controller;

import com.example.demo.domain.TbUser;
import com.example.demo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TbUserController {

    @Autowired
    TbUserService tbUserService;

    @GetMapping("user/{id}")
    public TbUser selectById(@PathVariable(value = "id") Long id) {
        return this.tbUserService.selectById(id);
    }

    @PostMapping("user/save")
    public void saveUser(@RequestBody TbUser user) {
        this.tbUserService.add(user);
    }
}
