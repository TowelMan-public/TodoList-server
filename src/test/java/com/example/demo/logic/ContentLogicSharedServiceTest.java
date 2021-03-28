package com.example.demo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TestMapper;
import com.example.demo.entity.ContentEntity;
import com.example.demo.repository.ContentEntityMapper;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@SpringBootTest
class ContentLogicSharedServiceTest {
	@Autowired
	ContentLogicSharedService contentLogicSharedService;
	@Autowired
	ContentEntityMapper contentEntityMapper;
	@Autowired
	TestMapper testMapper;
	
	private int listId;
	private int contentId1;
	private int contentCount;
	
	public ContentLogicSharedServiceTest(){
		listId = 1;
		contentId1 = 1;
		contentCount = 2;
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
		testMapper.insert("todo_list","1,1");
		testMapper.insert("todo_content","1,1,'','',1,'2020-9-9'");
		testMapper.insert("todo_content","2,1,'','',1,'2020-9-9'");
	}
	
	@Test
	@Transactional
	//結果を見る
	void deleteContentTest() {
		try {
			contentLogicSharedService.deleteContent(contentId1);
			Assertions.assertFalse(
					contentEntityMapper.selectByPrimaryKey(contentId1).getIsEnabled());
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
	
	@Test
	@Transactional
	void getContentByContentIdTest() {
		try {
			Assertions.assertNotNull(
					contentLogicSharedService.getContentByContentId(contentId1));
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
	
	@Test
	@Transactional
	@DatabaseSetup("/logic/ContentLogicSharedServiceTest.xml")
	void getContentsInListTest() {
		try {
			Assertions.assertEquals(
					contentLogicSharedService.getContentsInList(listId).size(),
					contentCount);
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
	
	@Test
	@Transactional
	//問題なく終わればよし
	void insertTest() {
		ContentEntity entity = new ContentEntity();
		entity.setListId(listId);
		entity.setContentText("テストです。");
		entity.setTitle("テスト");
		
		try {
		contentLogicSharedService.insert(entity);
		Assertions.assertTrue(true);
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
	
	@Test
	@Transactional
	//結果を見る
	void updateContent() {
		ContentEntity entity = new ContentEntity();
		entity.setContentId(contentId1);
		entity.setTitle("変更した");
		
		try {
			contentLogicSharedService.updateContent(entity);
			Assertions.assertEquals(
					contentEntityMapper.selectByPrimaryKey(contentId1).getTitle(),
					entity.getTitle());
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
}