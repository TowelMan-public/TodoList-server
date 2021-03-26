package com.example.demo.service.spaec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configurer.UserAuthorityInSpaceConstant;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.SpaceIsnotPublicException;
import com.example.demo.exception.UserAleadyJoinSpaceException;
import com.example.demo.logic.SpaceLogicSharedService;
import com.example.demo.logic.UserInSpaceLogicSharedService;

@Service
public class PublicSpaceService {
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	UserInSpaceLogicSharedService userInSpaceLogicSharedService;
	
	public List<SpaceEntity> getPublicSpace(int userId) {
		return spaceLogicSharedService.getPublicSpace(userId);
	}

	public void joinSpace(int spaceId, int userId) throws SpaceIsnotPublicException, UserAleadyJoinSpaceException {
		//検証
		spaceLogicSharedService.verificationIsPublicScope(spaceId);
		userInSpaceLogicSharedService.verificationNotJoinedUserInSpace(spaceId,userId);
		
		//データセット
		UserInSpaceEntity entity = new UserInSpaceEntity();
		entity.setUserId(userId);
		entity.setSpaceId(spaceId);
		entity.setAuthorityId(UserAuthorityInSpaceConstant.USER);
		
		//処理
		userInSpaceLogicSharedService.insertUserInSpace(entity);
	}
	
}
