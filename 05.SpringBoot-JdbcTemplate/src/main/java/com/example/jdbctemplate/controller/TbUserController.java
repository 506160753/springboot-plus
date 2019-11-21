package com.example.jdbctemplate.controller;

import com.example.jdbctemplate.domain.TbUser;
import com.example.jdbctemplate.service.TbUserService;
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

    @PostMapping("/selectById")
    public TbUser selectById(Long id) {
        return tbUserService.selectById(id);
    }


}
