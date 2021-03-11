package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserEntity user = mapper.findByUsername(username);
		if(user ==null)
			throw new UsernameNotFoundException("");
		else
			return user;
    }
}
