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
import com.example.demo.form.ListForm;

@RequestMapping(UrlConfing.ROOT_URL + "/list")
@RestController
public class ListControl {
	
	@PostMapping("insert")
	void insertList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.InsertGroup.class) ListForm form) {
		//TODO
	}
	
	@PostMapping("delete")
	void deleteList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) ListForm form) {
		//TODO
	}
	
	@PostMapping("update")
	void updateList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.UpdateGroup.class) ListForm form) {
		//TODO
	}
	
	@GetMapping("get")
	void getContentsInList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ContentGetGroup.class) ListForm form) {
		//TODO
	}
}
