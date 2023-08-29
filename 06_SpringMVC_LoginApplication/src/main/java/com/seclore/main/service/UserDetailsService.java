package com.seclore.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.UserDetails;
import com.seclore.main.repository.UserDetailsRepositoryInterface;

@Component
public class UserDetailsService implements UserDetailsServiceInterface {

	@Autowired
	private UserDetailsRepositoryInterface userDetailsRepository;

	@Override
	public UserDetails validate(UserDetails userDetails) {
		return userDetailsRepository.validate(userDetails);
	}

}
