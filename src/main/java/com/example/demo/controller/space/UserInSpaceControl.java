package com.example.demo.controller.space;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configurer.UrlConfing;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.entity.UserInSpaceEntity;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.Groups;
import com.example.demo.form.space.UserInSpaceForm;
import com.example.demo.service.spaec.UserInSpaceService;

@RequestMapping(UrlConfing.ROOT_URL + "/space/user")
@RestController
public class UserInSpaceControl {
	@Autowired
	UserInSpaceService userInSpaceService;
	
	@PostMapping("delete")
	public void deleteUserInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) UserInSpaceForm form)
			throws NotFoundException, HaveNotAuthorityInSpaceException {
		userInSpaceService.deleteUserInSpace(user.getUserId(),form.getSpaceId(),form.getUsername());
	}
	
	@GetMapping("get")
	public List<UserInSpaceEntity> getUserInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.GetGroup.class) UserInSpaceForm form)
			throws HaveNotAuthorityInSpaceException {
		return userInSpaceService.getUserInSpace(user.getUserId(),form.getSpaceId());
	}
	
	@PostMapping("insert")
	public void insertUserInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.InsertGroup.class) UserInSpaceForm form)
			throws NotFoundException, HaveNotAuthorityInSpaceException {
		userInSpaceService.insertUserInSpace(user.getUserId(),form);
	}
	
	@PostMapping("update")
	public void updateUserAuthortyInSpace(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.UpdateGroup.class) UserInSpaceForm form)
			throws NotFoundException, HaveNotAuthorityInSpaceException {
		userInSpaceService.updateUserAuthortyInSpace(user.getUserId(),form);
	}
}
