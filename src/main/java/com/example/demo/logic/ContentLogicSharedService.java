package com.example.demo.logic;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ContentEntityExample;
import com.example.demo.entity.ContentEntity;
import com.example.demo.repository.ContentEntityMapper;

@Component
public class ContentLogicSharedService {
	@Autowired
	ContentEntityMapper contentEntityMapper;

	public void deleteContent(Integer contentId) {
		//データセット
		ContentEntity entity = new ContentEntity();
		entity.setContentId(contentId);
		entity.setUpdateTimestamp(new Date());//タイムスタンプ
		entity.setIsEnabled(false);
		
		//処理
		contentEntityMapper.updateByPrimaryKeySelective(entity);
	}

	public ContentEntity getContentByContentId(Integer contentId) throws NotFoundException {
		ContentEntity entity = contentEntityMapper.selectByPrimaryKey(contentId);
		//例外
		if(entity == null)
			throw new NotFoundException("NotFound contentId");
		
		return entity;
	}

	public List<ContentEntity> getContentsInList(int listId) {
		//SQL作成
		ContentEntityExample selectDto = new ContentEntityExample();
		selectDto.or()
				.andListIdEqualTo(listId);
		
		//処理
		return contentEntityMapper.selectByExample(selectDto);
	}

	public void insert(ContentEntity entity) {
		contentEntityMapper.insertSelective(entity);
	}

	public void updateContent(ContentEntity entity) {
		entity.setUpdateTimestamp(new Date());//タイムスタンプ
		contentEntityMapper.updateByPrimaryKeySelective(entity);
	}
}