package com.example.mybatis.controller;

import com.example.mybatis.util.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequiresPermissions("tbUser:select")
    @RequestMapping("/list")
    public AjaxResult userList() {
        return AjaxResult.success();
    }

    @RequiresPermissions("tbUser:save")
    @RequestMapping("/add")
    public AjaxResult userAdd() {
        return AjaxResult.success();
    }

    @RequiresPermissions("tbUser:delete")
    @RequestMapping("/delete")
    public AjaxResult userDelete() {
        return AjaxResult.success();
    }
}
