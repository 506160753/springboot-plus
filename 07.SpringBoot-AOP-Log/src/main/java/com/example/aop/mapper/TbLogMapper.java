package com.example.aop.mapper;

import com.example.aop.domain.TbLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2019/11/21 12:51
 */
@Mapper
@Component
public interface TbLogMapper {

    @Insert("insert into tb_log(url,description,create_time,ip,spend_time) values (#{url},#{description},#{createTime},#{ip},#{spendTime})")
    void insert(TbLog tbLog);

}
