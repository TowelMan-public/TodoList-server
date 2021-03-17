package com.example.demo.controller;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UrlConfing;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AlreadyUsedException;
import com.example.demo.form.Groups;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;

@RequestMapping(UrlConfing.ROOT_URL + "/user")
@RestController
public class UserControl {
	@Autowired
	UserService	service;

	@PostMapping("delete")
	public void deleteUser(@AuthenticationPrincipal UserDetailsImp user) throws NotFoundException{
		service.deleteUser(user.getUserId(),user.getUsername());
	}
	
	@GetMapping("get")
	public UserEntity getUser(@AuthenticationPrincipal UserDetailsImp user) {
		return service.getUser(user);
	}
	
	@PostMapping("username/update")
	public void updateUsernaem(@AuthenticationPrincipal UserDetailsImp user,@RequestBody @Validated(Groups.NameGroup.class) UserForm form)
			throws NotFoundException,AlreadyUsedException{
		service.updateUsername(user.getUserId(),user.getUsername(),form.getNewUsername());
	}
	
	@PostMapping("password/update") 
	public void updatePassword(@AuthenticationPrincipal UserDetailsImp user,@RequestBody @Validated(Groups.PasswordGroup.class) UserForm form) 
			throws NotFoundException{
		service.updatePassword(user.getUserId(),user.getUsername(),form.getNewPassword());
	}
	
	@PostMapping("insert")
	public void insertUser(@RequestBody @Validated(Groups.InsertGroup.class) UserForm form) throws AlreadyUsedException {
		service.insertUser(form);
	}
}
