package com.example.mybatis.controller;

import com.example.mybatis.util.AjaxResult;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/test")
    @ResponseBody
    public AjaxResult test() {
        return AjaxResult.success();
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello spring security";
    }

    @RequestMapping("/index")
    public Object index(Authentication authentication) {
        return authentication;
    }
}
