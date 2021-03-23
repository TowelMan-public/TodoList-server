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
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.Groups;
import com.example.demo.form.space.SpaceForm;
import com.example.demo.service.spaec.SpaceService;

@RequestMapping(UrlConfing.ROOT_URL + "/space")
@RestController
public class SpaceControl {
	@Autowired
	SpaceService spaceService;
	
	@PostMapping("scope/update")
	public void updateScope(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.ScopeUpdateGroup.class) SpaceForm form) throws HaveNotAuthorityInSpaceException {
		spaceService.updateScope(form,user.getUserId());
	}
	
	@PostMapping("delete")
	public void deleteSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) SpaceForm form) throws HaveNotAuthorityInSpaceException {
		spaceService.deleteSpace(form.getSpaceId(),user.getUserId());
	}
	
	@PostMapping("make")
	public void makeSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.MakeGroup.class) SpaceForm form) {
		spaceService.makeSpace(form,user.getUserId());
	}
	
	@PostMapping("secession")
	public void secessionSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.Secession.class) SpaceForm form) throws HaveNotAuthorityInSpaceException {
		spaceService.secessionSpace(user.getUserId(),form.getSpaceId());
	}
	@GetMapping("get")
	public SpaceEntity getSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.GetGroup.class) SpaceForm form) throws HaveNotAuthorityInSpaceException {
		return spaceService.getSpace(user.getUserId(),form.getSpaceId());
	}
}
