package com.example.multidatasource.controller;

import com.example.multidatasource.domain.TbUser;
import com.example.multidatasource.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 * @date 2019/11/14 9:37
 */
@RestController
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping("/selectById")
    public Object selectById(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("master", tbUserService.selectById(id));
        map.put("slave", tbUserService.selectSlaveById(id));
        return map;
    }


}
