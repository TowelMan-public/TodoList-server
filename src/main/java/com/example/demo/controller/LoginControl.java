package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configurer.UrlConfing;
import com.example.demo.exception.LoginException;
import com.example.demo.form.Groups;
import com.example.demo.form.UserForm;
import com.example.demo.provider.JWTProvider;

@RequestMapping(UrlConfing.ROOT_URL)
@RestController
public class LoginControl {
	@Autowired
	JWTProvider provider;
	
	//ログイン・認証トークンを返す
	@PostMapping("login")
	public String insertUser(@RequestBody @Validated(Groups.LoginGroup.class) UserForm form) throws LoginException {
		return provider.loginAndGetToken(form.getUsername(), form.getPassword());
	}
}
