package com.example.demo.controller.space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UrlConfing;
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.form.Groups;
import com.example.demo.form.space.SpaceForm;
import com.example.demo.service.spaec.SpaceService;

@RequestMapping(UrlConfing.ROOT_URL + "/space")
@RestController
public class SpaceControl {
	@Autowired
	SpaceService spaceService;
	
	@PostMapping("scope/update")
	void updateScope(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ScopeUpdateGroup.class) SpaceForm form) {
		spaceService.updateScope(form,user.getUserId());
	}
	
	@PostMapping("delete")
	void deleteSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) SpaceForm form) {
		spaceService.deleteSpace(form.getSpaceId(),user.getUserId());
	}
	
	@PostMapping("make")
	void makeSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.MakeGroup.class) SpaceForm form) {
		spaceService.makeSpace(form,user.getUserId());
	}
	
	@PostMapping("secession")
	void secessionSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.Secession.class) SpaceForm form) {
		spaceService.secessionSpace(user.getUserId(),form.getSpaceId());
	}
	@GetMapping("get")
	SpaceEntity getSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.GetGroup.class) SpaceForm form) {
		return spaceService.getSpace(user.getUserId(),form.getSpaceId());
	}
}
