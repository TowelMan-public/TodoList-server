package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.UserAleadyJoinSpaceException;

public class UserInSpaceLogicSharedServiceTest {
	@Autowired
	UserInSpaceLogicSharedService userInSpaceLogicSharedService;
	
	//void verificationNotJoinedUserInSpace(int spaceId, int userId) throws UserAleadyJoinSpaceException
}
