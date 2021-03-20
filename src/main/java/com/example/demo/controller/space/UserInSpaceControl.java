package com.example.demo.controller.space;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
	void insertUserInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.InsertGroup.class) UserInSpaceForm form) {
		//TODO
	}
	
	@PostMapping("delete")
	void deleteUserInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) UserInSpaceForm form) {
		//TODO
	}
	
	@PostMapping("update")
	void updateUserAuthortyInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.UpdateGroup.class) UserInSpaceForm form) {
		//TODO
	}
	
	@GetMapping("get")
	void getUserInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.GetGroup.class) UserInSpaceForm form) {
		
	}
}
