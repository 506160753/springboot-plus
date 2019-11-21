package com.example.multidatasource.service.impl;

import com.example.multidatasource.domain.TbUser;
import com.example.multidatasource.mapper.master.TbUserMasterMapper;
import com.example.multidatasource.mapper.slave.TbUserSlaveMapper;
import com.example.multidatasource.service.TbUserService;
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
    private TbUserMasterMapper tbUserMasterMapper;

    @Autowired
    private TbUserSlaveMapper tbUserSlaveMapper;

    @Override
    public TbUser selectById(Long id) {
        return tbUserMasterMapper.selectById(id);
    }

    @Override
    public TbUser selectSlaveById(Long id) {
        return tbUserSlaveMapper.selectById(id);
    }


}
