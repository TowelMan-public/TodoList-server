package com.example.demo.service.spaec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configurer.UserAuthorityInSpaceConstant;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
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
	
	public void deleteSpace(Integer spaceId, Integer userId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableAll(spaceId,userId);
		
		//処理
		spaceLogicSharedService.deleteSpace(spaceId);
	}

	public SpaceEntity getSpace(Integer userId, Integer spaceId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(spaceId, userId);
		
		//処理
		return spaceLogicSharedService.getSpaceBySpaceid(spaceId);
	}

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

	public void secessionSpace(Integer userId, Integer spaceId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(spaceId, userId);
		
		//処理
		userInSpaceLogicSharedService.eraseUserInSpace(spaceId,userId);
	}

	public void updateScope(SpaceForm form, Integer userId) throws HaveNotAuthorityInSpaceException {
		//データセット
		SpaceEntity entity = new SpaceEntity();
		entity.setSpaceId(form.getSpaceId());
		entity.setScopeId(form.getScopeId());
		
		//検証
		spaceLogicSharedService.verificationEnableAll(form.getSpaceId(),userId);
		
		//処理
		spaceLogicSharedService.updateSelective(entity);
	}
	
}
