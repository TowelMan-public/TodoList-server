package com.example.demo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ContentEntity;
import com.example.demo.repository.ContentEntityMapper;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@SpringBootTest
//@Transactional
class ContentLogicSharedServiceTest {
	@Autowired
	ContentLogicSharedService contentLogicSharedService;
	@Autowired
	ContentEntityMapper contentEntityMapper;
	
	private int listId;
	private int contentId1;
	
	public ContentLogicSharedServiceTest(){
		listId = 1;
		contentId1 = 1;
	}
	
	@Test
	@Transactional
	@DatabaseSetup("/logic/ContentLogicSharedServiceTest.xml")
	//結果を見る
	void deleteContentTest() {
		try {
			contentLogicSharedService.deleteContent(contentId1);
			Assertions.assertEquals(
					contentEntityMapper.selectByPrimaryKey(contentId1).getIsEnabled(),
					false);
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
	
	@Test
	@Transactional
	@DatabaseSetup("/logic/ContentLogicSharedServiceTest.xml")
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
					2);
		}
		catch(Exception e) {
			Assertions.assertTrue(false);
		}
	}
	
	@Test
	@Transactional
	@DatabaseSetup("/logic/ContentLogicSharedServiceTest.xml")
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
	@DatabaseSetup("/logic/ContentLogicSharedServiceTest.xml")
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