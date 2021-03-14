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
import com.example.demo.form.space.MySpaceListForm;

@RequestMapping(UrlConfing.ROOT_URL + "/space/me")
@RestController
public class MySpaceControl {
	
	@GetMapping("count/month/get")
	void getCountMyListInMonth(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInMonthGroup.class) MySpaceListForm form) {
		//TODO
	}
	
	@GetMapping("count/week/get")
	void getCountMyListInWeek(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.CountInWeekGroup.class) MySpaceListForm form) {
		//TODO
	}

	@GetMapping("count/day/get")
	void getCountMyListInDay(@AuthenticationPrincipal UserDetailsImp user,@RequestBody @Validated(Groups.CountInDayGroup.class) MySpaceListForm form) {
		//TODO
	}
	
	@GetMapping("day/get")
	void getListInDayInMySpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ListInDayGroup.class) MySpaceListForm form) {
		//TODO
	}
	
	@GetMapping("get")
	void getMySpace(@AuthenticationPrincipal UserDetailsImp user) {
		//TODO
	}
}
