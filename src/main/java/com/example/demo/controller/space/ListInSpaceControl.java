package com.example.demo.controller.space;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UrlConfing;
import com.example.demo.entity.CountlistInSpaceEntity;
import com.example.demo.entity.TodoListEachUserEntity;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.Groups;
import com.example.demo.form.space.SpaceListForm;
import com.example.demo.service.spaec.ListInSpaceServer;

@RequestMapping(UrlConfing.ROOT_URL + "/space/list")
@RestController
public class ListInSpaceControl {
	
	@Autowired
	ListInSpaceServer listInSpaceServer;
	
	@GetMapping("count/month/get")
	CountlistInSpaceEntity getCountListInMonth(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInMonthGroup.class) SpaceListForm form) 
			throws HaveNotAuthorityInSpaceException {
		return listInSpaceServer.getCountListInMonth(form,user.getUserId());
	}
	
	@GetMapping("count/week/get")
	CountlistInSpaceEntity getCountListInWeek(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInWeekGroup.class) SpaceListForm form) 
			throws HaveNotAuthorityInSpaceException {
		return listInSpaceServer.getCountListInWeek(form,user.getUserId());
	}

	@GetMapping("count/day/get")
	CountlistInSpaceEntity getCountListInDay(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInDayGroup.class) SpaceListForm form) 
			throws HaveNotAuthorityInSpaceException {
		return listInSpaceServer.getCountListInDay(form,user.getUserId());
	}
	
	@GetMapping("day/get")
	List<TodoListEachUserEntity> getListInDayInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ListInDayGroup.class) SpaceListForm form) 
			throws HaveNotAuthorityInSpaceException {
		return listInSpaceServer.getListInDayInSpace(form,user.getUserId());
	}
}
