package com.example.demo.controller.space;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UrlConfing;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.form.Groups;
import com.example.demo.form.space.SpaceListForm;

@RequestMapping(UrlConfing.ROOT_URL + "/space/list")
@RestController
public class ListInSpaceControl {
	
	@GetMapping("count/month/get")
	void getCountListInMonth(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInMonthGroup.class) SpaceListForm fomr) {
		//TODO
	}
	
	@GetMapping("count/week/get")
	void getCountListInWeek(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInWeekGroup.class) SpaceListForm fomr) {
		//TODO
	}

	@GetMapping("count/day/get")
	void getCountListInDay(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInDayGroup.class) SpaceListForm fomr) {
		//TODO
	}
	
	@GetMapping("day/get")
	void getListInDayInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ListInDayGroup.class) SpaceListForm fomr) {
		//TODO
	}
}
