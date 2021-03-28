package com.example.demo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TestMapper;
import com.example.demo.exception.UserAleadyJoinSpaceException;

@SpringBootTest
class UserInSpaceLogicSharedServiceTest {
	@Autowired
	UserInSpaceLogicSharedService userInSpaceLogicSharedService;
	@Autowired
	TestMapper testMapper;
	
	private int userIdInSpace;
	private int userIdInNoSpace;
	private int spaceId;
	
	public UserInSpaceLogicSharedServiceTest(){
		userIdInSpace = 1;
		userIdInNoSpace = 2;
		spaceId = 1;
	}
	
	@BeforeEach
	void befoer() {
		testMapper.deleteAll("todo_content");
		testMapper.deleteAll("todo_list_details");
		testMapper.deleteAll("todo_list");
		testMapper.deleteAll("todo_space_details");
		testMapper.deleteAll("have_user_list");
		testMapper.deleteAll("todo_space");
		testMapper.deleteAll("users");
		
		//ユーザーデータセット
		testMapper.insert("users", "1,'a','',1");//userIdInSpace
		testMapper.insert("users", "2,'b','',1");//userIdInNoSpace
		
		//スペース作成
		testMapper.insert("todo_space", "1");//spaceId
		
		//spaceIdにユーザー追加
		testMapper.insert("have_user_list", "1,1,3");
		
	}
	
	@Test
	@Transactional
	void verificationNotJoinedUserInSpaceTest() {
		//加入しているユーザー
		Assertions.assertDoesNotThrow(
				() -> userInSpaceLogicSharedService.verificationNotJoinedUserInSpace(spaceId,userIdInSpace));
		
		//加入していないユーザー
		Assertions.assertThrows(UserAleadyJoinSpaceException.class,
				() -> userInSpaceLogicSharedService.verificationNotJoinedUserInSpace(spaceId,userIdInNoSpace));
	}
}
