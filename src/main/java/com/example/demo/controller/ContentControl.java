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
import com.example.demo.form.ContentForm;
import com.example.demo.form.Groups;

@RequestMapping(UrlConfing.ROOT_URL + "/content")
@RestController
public class ContentControl {
	
	@PostMapping("insert")
	void insertContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.InsertGroup.class) ContentForm form) {
		//TODO
	}
	
	@PostMapping("delete")
	void deleteContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) ContentForm form) {
		//TODO
	}
	
	@PostMapping("update")
	void updateContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.UpdateGroup.class) ContentForm form) {
		//TODO
	}
	
	@GetMapping("get")
	void getContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.GetGroup.class) ContentForm form) {
		//TODO
	}
}
