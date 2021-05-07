package com.example.demo.service.spaec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CountlistInSpaceEntity;
import com.example.demo.entity.TodoListEachUserEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.space.SpaceListForm;
import com.example.demo.logic.ListEachUserSharedService;
import com.example.demo.logic.SpaceLogicSharedService;
import com.example.demo.utility.DateUtilitySharedService;

@Service
public class ListInSpaceServer {

	@Autowired
	ListEachUserSharedService listEachUserSharedService;
	@Autowired
	SpaceLogicSharedService spaceLogicSharedService;
	@Autowired
	DateUtilitySharedService dateUtilitySharedService;
	
	public CountlistInSpaceEntity getCountListInDay(SpaceListForm form, int userId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(form.getSpaceId(), userId);
		
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInDay(form.getYear(), form.getMonth(),form.getDay());
		
		//処理
		int listCount = listEachUserSharedService.getListCountBetoweenDateBySpaceId(form.getSpaceId()
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
		
		CountlistInSpaceEntity entity=new CountlistInSpaceEntity();
		entity.setCount(listCount);
		entity.setSpaceId(form.getSpaceId());
		return entity;
	}

	public CountlistInSpaceEntity getCountListInMonth(SpaceListForm form, int userId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(form.getSpaceId(), userId);
		
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInMonth(form.getYear(), form.getMonth());
		
		//処理
		int listCount = listEachUserSharedService.getListCountBetoweenDateBySpaceId(form.getSpaceId()
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
		
		CountlistInSpaceEntity entity=new CountlistInSpaceEntity();
		entity.setCount(listCount);
		entity.setSpaceId(form.getSpaceId());
		return entity;
	}

	public CountlistInSpaceEntity getCountListInWeek(SpaceListForm form, int userId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(form.getSpaceId(), userId);
		
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInWeek(form.getYear(), form.getMonth(),form.getWeekCount());
		
		//処理
		int listCount = listEachUserSharedService.getListCountBetoweenDateBySpaceId(form.getSpaceId()
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
		
		CountlistInSpaceEntity entity=new CountlistInSpaceEntity();
		entity.setCount(listCount);
		entity.setSpaceId(form.getSpaceId());
		return entity;
	}

	public List<TodoListEachUserEntity> getListInDayInSpace(SpaceListForm form, int userId) throws HaveNotAuthorityInSpaceException {
		//検証
		spaceLogicSharedService.verificationEnableSelect(form.getSpaceId(), userId);
		
		//データセット
		DateUtilitySharedService.BetoweenDate betoweenDate =
				dateUtilitySharedService.getBetoweenDateInDay(form.getYear(), form.getMonth(),form.getDay());
		
		//処理
		return listEachUserSharedService.getListBetoweenDateBySpaceId(form.getSpaceId()
				,betoweenDate.getStartDate(),betoweenDate.getFinifhDate());
	}
}
