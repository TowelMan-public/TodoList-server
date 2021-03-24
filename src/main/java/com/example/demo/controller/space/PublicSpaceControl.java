package com.example.demo.controller.space;

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
import com.example.demo.entity.SpaceEntity;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.exception.SpaceIsnotPublicException;
import com.example.demo.exception.UserAleadyJoinSpaceException;
import com.example.demo.form.space.PublicSpaceForm;
import com.example.demo.service.spaec.PublicSpaceService;

@RequestMapping(UrlConfing.ROOT_URL + "/space/public")
@RestController
public class PublicSpaceControl {
	@Autowired
	PublicSpaceService publicSpaceService;
	
	@GetMapping("get")
	public List<SpaceEntity> getPublicSpace(@AuthenticationPrincipal UserDetailsImp user) {
		return publicSpaceService.getPublicSpace(user.getUserId());
	}
	
	@PostMapping("join")
	public void joinSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated PublicSpaceForm form)
			throws SpaceIsnotPublicException, UserAleadyJoinSpaceException {
		publicSpaceService.joinSpace(form.getSpaceId(),user.getUserId());
	}
}
