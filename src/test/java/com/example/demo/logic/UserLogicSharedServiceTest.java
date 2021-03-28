package com.example.demo.logic;

import org.apache.ibatis.javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TestMapper;
import com.example.demo.exception.AlreadyUsedException;

@SpringBootTest
class UserLogicSharedServiceTest {
	@Autowired
	UserLogicSharedService userLogicSharedService;
	@Autowired
	TestMapper testMapper;
	
	private String insertedUsername;
	private int insertedUserId;
	private String notInsertedUsername;
	
	public UserLogicSharedServiceTest() {
		insertedUserId = 1;
		insertedUsername = "testUser";
		notInsertedUsername = "hogeUser";
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
		testMapper.insert("users", "1,'testUser','',1");//userIdCanSelect		
	}
	
	@Test
	@Transactional
	void getUserByUsernameTest() {
		//存在するユーザー名
		Assertions.assertEquals(
				insertedUserId,
				userLogicSharedService.getUserByUsername(insertedUsername)
					.getUserId());
		
		//存在しないユーザー名
		Assertions.assertThrows(UsernameNotFoundException.class,
				() -> userLogicSharedService.getUserByUsername(notInsertedUsername));	
	}
	
	@Test
	@Transactional
	void verificationExistsUsernameTest() {
		//存在するユーザー名
		Assertions.assertDoesNotThrow( 
				() -> userLogicSharedService.verificationExistsUsername(insertedUsername));
		
		//存在しないユーザー名
		Assertions.assertThrows(NotFoundException.class,
				() -> userLogicSharedService.verificationExistsUsername(notInsertedUsername));
	}
	
	@Test
	@Transactional
	void verificationNotUsedUsernameTest() {		
		//存在するユーザー名
		Assertions.assertThrows(AlreadyUsedException.class,
				() -> userLogicSharedService.verificationNotUsedUsername(insertedUsername));
		
		//存在しないユーザー名
		Assertions.assertDoesNotThrow(
				() -> userLogicSharedService.verificationNotUsedUsername(notInsertedUsername));
	}
}
