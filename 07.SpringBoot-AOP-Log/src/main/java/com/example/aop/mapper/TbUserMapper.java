package com.example.aop.mapper;


import com.example.aop.domain.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表：包括三个或以上字段，ID，用户名，对该用户的描述，其它(如地址、电话等信息) Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2019-03-10
 */
@Mapper
@Component
public interface TbUserMapper {

    @Select("select * from tb_user where id=#{id}")
    TbUser selectById(Long id);

}
