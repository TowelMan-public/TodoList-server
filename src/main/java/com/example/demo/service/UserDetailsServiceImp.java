package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDetailsImp;
import com.example.demo.entity.UserEntity;
import com.example.demo.logic.UserLogicSharedService;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private UserLogicSharedService userLogicSharedService;
	
	@Override
    public UserDetailsImp loadUserByUsername(final String username) throws UsernameNotFoundException {
		return new UserDetailsImp(userLogicSharedService.getUserByUsername(username));
    }

	public UserDetails loadUserByUserId(Integer userId) {
		UserEntity entity = userLogicSharedService.getUserByUserId(userId);
		
		if(entity != null && entity.getIsEnabled() == 1)
			return new UserDetailsImp(entity);
		else
			return null;
	}
}
