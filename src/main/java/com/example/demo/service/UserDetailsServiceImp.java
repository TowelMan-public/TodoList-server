package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDetailsImp;
import com.example.demo.repository.LoginUserMapper;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private LoginUserMapper mapper;
	
	@Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserDetailsImp user = mapper.findByUsername(username);
		if(user ==null)
			throw new UsernameNotFoundException("");
		else
			return user;
    }
}
