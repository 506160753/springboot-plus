package com.example.multidatasource.dao;


import com.example.multidatasource.domain.TbUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表：包括三个或以上字段，ID，用户名，对该用户的描述，其它(如地址、电话等信息) Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2019-03-10
 */
public interface TbUserDao {

    TbUser selectById(Long id);

    TbUser selectSlaveById(Long id);

    int add(TbUser tbUser);

    int update(TbUser tbUser);

    int delete(Long id);

    List<Map<String, Object>> list();

}
