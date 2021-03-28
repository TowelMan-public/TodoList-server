package com.example.demo.logic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.configurer.ScopeConstant;
import com.example.demo.configurer.UserAuthorityInSpaceConstant;
import com.example.demo.dto.SpaceEntityExample;
import com.example.demo.dto.UserInSpaceEntityExample;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.exception.IsSimpleSpaceException;
import com.example.demo.exception.SpaceIsnotPublicException;
import com.example.demo.repository.PublicSpaceMapper;
import com.example.demo.repository.SpaceEntityMapper;
import com.example.demo.repository.UserInSpaceEntityMapper;

@Component
public class SpaceLogicSharedService {
	@Autowired
	SpaceEntityMapper spaceEntityMapper;
	@Autowired
	UserInSpaceEntityMapper userInSpaceEntityMapper;
	@Autowired
	PublicSpaceMapper publicSpaceMapper;

	public void deleteSpace(int spaceId) {
		//データ作成
		SpaceEntity entity = new SpaceEntity();
		entity.setIsEnable(false);
		entity.setUpdateTimestamp(new Date());//タイムスタンプ
		entity.setSpaceId(spaceId);
		
		//実行
		spaceEntityMapper.updateByPrimaryKeySelective(entity);
	}
	
	public List<SpaceEntity> getPublicSpace(int userId) {
		return publicSpaceMapper.getPublicSpace(userId);
	}

	public SpaceEntity getSpaceBySpaceid(int spaceId) {
		return spaceEntityMapper.selectByPrimaryKey(spaceId);
	}

	public List<UserInSpaceEntity> getSpaceIdEachUser(int userId) {
		UserInSpaceEntityExample selectDto = new UserInSpaceEntityExample();
		selectDto.or()
			.andUserIdEqualTo(userId);
		
		return userInSpaceEntityMapper.selectByExample(selectDto);
	}

	public void insertSpace(SpaceEntity entity) {
		spaceEntityMapper.insertSelective(entity);
	}

	public void updateSelective(SpaceEntity entity) {
		entity.setUpdateTimestamp(new Date());//タイムスタンプ
		spaceEntityMapper.updateByPrimaryKeySelective(entity);
	}

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
		throw new HaveNotAuthorityInSpaceException("HaveNotAuthorityInSpaceException all");
	}

	public void verificationEnableSelect(int spaceId, int userId) throws HaveNotAuthorityInSpaceException {
		//データ取得
		UserInSpaceEntity userInSpaceEntity = userInSpaceEntityMapper.selectByPrimaryKey(spaceId, userId);
		
		//検証（ホワイトﾁｪｯｸ式　このブロック内で関数が終われば正当）
		if(userInSpaceEntity != null) 
			return;
		
		//例外
		throw new HaveNotAuthorityInSpaceException("HaveNotAuthorityInSpaceException select");
	}

	public void verificationIsPublicScope(int spaceId) throws SpaceIsnotPublicException {
		//SQL作成
		SpaceEntityExample selectDto = new SpaceEntityExample();
		selectDto.or()
			.andSpaceIdEqualTo(spaceId)
			.andScopeIdEqualTo(ScopeConstant.PUBLIC);
		
		//処理
		if(spaceEntityMapper.countByExample(selectDto) == 0) 
			throw new SpaceIsnotPublicException("SpaceIsnotPublicException");
	}

	public void verificationIsnotSimpleSpace(Integer spaceId) throws IsSimpleSpaceException {
		//SQL作成
		SpaceEntityExample selectDto = new SpaceEntityExample();
		selectDto.or()
			.andSpaceIdEqualTo(spaceId)
			.andIsSimpleEqualTo(true);
		
		//処理
		if(spaceEntityMapper.countByExample(selectDto) == 1) 
			throw new IsSimpleSpaceException("space is simple");
	}
}