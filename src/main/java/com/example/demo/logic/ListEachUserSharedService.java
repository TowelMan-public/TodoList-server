package com.example.demo.logic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.TodoListEachUserEntityExample;
import com.example.demo.dto.TodoListEachUserEntityExample.Criteria;
import com.example.demo.entity.TodoListEachUserEntity;
import com.example.demo.repository.TodoListEachUserEntityMapper;

@Component
public class ListEachUserSharedService {
	@Autowired
	TodoListEachUserEntityMapper todoListEachUserEntityMapper;

	public List<TodoListEachUserEntity> getListBetoweenDateBySpaceId(int spaceId, Date startDate, Date finishDate) {
		return todoListEachUserEntityMapper.selectByExample(
				makeSqlForGetListBySpaceId(spaceId,startDate,finishDate));
	}

	public int getListCountBetoweenDateBySpaceId(int spaceId, Date startDate, Date finishDate) {
		return (int)(todoListEachUserEntityMapper.countByExample(
				makeSqlForGetListBySpaceId(spaceId,startDate,finishDate)));
	}

	private TodoListEachUserEntityExample makeSqlForGetListBySpaceId(int spaceId, Date startDate, Date finishDate) {
		TodoListEachUserEntityExample selectDto = new TodoListEachUserEntityExample();
		selectDto.or(makeSqlBetoweenDate(startDate, finishDate));
		selectDto.or().andSpaceIdEqualTo(spaceId);
		
		return selectDto;
	}
	
	private Criteria makeSqlBetoweenDate(Date startDate, Date finishDate) {
		return new TodoListEachUserEntityExample().or()
				.andListDateBetween(startDate, finishDate);
	}

	public int getListCountBetoweenDateByUserId(int userId, Date startDate, Date finifhDate) {
		return (int)(todoListEachUserEntityMapper.countByExample(
				makeSqlForGetListByUserId(userId,startDate,finifhDate)));
	}

	public List<TodoListEachUserEntity> getListBetoweenDateByUserId(int userId, Date startDate, Date finifhDate) {
		return todoListEachUserEntityMapper.selectByExample(
				makeSqlForGetListByUserId(userId,startDate,finifhDate));
	}
	
	private TodoListEachUserEntityExample makeSqlForGetListByUserId(int userId, Date startDate, Date finishDate) {
		TodoListEachUserEntityExample selectDto = new TodoListEachUserEntityExample();
		selectDto.or(makeSqlBetoweenDate(startDate, finishDate));
		selectDto.or().andUserIdEqualTo(userId);
		
		return selectDto;
	}
}
