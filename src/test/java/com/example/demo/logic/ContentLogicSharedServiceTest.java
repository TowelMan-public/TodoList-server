package com.example.demo.logic;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.ContentEntity;

public class ContentLogicSharedServiceTest {
	@Autowired
	ContentLogicSharedService contentLogicSharedService;
	
	//void deleteContent(Integer contentId)
	//ContentEntity getContentByContentId(Integer contentId) throws NotFoundException 
	//List<ContentEntity> getContentsInList(int listId)
	//void insert(ContentEntity entity)
	//void updateContent(ContentEntity entity)
}
