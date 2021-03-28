package com.example.demo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TestMapper;
import com.example.demo.repository.ListPrimaryEntityMapper;

@SpringBootTest
class ListPrimaryLogicSharedServiceTest {
	@Autowired
	ListPrimaryLogicSharedService listPrimaryLogicSharedService;
	@Autowired
	ListPrimaryEntityMapper listPrimaryEntityMapper;
	@Autowired
	TestMapper testMapper;
	
	private int spaceId;
	
	public ListPrimaryLogicSharedServiceTest() {
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
		
		//データセット
		testMapper.insert("todo_space", "1");
	}
	
	@Test
	@Transactional
	void insertListPrimaryTest() {
		try {
			int listId = listPrimaryLogicSharedService.insertListPrimary(spaceId);
			Assertions.assertNotNull(
					listPrimaryEntityMapper.selectByPrimaryKey(listId));
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
}
