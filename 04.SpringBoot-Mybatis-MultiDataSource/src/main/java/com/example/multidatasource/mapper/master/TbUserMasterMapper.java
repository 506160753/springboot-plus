package com.example.multidatasource.mapper.master;


import com.example.multidatasource.domain.TbUser;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface TbUserMasterMapper {

    @Select("select * from tb_user where id=#{id}")
    TbUser selectById(Long id);

}
