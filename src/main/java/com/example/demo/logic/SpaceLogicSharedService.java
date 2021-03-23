package com.example.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.ScopeConstant;
import com.example.demo.UserAuthorityInSpaceConstant;
import com.example.demo.dto.UserInSpaceEntityExample;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.repository.SpaceEntityMapper;
import com.example.demo.repository.UserInSpaceEntityMapper;

@Component
public class SpaceLogicSharedService {
	@Autowired
	SpaceEntityMapper spaceEntityMapper;
	@Autowired
	UserInSpaceEntityMapper userInSpaceEntityMapper;

	public void verificationEnableAll(int spaceId, int userId) throws HaveNotAuthorityInSpaceException {
		//データ取得
		UserInSpaceEntity userInSpaceEntity = userInSpaceEntityMapper.selectByPrimaryKey(spaceId, userId);
		SpaceEntity spaceEntity = spaceEntityMapper.selectByPrimaryKey(spaceId);
		
		//検証（ホワイトﾁｪｯｸ式　このブロック内で関数が終われば正当）
		if(userInSpaceEntity != null) {
			if(spaceEntity.getScopeId() == ScopeConstant.PRIVATE) {
				if(userInSpaceEntity.getAuthorityId() == UserAuthorityInSpaceConstant.SUPER)
					return;
			}
			else {
				if(userInSpaceEntity.getAuthorityId() == UserAuthorityInSpaceConstant.SUPER ||
						userInSpaceEntity.getAuthorityId() == UserAuthorityInSpaceConstant.MASTER )
					return;
			}
		}
		
		//例外
		throw new HaveNotAuthorityInSpaceException("userId is not able insert , update and delete in spaceId");
	}
	
	public void verificationEnableSelect(int spaceId, int userId) throws HaveNotAuthorityInSpaceException {
		//データ取得
		UserInSpaceEntity userInSpaceEntity = userInSpaceEntityMapper.selectByPrimaryKey(spaceId, userId);
		
		//検証（ホワイトﾁｪｯｸ式　このブロック内で関数が終われば正当）
		if(userInSpaceEntity != null) 
			return;
		
		//例外
		throw new HaveNotAuthorityInSpaceException("userId is not able select in spaceId");
	}

	public List<UserInSpaceEntity> getSpaceIdEachUser(int userId) {
		UserInSpaceEntityExample selectDto = new UserInSpaceEntityExample();
		selectDto.or()
			.andUserIdEqualTo(userId);
		
		return userInSpaceEntityMapper.selectByExample(selectDto);
	}

	public SpaceEntity getSpaceBySpaceid(int spaceId) {
		return spaceEntityMapper.selectByPrimaryKey(spaceId);
	}

	public void updateSelective(SpaceEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void deleteSpace(int spaceId, int userId) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void insertSpace(SpaceEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}