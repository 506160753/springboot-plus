package com.example.mybatis.controller;

import com.example.mybatis.domain.UserOnline;
import com.example.mybatis.service.SessionService;
import com.example.mybatis.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/online")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping("/index")
    public String online() {
        return "online";
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<UserOnline> list() {
        return sessionService.list();
    }

    @ResponseBody
    @RequestMapping("/forceLogout")
    public AjaxResult forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("踢出用户失败");
        }

    }
}
