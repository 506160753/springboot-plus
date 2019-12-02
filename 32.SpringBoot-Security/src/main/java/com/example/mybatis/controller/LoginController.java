package com.example.mybatis.controller;

import com.example.mybatis.util.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/test")
    @ResponseBody
    public AjaxResult test() {
        return AjaxResult.success();
    }

}
