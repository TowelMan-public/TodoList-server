package com.example.demo.service.spaec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CountlistInSpaceEntity;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.TodoListEachUserEntity;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.space.MySpaceListForm;
import com.example.demo.form.space.SpaceListForm;
import com.example.demo.logic.ListEachUserSharedService;
import com.example.demo.logic.SpaceLogicSharedService;
import com.example.demo.utility.DateUtilitySharedService;

@Service
public class MySpaceService {
	@Autowired
	ListEachUserSharedService listEachUserSharedService;
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	DateUtilitySharedService dateUtilitySharedService;
	
	public CountlistInSpaceEntity getCountListInMonth(MySpaceListForm form, int userId){
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInMonth(form.getYear(), form.getMonth());
		
		//処理
		int listCount = listEachUserSharedService.getListCountBetoweenDateByUserId(userId
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
		
		CountlistInSpaceEntity entity=new CountlistInSpaceEntity();
		entity.setCount(listCount);
		return entity;
	}

	public CountlistInSpaceEntity getCountListInWeek(MySpaceListForm form, int userId){
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInWeek(form.getYear(), form.getMonth(),form.getWeekCount());
		
		//処理
		int listCount = listEachUserSharedService.getListCountBetoweenDateByUserId(userId
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
		
		CountlistInSpaceEntity entity=new CountlistInSpaceEntity();
		entity.setCount(listCount);
		return entity;
	}

	public CountlistInSpaceEntity getCountListInDay(MySpaceListForm form, int userId){
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInDay(form.getYear(), form.getMonth(),form.getWeekCount());
		
		//処理
		int listCount = listEachUserSharedService.getListCountBetoweenDateByUserId(userId
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
		
		CountlistInSpaceEntity entity=new CountlistInSpaceEntity();
		entity.setCount(listCount);
		return entity;
	}

	public List<TodoListEachUserEntity> getListInDayInSpace(MySpaceListForm form, int userId){
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInDay(form.getYear(), form.getMonth(),form.getWeekCount());
		
		//処理
		return listEachUserSharedService.getListBetoweenDateByUserId(userId
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
	}

	public List<SpaceEntity> getMySpace(int userId) {
		List<UserInSpaceEntity> spaceIdGathering = spaceLogicSharedService.getSpaceIdEachUser(userId);
		List<SpaceEntity> spaceEntityGathering = new ArrayList<>();

		//spaceの情報を1つずつ取得する
		for(int i = 0;i < spaceIdGathering.size(); i++) {
			spaceEntityGathering.add(
					spaceLogicSharedService.getSpaceBySpaceid(spaceIdGathering.get(i).getSpaceId()));
		}
		
		return spaceEntityGathering;
	}
}
