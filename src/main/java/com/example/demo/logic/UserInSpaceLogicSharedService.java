package com.example.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserInSpaceEntityExample;
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

	public void updateuserSelective(UserInSpaceEntity entity) {
		userInSpaceEntityMapper.updateByPrimaryKeySelective(entity);
	}

	public List<UserInSpaceEntity> getUserBySpaceId(int spaceId) {
		//SQL作成
		UserInSpaceEntityExample selectDto = new UserInSpaceEntityExample();
		selectDto.or()
			.andSpaceIdEqualTo(spaceId);
		
		return userInSpaceEntityMapper.selectByExample(selectDto);
	}

}
