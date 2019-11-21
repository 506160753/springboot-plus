package com.example.jdbctemplate.service.impl;

import com.example.jdbctemplate.domain.TbUser;
import com.example.jdbctemplate.dao.TbUserDao;
import com.example.jdbctemplate.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private TbUserDao tbUserDao;

    @Override
    public TbUser selectById(Long id) {
        return tbUserDao.selectById(id);
    }

    @Override
    public int add(TbUser tbUser) {
        return tbUserDao.add(tbUser);
    }

    @Override
    public int update(TbUser tbUser) {
        return tbUserDao.update(tbUser);
    }

    @Override
    public int delete(Long id) {
        return tbUserDao.delete(id);
    }

    @Override
    public List<Map<String, Object>> list() {
        return tbUserDao.list();
    }
}
