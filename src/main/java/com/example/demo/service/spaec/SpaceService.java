package com.example.demo.service.spaec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configurer.UserAuthorityInSpaceConstant;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.exception.IsSimpleSpaceException;
import com.example.demo.form.space.SpaceForm;
import com.example.demo.logic.SpaceLogicSharedService;
import com.example.demo.logic.SpacePrimaryLogicSharedService;
import com.example.demo.logic.UserInSpaceLogicSharedService;

@Service
public class SpaceService {
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	SpacePrimaryLogicSharedService spacePrimaryLogicSharedService;
	@Autowired
	UserInSpaceLogicSharedService userInSpaceLogicSharedService;
	
	@Transactional(rollbackForClassName = "Exception")
	public void deleteSpace(Integer spaceId, Integer userId) throws HaveNotAuthorityInSpaceException, IsSimpleSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableAll(spaceId,userId);
		spaceLogicSharedService.verificationIsnotSimpleSpace(spaceId);
		
		//処理
		spaceLogicSharedService.deleteSpace(spaceId);
	}

	public SpaceEntity getSpace(Integer userId, Integer spaceId) throws HaveNotAuthorityInSpaceException, IsSimpleSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(spaceId, userId);
		spaceLogicSharedService.verificationIsnotSimpleSpace(spaceId);
		
		//処理
		return spaceLogicSharedService.getSpaceBySpaceid(spaceId);
	}

	@Transactional(rollbackForClassName = "Exception")
	public void makeSpace(SpaceForm form, Integer userId) {
		//データセット
		SpaceEntity entity = new SpaceEntity();
		entity.setSpaceName(form.getSpaceName());
		entity.setScopeId(form.getScopeId());
		
		//処理
		entity.setSpaceId(
				spacePrimaryLogicSharedService.insertSpacePrimary().getSpaceId());
		spaceLogicSharedService.insertSpace(entity);
		userInSpaceLogicSharedService.insertUserInSpace(
				new UserInSpaceEntity(entity.getSpaceId(),userId,UserAuthorityInSpaceConstant.SUPER));
	}

	@Transactional(rollbackForClassName = "Exception")
	public void secessionSpace(Integer userId, Integer spaceId) throws HaveNotAuthorityInSpaceException, IsSimpleSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(spaceId, userId);
		spaceLogicSharedService.verificationIsnotSimpleSpace(spaceId);
		
		//処理
		userInSpaceLogicSharedService.eraseUserInSpace(spaceId,userId);
	}

	@Transactional(rollbackForClassName = "Exception")
	public void updateScope(SpaceForm form, Integer userId) throws HaveNotAuthorityInSpaceException, IsSimpleSpaceException {
		//データセット
		SpaceEntity entity = new SpaceEntity();
		entity.setSpaceId(form.getSpaceId());
		entity.setScopeId(form.getScopeId());
		
		//検証
		spaceLogicSharedService.verificationEnableAll(form.getSpaceId(),userId);
		spaceLogicSharedService.verificationIsnotSimpleSpace(form.getSpaceId());
		
		//処理
		spaceLogicSharedService.updateSelective(entity);
	}
	
}
