package com.example.aop.controller;

import com.example.aop.annotation.Log;
import com.example.aop.domain.TbUser;
import com.example.aop.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/11/14 9:37
 */
@RestController
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @Log("查询用户详情")
    @PostMapping("/selectById")
    public TbUser selectById(Long id) {
        TbUser tbUser = tbUserService.selectById(id);
        return tbUser;
    }

}
