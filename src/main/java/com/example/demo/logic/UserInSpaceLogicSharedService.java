package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.repository.UserInSpaceEntityMapper;

@Component
public class UserInSpaceLogicSharedService {
	@Autowired
	UserInSpaceEntityMapper userInSpaceEntityMapper;
	
	public void insertUserInSpace(UserInSpaceEntity userInSpaceEntity) {
		userInSpaceEntityMapper.insertSelective(userInSpaceEntity);
	}

	public void eraseUserInSpace(Integer spaceId, Integer userId) {
		userInSpaceEntityMapper.deleteByPrimaryKey(spaceId, userId);
	}

}
