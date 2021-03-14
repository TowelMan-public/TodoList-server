package com.example.demo.controller;

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
import com.example.demo.form.UserForm;

@RequestMapping(UrlConfing.ROOT_URL + "/user")
@RestController
public class UserControl {
	
	@PostMapping("delete")
	void deleteUser(@AuthenticationPrincipal UserDetailsImp user) {
		//TODO
	}
	
	@GetMapping("get")
	void getUser(@AuthenticationPrincipal UserDetailsImp user) {
		user.getUsername();
	}
	
	@PostMapping("username/update")
	void updateUsernaem(@AuthenticationPrincipal UserDetailsImp user,@RequestBody @Validated(Groups.NameGroup.class) UserForm form) {
		//TODO
	}
	
	@PostMapping("password/update") 
	void updatePassword(@AuthenticationPrincipal UserDetailsImp user,@RequestBody @Validated(Groups.PasswordGroup.class) UserForm form) {
		//TODO
	}
}
