package com.example.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ContentEntity;
import com.example.demo.entity.ListEntity;
import com.example.demo.repository.ListEntityMapper;

@Component
public class ListLogicSharedService {
	@Autowired
	ListEntityMapper listEntityMapper;

	public void insert(ListEntity entity) {
		listEntityMapper.insert(entity);
	}

	public void deleteList(int listId) {
		ListEntity entity = new ListEntity();
		entity.setListId(listId);
		entity.setIsEnabled(false);
		listEntityMapper.updateByPrimaryKeySelective(entity);
	}

	public void updateListByPrimaryKeySelective(ListEntity entity) {
		listEntityMapper.updateByPrimaryKeySelective(entity);
	}
}