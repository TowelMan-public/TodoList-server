package com.example.demo.controller.space;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UrlConfing;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.form.Groups;
import com.example.demo.form.space.UserInSpaceForm;

@RequestMapping(UrlConfing.ROOT_URL + "/space/user")
@RestController
public class UserInSpaceControl {

	@PostMapping("insert")
	void insertUser(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.InsertGroup.class) UserInSpaceForm form) {
		//TODO
	}
	
	@PostMapping("delete")
	void deleteUser(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) UserInSpaceForm form) {
		//TODO
	}
	
	@PostMapping("update")
	void updateUserAuthorty(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.UpdateGroup.class) UserInSpaceForm form) {
		//TODO
	}
}
