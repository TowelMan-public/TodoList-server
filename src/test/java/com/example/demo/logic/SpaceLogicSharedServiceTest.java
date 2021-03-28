package com.example.demo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TestMapper;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.exception.IsSimpleSpaceException;
import com.example.demo.exception.SpaceIsnotPublicException;

@SpringBootTest
class SpaceLogicSharedServiceTest {
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	TestMapper testMapper;
	
	private int protectedSpaceId;
	private int simpleSpaceId;
	private int publicSpaceId;
	private int userIdCanSelect;
	private int userIdCanAll;
	private int userIdCannot;
	
	public SpaceLogicSharedServiceTest() {
		protectedSpaceId = 1;
		simpleSpaceId = 3;
		publicSpaceId = 2;
		userIdCanSelect = 1;
		userIdCanAll = 2;
		userIdCannot = 3;
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
		testMapper.insert("users", "1,'a','',1");//userIdCanSelect
		testMapper.insert("users", "2,'b','',1");//userIdCanAll
		testMapper.insert("users", "3,'c','',1");//userIdCannot
		
		//スペース作成
		testMapper.insert("todo_space", "1");//protectedSpaceId
		testMapper.insert("todo_space", "2");//publicSpaceId
		testMapper.insert("todo_space", "3");//simpleSpaceId
		
		
		//スペースの内容
		testMapper.insert("todo_space_details", "1,'',2,0,1,'2020-9-9'");//protectedSpaceId
		testMapper.insert("todo_space_details", "2,'',1,0,1,'2020-9-9'");//publicSpaceId
		testMapper.insert("todo_space_details", "3,'',3,1,1,'2020-9-9'");//simpleSpaceId
		
		//protectedSpaceIdにユーザー追加
		testMapper.insert("have_user_list", "1,1,3");
		testMapper.insert("have_user_list", "1,2,2");
		
	}
	
	@Test
	@Transactional
	void verificationEnableAllTest() {
		//SUPER権限がある == MASTER権限があるのと同義
		Assertions.assertDoesNotThrow( 
				() -> spaceLogicSharedService.verificationEnableAll(protectedSpaceId,userIdCanAll));
		
		//USER権限がある
		Assertions.assertThrows(HaveNotAuthorityInSpaceException.class,
				() -> spaceLogicSharedService.verificationEnableAll(protectedSpaceId,userIdCanSelect));
		
		//権限無　== 加入していない
		Assertions.assertThrows(HaveNotAuthorityInSpaceException.class,
				() -> spaceLogicSharedService.verificationEnableAll(protectedSpaceId,userIdCannot));
	}
	
	@Test
	@Transactional
	void verificationEnableSelectTest() {
		//SUPER権限がある == MASTER権限があるのと同義
		Assertions.assertDoesNotThrow( 
				() -> spaceLogicSharedService.verificationEnableSelect(protectedSpaceId,userIdCanAll));
		
		//USER権限がある
		Assertions.assertDoesNotThrow(
				() -> spaceLogicSharedService.verificationEnableSelect(protectedSpaceId,userIdCanSelect));
		
		//権限無　== 加入していない
		Assertions.assertThrows(HaveNotAuthorityInSpaceException.class,
				() -> spaceLogicSharedService.verificationEnableSelect(protectedSpaceId,userIdCannot));
	}
	
	@Test
	@Transactional
	void verificationIsPublicScopeTest() {
		//publicSpaceでない
		Assertions.assertThrows(SpaceIsnotPublicException.class,
				() -> spaceLogicSharedService.verificationIsPublicScope(protectedSpaceId));
		
		//publicSpace
		Assertions.assertDoesNotThrow(
				() -> spaceLogicSharedService.verificationIsPublicScope(publicSpaceId));
	}
	
	@Test
	@Transactional
	void verificationIsnotSimpleSpaceTest() {
		//シンプルToDo
		Assertions.assertDoesNotThrow(
				() -> spaceLogicSharedService.verificationIsnotSimpleSpace(simpleSpaceId));
		
		//シンプルToDoでない
		Assertions.assertThrows(IsSimpleSpaceException.class,
				() -> spaceLogicSharedService.verificationIsnotSimpleSpace(publicSpaceId));
	}
}
