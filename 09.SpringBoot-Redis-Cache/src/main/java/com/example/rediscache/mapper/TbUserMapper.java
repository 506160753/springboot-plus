package com.example.rediscache.mapper;


import com.example.rediscache.domain.TbUser;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
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

    @Insert("insert into tb_user (id,login_name) values (#{id},#{loginName})")
    int add(TbUser tbUser);

    @Update("update tb_user set login_name = #{loginName} where id = #{id}")
    int update(TbUser tbUser);

    @Delete("delete from tb_user where id = #{id}")
    int delete(Long id);
}
