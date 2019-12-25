package com.example.demo.controller;

/**
 * @author Administrator
 * @date 2019/11/25 14:21
 */

import com.example.demo.domain.TbUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2019/11/25 14:21
 */
@Api(tags = "用户Controller")
@Controller
@RequestMapping("/tbUser")
public class UserController {

    @ApiIgnore
    @GetMapping("/hello")
    public @ResponseBody
    String hello() {
        return "hello";
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public @ResponseBody
    TbUser getTbUserById(@PathVariable(value = "id") Long id) {
        TbUser tbUser = new TbUser();
        tbUser.setId(id);
        tbUser.setLoginName("test");
        tbUser.setPassword("123456");
        return tbUser;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    public @ResponseBody
    List<TbUser> getTbUserList() {
        List<TbUser> list = new ArrayList<>();
        TbUser tbUser1 = new TbUser();
        tbUser1.setId(1L);
        tbUser1.setLoginName("test");
        tbUser1.setPassword("123456");
        list.add(tbUser1);
        TbUser tbUser2 = new TbUser();
        tbUser2.setId(2L);
        tbUser2.setLoginName("dome");
        tbUser2.setPassword("123456");
        list.add(tbUser2);
        return list;
    }

    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
    @ApiImplicitParam(name = "tbUser", value = "用户实体", required = true, dataType = "TbUser")
    @PostMapping("/add")
    public @ResponseBody
    Map<String, Object> addTbUser(@RequestBody TbUser tbUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public @ResponseBody
    Map<String, Object> deleteTbUser(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @ApiOperation(value = "更新用户", notes = "根据用户id更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "tbUser", value = "用户实体", required = true, dataType = "TbUser")})
    @PutMapping("/{id}")
    public @ResponseBody
    Map<String, Object> updateTbUser(@PathVariable(value = "id") Long id, @RequestBody TbUser tbUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

}