package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ContentEntity;
import com.example.demo.entity.ListEntity;
import com.example.demo.entity.ListPrimaryEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.ListForm;
import com.example.demo.logic.ContentLogicSharedService;
import com.example.demo.logic.ListLogicSharedService;
import com.example.demo.logic.ListPrimaryLogicSharedService;
import com.example.demo.logic.SpaceLogicSharedService;
import com.example.demo.utility.DateUtilitySharedService;

@Service
public class ListService {
	@Autowired
	ListLogicSharedService listLogicSharedService;
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	ListPrimaryLogicSharedService listPrimaryLogicSharedService;
	@Autowired
	DateUtilitySharedService utilitySharedService;
	@Autowired
	ContentLogicSharedService contentLogicSharedService;
	
	@Transactional(rollbackForClassName = "Exception")
	public void deleteList(Integer listId, int userId) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		ListPrimaryEntity primaryEntity = listPrimaryLogicSharedService.getListPrimary(listId);
		spaceLogicSharedService.verificationEnableAll(primaryEntity.getSpaceId(),userId);
		
		//処理
		listLogicSharedService.deleteList(listId);
	}
	
	public List<ContentEntity> getContentsInList(int listId,int userId) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		ListPrimaryEntity primaryEntity = listPrimaryLogicSharedService.getListPrimary(listId);
		spaceLogicSharedService.verificationEnableSelect(primaryEntity.getSpaceId(),userId);
		
		//処理
		return contentLogicSharedService.getContentsInList(listId);
	}
	
	@Transactional(rollbackForClassName = "Exception")
	public void insertList(ListForm form, int userId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableAll(form.getSpaceId(),userId);
		
		//セット
		ListEntity entity = new ListEntity();
		entity.setIsAlarm(false);//TODO アラーム機能は未実装
		entity.setListDate(utilitySharedService.mergeDate(form.getListDate(), form.getListTime()));
		entity.setListName(form.getListName());
		
		//処理
		entity.setListId(listPrimaryLogicSharedService.insertListPrimary(form.getSpaceId()));
		listLogicSharedService.insert(entity);
	}
	
	@Transactional(rollbackForClassName = "Exception")
	public void updateList(ListForm form, int userId) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		ListPrimaryEntity primaryEntity = listPrimaryLogicSharedService.getListPrimary(form.getListId());
		spaceLogicSharedService.verificationEnableAll(primaryEntity.getSpaceId(),userId);
		
		//セット
		ListEntity entity = new ListEntity();
		entity.setListName(form.getListName());
		entity.setListDate(utilitySharedService.mergeDate(form.getListDate(), form.getListTime()));
		
		//処理
		listLogicSharedService.updateListByPrimaryKeySelective(entity);
	}
}
