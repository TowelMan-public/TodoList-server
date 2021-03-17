package com.example.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.SimpleTodoListEntityExample;
import com.example.demo.entity.SimpleTodoListEntity;
import com.example.demo.repository.SimpleTodoListEntityMapper;

@Component
public class SimpleTodoLogicSharedService {
	@Autowired
	private SimpleTodoListEntityMapper mapper;

	public void insert(SimpleTodoListEntity entity) {
		mapper.insertSelective(entity);
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
		return mapper.selectByExample(selectDto);
	}

	public int getSimpleSpaceId(int userId) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
}
