package com.example.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserInSpaceEntityExample;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.UserAleadyJoinSpaceException;
import com.example.demo.repository.UserInSpaceEntityMapper;

@Component
public class UserInSpaceLogicSharedService {
	@Autowired
	UserInSpaceEntityMapper userInSpaceEntityMapper;
	
	public void eraseUserInSpace(Integer spaceId, Integer userId) {
		userInSpaceEntityMapper.deleteByPrimaryKey(spaceId, userId);
	}

	public List<UserInSpaceEntity> getUserBySpaceId(int spaceId) {
		//SQL作成
		UserInSpaceEntityExample selectDto = new UserInSpaceEntityExample();
		selectDto.or()
			.andSpaceIdEqualTo(spaceId);
		
		return userInSpaceEntityMapper.selectByExample(selectDto);
	}

	public void insertUserInSpace(UserInSpaceEntity userInSpaceEntity) {
		userInSpaceEntityMapper.insertSelective(userInSpaceEntity);
	}

	public void updateuserSelective(UserInSpaceEntity entity) {
		userInSpaceEntityMapper.updateByPrimaryKeySelective(entity);
	}

	public void verificationNotJoinedUserInSpace(int spaceId, int userId) throws UserAleadyJoinSpaceException {
		//SQL作成
		UserInSpaceEntityExample selectDto = new UserInSpaceEntityExample();
		selectDto.or()
			.andSpaceIdEqualTo(spaceId)
			.andUserIdEqualTo(userId);
		
		if(userInSpaceEntityMapper.countByExample(selectDto) != 0)
			throw new UserAleadyJoinSpaceException("UserAleadyJoinSpaceException");
	}
}
