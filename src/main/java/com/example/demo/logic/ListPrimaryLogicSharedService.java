package com.example.demo.logic;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ListPrimaryEntity;
import com.example.demo.repository.ListPrimaryEntityMapper;

@Component
public class ListPrimaryLogicSharedService {
	@Autowired
	ListPrimaryEntityMapper listPrimaryEntityMapper;
	
	public int insertListPrimary(int spaceId) {
		//追加するデータのセット
		ListPrimaryEntity entity = new ListPrimaryEntity();
		entity.setSpaceId(spaceId);
		entity.setSpaceId(null);//自動採番の値を使用
		
		//処理
		listPrimaryEntityMapper.insertSelective(entity);
		
		//自動採番された主キーの取得
		return entity.getListId();
	}

	public ListPrimaryEntity getListPrimary(int listId) throws NotFoundException{
		ListPrimaryEntity entity = listPrimaryEntityMapper.selectByPrimaryKey(listId);
		if(entity == null || entity.getSpaceId() == null)
			throw new NotFoundException("listid is not found");
		return entity;
	}
}
