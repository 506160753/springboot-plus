package com.example.mybatis.controller;

import com.example.mybatis.util.AjaxResult;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/test")
    public AjaxResult test() {
        return AjaxResult.success();
    }

    @GetMapping("hello")
    public String hello() {
        return "hello spring security";
    }

    @RequestMapping("/index")
    public Object index(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/signout/success")
    public String signout() {
        return "退出成功，请重新登录";
    }

}
