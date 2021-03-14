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
import com.example.demo.form.space.SpaceForm;

@RequestMapping(UrlConfing.ROOT_URL + "/space")
@RestController
public class SpaceControl {
	
	@PostMapping("scope/update")
	void updateScope(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ScopeUpdateGroup.class) SpaceForm form) {
		//TODO
	}
	
	@PostMapping("delete")
	void deleteSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) SpaceForm form) {
		//TODO
	}
	
	@PostMapping("make")
	void makeSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.MakeGroup.class) SpaceForm form) {
		//TODO
	}
	
	@PostMapping("secession")
	void secessionSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.Secession.class) SpaceForm form) {
		//TODO
	}
}
