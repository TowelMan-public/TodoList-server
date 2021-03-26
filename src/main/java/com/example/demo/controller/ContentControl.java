package com.example.demo.controller;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UrlConfing;
import com.example.demo.entity.ContentEntity;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.ContentForm;
import com.example.demo.form.Groups;
import com.example.demo.service.ContentService;

@RequestMapping(UrlConfing.ROOT_URL + "/content")
@RestController
public class ContentControl {
	@Autowired
	ContentService contentService;
	
	@PostMapping("delete")
	public void deleteContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) ContentForm form) throws NotFoundException, HaveNotAuthorityInSpaceException{
		contentService.deleteContent(form.getContentId(),user.getUserId());
	}
	
	@GetMapping("get")
	public ContentEntity getContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.GetGroup.class) ContentForm form) throws NotFoundException, HaveNotAuthorityInSpaceException{
		return contentService.getContent(form.getContentId(),user.getUserId());
	}
	
	@PostMapping("insert")
	public void insertContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.InsertGroup.class) ContentForm form) throws NotFoundException, HaveNotAuthorityInSpaceException {
		contentService.insertContent(form,user.getUserId());
	}
	
	@PostMapping("update")
	public void updateContent(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.UpdateGroup.class) ContentForm form) throws NotFoundException, HaveNotAuthorityInSpaceException{
		contentService.updateContent(form,user.getUserId());
	}
}
