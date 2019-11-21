package com.example.jdbctemplate.dao.impl;

import com.example.jdbctemplate.dao.TbUserDao;
import com.example.jdbctemplate.domain.TbUser;
import com.example.jdbctemplate.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2019/11/21 9:12
 */
@Repository
public class TbUserDaoImpl implements TbUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public TbUser selectById(Long id) {
        String sql = "select * from tb_user where id = ?";
        Object[] args = {id};
        int[] argTypes = {Types.BIGINT};
        List<TbUser> list = this.jdbcTemplate.query(sql, args, argTypes, new TbUserMapper());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int add(TbUser tbUser) {
        String sql = "insert into tb_user(login_name,password,phone) values(:login_name,:password,:phone)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        return npjt.update(sql, new BeanPropertySqlParameterSource(tbUser));
    }

    @Override
    public int update(TbUser tbUser) {
        String sql = "update tb_user set password = ?,phone = ? where login_name = ?";
        Object[] args = {tbUser.getLoginName(), tbUser.getPassword(), tbUser.getPhone()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int delete(Long id) {
        String sql = "delete from tb_user where sno = ?";
        Object[] args = {id};
        int[] argTypes = {Types.BIGINT};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String, Object>> list() {
        String sql = "select * from tb_user";
        return this.jdbcTemplate.queryForList(sql);
    }


}
