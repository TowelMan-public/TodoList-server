package com.example.demo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TestMapper;
import com.example.demo.configurer.UserAuthorityInSpaceConstant;
import com.example.demo.repository.SpaceEntityMapper;
import com.example.demo.repository.UserInSpaceEntityMapper;

@SpringBootTest
class SimpleTodoLogicSharedServiceTest {
	@Autowired
	SimpleTodoLogicSharedService simpleTodoLogicSharedService;
	@Autowired
	SpaceEntityMapper spaceEntityMapper;
	@Autowired
	UserInSpaceEntityMapper userInSpaceEntityMapper;
	@Autowired
	TestMapper testMapper;
	
	private int simpleSpaceIdForUser1;
	private int spaceId;
	private int user1;
	private int user2;
	
	public SimpleTodoLogicSharedServiceTest() {
		simpleSpaceIdForUser1 = 1;
		spaceId = 2;
		user1 = 1;
		user2 = 2;
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
		
		//1人のしんぷるToDoリストのデータセット
		testMapper.insert("todo_space", "1");
		testMapper.insert("todo_space_details", "1,'',3,1,1,'2020-9-9'");
		testMapper.insert("users","1,'a','',1");
		testMapper.insert("have_user_list", "1,1,2");
		
		//もう一人のユーザーとスペース
		testMapper.insert("users","2,'b','',1");
		testMapper.insert("todo_space", "2");
	}
	
	@Test
	@Transactional
	void createNewSimpleTodoListSpaceTest() {
		try {
			simpleTodoLogicSharedService.createNewSimpleTodoListSpace(spaceId,user2);
			
			//SimpleSpaceとして作成されたか
			Assertions.assertTrue(
					spaceEntityMapper.selectByPrimaryKey(spaceId)
						.getIsSimple());
			
			//ユーザーが適切に登録されているか
			Assertions.assertEquals(
					UserAuthorityInSpaceConstant.SUPER,
					userInSpaceEntityMapper.selectByPrimaryKey(spaceId, user2)
						.getAuthorityId());
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
	
	@Test
	@Transactional
	void getSimpleSpaceIdTest() {
		try {
			Assertions.assertEquals(
					simpleTodoLogicSharedService.getSimpleSpaceId(user1),
					simpleSpaceIdForUser1);
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
}
