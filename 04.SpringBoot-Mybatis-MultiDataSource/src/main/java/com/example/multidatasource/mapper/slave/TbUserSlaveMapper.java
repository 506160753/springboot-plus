package com.example.multidatasource.mapper.slave;


import com.example.multidatasource.domain.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface TbUserSlaveMapper {

    @Select("select * from tb_user where id=#{id}")
    TbUser selectById(Long id);

}
