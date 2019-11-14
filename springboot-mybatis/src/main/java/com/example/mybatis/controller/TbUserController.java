package com.example.mybatis.controller;

import com.example.mybatis.domain.TbUser;
import com.example.mybatis.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public TbUser selectById(Long id){
        return tbUserService.selectById(id);
    }

}
