package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UrlConfing;
import com.example.demo.entity.SimpleTodoListEntity;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.form.SimpleTodoForm;
import com.example.demo.service.SimpleTodoService;

@RequestMapping(UrlConfing.ROOT_URL + "/simple/todo")
@RestController
public class SimpleControl {

	@Autowired
	SimpleTodoService service;
	
	@GetMapping("get")
	public List<SimpleTodoListEntity> getSimpleTodoLists(@AuthenticationPrincipal UserDetailsImp user) {
		return service.getSimpleTodoLists(user.getUserId());
	}
	
	@PostMapping("insert")
	public void insertSimpleTodoList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated SimpleTodoForm form) {
		service.insertSimpleTodoList(form,user.getUserId());
	}
}