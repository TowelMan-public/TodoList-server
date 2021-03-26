package com.example.demo.logic;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AlreadyUsedException;

public class UserLogicSharedServiceTest {
	@Autowired
	UserLogicSharedService serLogicSharedService;
	
	//UserEntity getUserByUsername(String username) throws UsernameNotFoundException
	//void verificationExistsUsername(String username) throws NotFoundException
	//void verificationNotUsedUsername(String username) throws AlreadyUsedException
}
