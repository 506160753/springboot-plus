package com.example.config.controller;

import com.example.config.config.BlogProperties;
import com.example.config.config.ConfigBean;
import com.example.config.config.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/index")
    private Object index() {
        Map<String, Object> map = new HashMap<>();
        map.put("blogProperties", blogProperties.getName() + "，" + blogProperties.getTitle());
        map.put("configBean", configBean.getName() + "，" + configBean.getTitle() + "，" + configBean.getWholeTitle());
        map.put("testConfigBean", testConfigBean.getName() + "，" + testConfigBean.getAge());
        return map;
    }
}
