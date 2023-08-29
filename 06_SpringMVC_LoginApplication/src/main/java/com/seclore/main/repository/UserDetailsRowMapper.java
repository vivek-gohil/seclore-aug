package com.seclore.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seclore.main.domain.UserDetails;

public class UserDetailsRowMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		String userId = rs.getString("user_id");
		String name = rs.getString("name");
		String password = rs.getString("password");

		UserDetails userDetails = new UserDetails(userId, name, password);
		return userDetails;
	}

}
