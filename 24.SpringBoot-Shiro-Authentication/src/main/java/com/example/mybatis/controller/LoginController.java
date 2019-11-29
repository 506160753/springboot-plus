package com.example.mybatis.controller;

import com.example.mybatis.domain.TbUser;
import com.example.mybatis.util.AjaxResult;
import com.example.mybatis.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return AjaxResult.success();
        } catch (UnknownAccountException e) {
            return AjaxResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return AjaxResult.error(e.getMessage());
        } catch (LockedAccountException e) {
            return AjaxResult.error(e.getMessage());
        } catch (AuthenticationException e) {
            return AjaxResult.error("认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        TbUser user = (TbUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}
