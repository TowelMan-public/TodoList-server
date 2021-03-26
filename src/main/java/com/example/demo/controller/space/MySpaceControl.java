package com.example.demo.controller.space;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configurer.UrlConfing;
import com.example.demo.entity.CountlistInSpaceEntity;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.TodoListEachUserEntity;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.form.Groups;
import com.example.demo.form.space.MySpaceListForm;
import com.example.demo.service.spaec.MySpaceService;

@RequestMapping(UrlConfing.ROOT_URL + "/space/me")
@RestController
public class MySpaceControl {
	
	@Autowired
	MySpaceService mySpaceService;
	
	@GetMapping("count/day/get")
	public CountlistInSpaceEntity getCountMyListInDay(@AuthenticationPrincipal UserDetailsImp user,@RequestBody @Validated(Groups.CountInDayGroup.class) MySpaceListForm form) {
		return mySpaceService.getCountListInDay(form, user.getUserId());
	}
	
	@GetMapping("count/month/get")
	public CountlistInSpaceEntity getCountMyListInMonth(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInMonthGroup.class) MySpaceListForm form) {
		return mySpaceService.getCountListInMonth(form, user.getUserId());
	}

	@GetMapping("count/week/get")
	public CountlistInSpaceEntity getCountMyListInWeek(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInWeekGroup.class) MySpaceListForm form) {
		return mySpaceService.getCountListInWeek(form, user.getUserId());
	}
	
	@GetMapping("day/get")
	public List<TodoListEachUserEntity> getListInDayInMySpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ListInDayGroup.class) MySpaceListForm form) {
		return mySpaceService.getListInDayInSpace(form, user.getUserId());
	}
	
	@GetMapping("get")
	public List<SpaceEntity> getMySpace(@AuthenticationPrincipal UserDetailsImp user) {
		return mySpaceService.getMySpace(user.getUserId());
	}
}
