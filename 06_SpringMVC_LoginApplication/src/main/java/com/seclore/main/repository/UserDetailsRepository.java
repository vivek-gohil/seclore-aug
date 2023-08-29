package com.seclore.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.UserDetails;

@Component
public class UserDetailsRepository implements UserDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ONE = "select * from user_details where user_id=? and password=?";

	@Override
	public UserDetails validate(UserDetails userDetails) {
		try {
			Object[] args = { userDetails.getUserId(), userDetails.getPassword() };
			userDetails = jdbcTemplate.queryForObject(SELECT_ONE, new UserDetailsRowMapper(), args);
			return userDetails;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
