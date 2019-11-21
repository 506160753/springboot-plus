package com.example.dome.controller;

import com.example.dome.domain.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/11/14 9:37
 */
@Controller
public class TbUserController {

    @RequestMapping("/index")
    public String index(Model model) {
        List<TbUser> list = new ArrayList<>();
        TbUser tbUser = new TbUser();
        tbUser.setLoginName("测试");
        tbUser.setPhone("177");
        list.add(tbUser);
        list.add(tbUser);
        list.add(tbUser);
        model.addAttribute("list",list);
        return "index";
    }

}
