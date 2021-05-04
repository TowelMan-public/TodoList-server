package com.example.demo.controller;

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
import com.example.demo.entity.ContentEntity;
import com.example.demo.entity.ListEntity;
import com.example.demo.entity.UserDetailsImp;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.form.Groups;
import com.example.demo.form.ListForm;
import com.example.demo.service.ListService;

@RequestMapping(UrlConfing.ROOT_URL + "/list")
@RestController
public class ListControl {
	
	@Autowired
	ListService service;
	
	@PostMapping("delete")
	public void deleteList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.DeleteGroup.class) ListForm form) throws NotFoundException, HaveNotAuthorityInSpaceException {
		service.deleteList(form.getListId(),user.getUserId());
	}
	
	@GetMapping("get")
	public ListEntity getList(@AuthenticationPrincipal UserDetailsImp user, @Validated(Groups.GetGroup.class) ListForm form) throws HaveNotAuthorityInSpaceException, NotFoundException{
		return service.getList(form.getListId(),user.getUserId());
	}
	
	@GetMapping("get/content")
	public List<ContentEntity> getContentsInList(@AuthenticationPrincipal UserDetailsImp user, @Validated(Groups.ContentGetGroup.class) ListForm form) throws HaveNotAuthorityInSpaceException, NotFoundException{
		return service.getContentsInList(form.getListId(),user.getUserId());
	}
	
	@PostMapping("insert")
	public void insertList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.InsertGroup.class) ListForm form) throws HaveNotAuthorityInSpaceException {
		service.insertList(form,user.getUserId());
	}
	
	@PostMapping("update")
	public void updateList(@AuthenticationPrincipal UserDetailsImp user, @RequestBody @Validated(Groups.UpdateGroup.class) ListForm form) throws NotFoundException, HaveNotAuthorityInSpaceException{
		service.updateList(form,user.getUserId());
	}
}
