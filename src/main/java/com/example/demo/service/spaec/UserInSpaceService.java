package com.example.demo.service.spaec;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.space.UserInSpaceForm;
import com.example.demo.logic.SpaceLogicSharedService;
import com.example.demo.logic.UserInSpaceLogicSharedService;
import com.example.demo.logic.UserLogicSharedService;

@Service
public class UserInSpaceService {
	@Autowired
	UserLogicSharedService userLogicSharedService;
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	UserInSpaceLogicSharedService userInSpaceLogicSharedService;
	
	@Transactional(rollbackForClassName = "Exception")
	public void deleteUserInSpace(int userId, int spaceId, String targetUsername) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		verification(spaceId, userId);
		
		//処理
		userInSpaceLogicSharedService.eraseUserInSpace(spaceId, 
				getUserIdByUsername(targetUsername));
	}

	//ユーザー名からユーザーIdを取得する
	private int getUserIdByUsername(String username) throws NotFoundException {
		userLogicSharedService.verificationExistsUsername(username);
		return userLogicSharedService.getUserByUsername(username).getUserId();
	}

	public List<UserInSpaceEntity> getUserInSpace(int userId, int spaceId) throws HaveNotAuthorityInSpaceException {
		//検証
		verification(spaceId, userId);
		
		//処理
		return userInSpaceLogicSharedService.getUserBySpaceId(spaceId);
	}

	@Transactional(rollbackForClassName = "Exception")
	public void insertUserInSpace(int userId, UserInSpaceForm form) throws NotFoundException, HaveNotAuthorityInSpaceException{
		//検証
		verification(form.getSpaceId(), userId);
		
		//データセット
		UserInSpaceEntity entity = new UserInSpaceEntity();
		entity.setAuthorityId(form.getAuthortyId());
		entity.setSpaceId(form.getSpaceId());
		entity.setUserId(
				getUserIdByUsername(form.getUsername()));
		
		//処理
		userInSpaceLogicSharedService.insertUserInSpace(entity);
	}
	
	@Transactional(rollbackForClassName = "Exception")
	public void updateUserAuthortyInSpace(int userId, UserInSpaceForm form) throws NotFoundException, HaveNotAuthorityInSpaceException {
		//検証
		verification(form.getSpaceId(), userId);
		
		//データセット
		UserInSpaceEntity entity = new UserInSpaceEntity();
		entity.setAuthorityId(form.getAuthortyId());
		entity.setSpaceId(form.getSpaceId());
		entity.setUserId(
				getUserIdByUsername(form.getUsername()));
		
		//処理
		userInSpaceLogicSharedService.updateuserSelective(entity);
	}
	
	//このクラスで提供する機能全てで行う検証
	private void verification(int spaceId, int userId) throws HaveNotAuthorityInSpaceException {
		spaceLogicSharedService.verificationEnableAll(spaceId, userId);
	}
}
