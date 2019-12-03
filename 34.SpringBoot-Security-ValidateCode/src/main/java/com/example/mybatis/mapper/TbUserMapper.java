package com.example.mybatis.mapper;


import com.example.mybatis.domain.TbPermission;
import com.example.mybatis.domain.TbRole;
import com.example.mybatis.domain.TbUser;

import java.util.List;

/**
 * <p>
 * 用户表：包括三个或以上字段，ID，用户名，对该用户的描述，其它(如地址、电话等信息) Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2019-03-10
 */
public interface TbUserMapper {

    TbUser findByUserName(String userName);

    TbUser selectById(Long id);

    List<TbRole> findRoleByUserId(Long id);

    List<TbPermission> findPermissionByUserId(Long id);

}
