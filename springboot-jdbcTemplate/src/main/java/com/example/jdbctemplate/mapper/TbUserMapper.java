package com.example.jdbctemplate.mapper;

import com.example.jdbctemplate.domain.TbUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TbUserMapper implements RowMapper<TbUser> {

	@Override
	public TbUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		TbUser tbUser = new TbUser();
		tbUser.setLoginName(rs.getString("login_name"));
		tbUser.setPassword(rs.getString("password"));
		tbUser.setSex(rs.getString("sex"));
		return tbUser;
	}
}
