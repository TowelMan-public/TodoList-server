package com.example.demo.logic;

import java.util.Date;

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
		entity.setUpdateTimestamp(new Date());//タイムスタンプ
		entity.setIsEnabled(false);
		listEntityMapper.updateByPrimaryKeySelective(entity);
	}

	public void insert(ListEntity entity) {
		listEntityMapper.insertSelective(entity);
	}

	public void updateListByPrimaryKeySelective(ListEntity entity) {
		entity.setUpdateTimestamp(new Date());//タイムスタンプ
		listEntityMapper.updateByPrimaryKeySelective(entity);
	}

	public ListEntity selectList(Integer listId) {
		return listEntityMapper.selectByPrimaryKey(listId);
	}
}
