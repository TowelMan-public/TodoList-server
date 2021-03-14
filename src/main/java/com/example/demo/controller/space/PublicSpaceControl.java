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
import com.example.demo.form.space.PublicSpaceForm;

@RequestMapping(UrlConfing.ROOT_URL + "/space/public")
@RestController
public class PublicSpaceControl {
	
	@GetMapping("get")
	void getPublicSpace(@AuthenticationPrincipal UserDetailsImp user) {
		//TODO
	}
	
	@PostMapping("join")
	void joinSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated PublicSpaceForm form) {
		//TODO
	}
}
