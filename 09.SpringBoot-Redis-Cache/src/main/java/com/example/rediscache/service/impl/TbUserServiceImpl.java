package com.example.rediscache.service.impl;

import com.example.rediscache.domain.TbUser;
import com.example.rediscache.mapper.TbUserMapper;
import com.example.rediscache.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

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

    @Override
    public int add(TbUser tbUser) {
        return tbUserMapper.add(tbUser);
    }

    @Override
    public TbUser update(TbUser tbUser) {
        tbUserMapper.update(tbUser);
        return tbUser;
    }

    @Override
    public int delete(Long id) {
        return tbUserMapper.delete(id);
    }

}
