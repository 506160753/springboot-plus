package com.example.mybatis.controller;

import com.example.mybatis.domain.TbUser;
import com.example.mybatis.jwt.JWTUtil;
import com.example.mybatis.service.TbUserService;
import com.example.mybatis.util.AjaxResult;
import com.example.mybatis.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping("/login")
    public AjaxResult login(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        final String errorMessage = "用户名或密码错误";
        TbUser user = tbUserService.findByUserName(username);
        if (user == null) {
            return AjaxResult.error(errorMessage);
        }
        if (!StringUtils.equals(user.getPassword(), password)) {
            return AjaxResult.error(errorMessage);
        }
        // 生成 Token
        String tokenValue = JWTUtil.sign(username, password);
        Map<String, Object> userInfo = this.generateUserInfo(tokenValue, user);
        return AjaxResult.success(userInfo);

    }

    /**
     * 生成前端需要的用户信息，包括：
     * 1. token
     * 2. user
     *
     * @param token token
     * @param user  用户信息
     * @return UserInfo
     */
    private Map<String, Object> generateUserInfo(String token, TbUser user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("token", token);

        user.setPassword("it's a secret");
        userInfo.put("user", user);
        return userInfo;
    }

}
