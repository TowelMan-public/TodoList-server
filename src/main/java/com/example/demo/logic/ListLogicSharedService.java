package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ListEntity;
import com.example.demo.repository.ListEntityMapper;

@Component
public class ListLogicSharedService {
	@Autowired
	ListEntityMapper listEntityMapper;

	public void deleteList(int listId) {
		ListEntity entity = new ListEntity();
		entity.setListId(listId);
		entity.setIsEnabled(false);
		listEntityMapper.updateByPrimaryKeySelective(entity);
	}

	public void insert(ListEntity entity) {
		listEntityMapper.insert(entity);
	}

	public void updateListByPrimaryKeySelective(ListEntity entity) {
		listEntityMapper.updateByPrimaryKeySelective(entity);
	}
}
