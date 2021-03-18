package com.example.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.ScopeConstant;
import com.example.demo.UserAuthorityInSpaceConstant;
import com.example.demo.dto.SimpleTodoListEntityExample;
import com.example.demo.entity.SimpleTodoListEntity;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.repository.SimpleTodoListEntityMapper;
import com.example.demo.repository.SpaceEntityMapper;
import com.example.demo.repository.UserInSpaceEntityMapper;

@Component
public class SimpleTodoLogicSharedService {
	@Autowired
	SimpleTodoListEntityMapper simpleTodoListEntityMapper;
	@Autowired
	SpaceEntityMapper spaceEntityMapper;
	@Autowired
	UserInSpaceEntityMapper userInSpaceEntityMapper;

	public void insert(SimpleTodoListEntity entity) {
		simpleTodoListEntityMapper.insertSelective(entity);
	}

	public List<SimpleTodoListEntity> getSimpleTodoLists(int userId) {
		//SQL作成
		SimpleTodoListEntityExample selectDto = new SimpleTodoListEntityExample();
		selectDto
			.or()
			.andUserIdEqualTo(userId);
		selectDto
			.setOrderByClause("list_date");
		
		//処理
		return simpleTodoListEntityMapper.selectByExample(selectDto);
	}

	public void createNewSimpleTodoListSpace(int spaceId, int userId) {
		//スペースをシンプルToDo用に作成
		SpaceEntity spaceEntity = new SpaceEntity();
		spaceEntity.setSpaceName("");
		spaceEntity.setIsSimple(true);
		spaceEntity.setScopeId(ScopeConstant.PRIVATE);
		spaceEntity.setSpaceId(spaceId);
		spaceEntityMapper.insertSelective(spaceEntity);
		
		//作成したToDoスペースにユーザーを作成者として登録
		UserInSpaceEntity userInSpaceEntity = new UserInSpaceEntity();
		userInSpaceEntity.setAuthorityId(UserAuthorityInSpaceConstant.SUPER);
		userInSpaceEntity.setSpaceId(spaceId);
		userInSpaceEntity.setUserId(userId);
		userInSpaceEntityMapper.insert(userInSpaceEntity);
	}

	public int getSimpleSpaceId(int userId) {
		//SQL作成
		SimpleTodoListEntityExample selectDto = new SimpleTodoListEntityExample();
		selectDto.or()
			.andUserIdEqualTo(userId);
		
		return simpleTodoListEntityMapper.selectByExample(selectDto)
				.get(0).getSpaceId();
	}
}
