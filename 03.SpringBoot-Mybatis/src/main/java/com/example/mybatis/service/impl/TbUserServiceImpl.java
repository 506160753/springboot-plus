package com.example.mybatis.service.impl;

import com.example.mybatis.domain.TbUser;
import com.example.mybatis.mapper.TbUserMapper;
import com.example.mybatis.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表：包括三个或以上字段，ID，用户名，对该用户的描述，其它(如地址、电话等信息) 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-03-10
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser selectById(Long id) {
        return tbUserMapper.selectById(id);
    }
}
