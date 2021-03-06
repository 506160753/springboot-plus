package com.example.demo.service;


import com.example.demo.domain.TbUser;

/**
 * <p>
 * 用户表：包括三个或以上字段，ID，用户名，对该用户的描述，其它(如地址、电话等信息) 服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-03-10
 */
public interface TbUserService {

    TbUser selectById(Long id);

    int add(TbUser tbUser);

    int update(TbUser tbUser);

    int delete(Long id);
}
