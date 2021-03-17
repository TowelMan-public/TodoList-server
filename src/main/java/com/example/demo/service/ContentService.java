package com.example.demo.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContentEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.ContentForm;
import com.example.demo.logic.ContentLogicSharedService;
import com.example.demo.logic.ListPrimaryLogicSharedService;
import com.example.demo.logic.SpaceLogicSharedService;

@Service
public class ContentService {
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	ListPrimaryLogicSharedService listPrimaryLogicSharedService;
	@Autowired
	ContentLogicSharedService contentLogicSharedService;

	public void insertContent(ContentForm form, int userId) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		int spaceId = listPrimaryLogicSharedService.getListPrimary(form.getListId())
				.getSpaceId();
		spaceLogicSharedService.verificationEnableAll(spaceId, userId);
		
		//データセット
		ContentEntity entity = new ContentEntity();
		entity.setContentText(form.getContentText());
		entity.setListId(form.getListId());
		entity.setTitle(form.getTitle());
		
		//処理
		contentLogicSharedService.insert(entity);
	}

	public void deleteContent(Integer contentId, int userId) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		int listId = contentLogicSharedService.getContentByContentId(contentId)
				.getListId();
		int spaceId = listPrimaryLogicSharedService.getListPrimary(listId)
				.getSpaceId();
		spaceLogicSharedService.verificationEnableAll(spaceId, userId);
		
		//処理
		contentLogicSharedService.deleteContent(contentId);
	}

	public void updateContent(ContentForm form, int userId) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		int listId = contentLogicSharedService.getContentByContentId(form.getContentId())
				.getListId();
		int spaceId = listPrimaryLogicSharedService.getListPrimary(listId)
				.getSpaceId();
		spaceLogicSharedService.verificationEnableAll(spaceId, userId);
		
		//データのセット
		ContentEntity entity = new ContentEntity();
		entity.setContentId(form.getContentId());
		entity.setContentText(form.getContentText());
		entity.setTitle(form.getTitle());
		
		//処理
		contentLogicSharedService.updateContent(entity);
	}

	public ContentEntity getContent(Integer contentId, int userId) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//処理
		ContentEntity entity = contentLogicSharedService.getContentByContentId(contentId);
		
		//検証
		int listId = entity.getListId();
		int spaceId = listPrimaryLogicSharedService.getListPrimary(listId)
				.getSpaceId();
		spaceLogicSharedService.verificationEnableSelect(spaceId, userId);
		
		//処理
		return entity;
	}
}
