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
import com.example.demo.form.SimpleTodoForm;

@RequestMapping(UrlConfing.ROOT_URL + "/simple/todo")
@RestController
public class SimpleControl {

	@PostMapping("insert")
	void insertSimpleTodoList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated SimpleTodoForm form) {
		//TODO
	}
	
	@GetMapping("get")
	void GetSimpleTodoLists(@AuthenticationPrincipal UserDetailsImp user) {
		//TODO
	}
}
