package com.example.demo.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.entity.UserDetailsImp;
import com.example.demo.provider.JWTProvider;

@Component
public class AuthenticationSuccessHandlerImp implements AuthenticationSuccessHandler {
	@Autowired
	JWTProvider jwtProvider;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		// すでにレスポンスで情報を返した場合は何もしない
        if (response.isCommitted()) {
            return;
        }
        // ログインに成功したユーザ情報を取得する
        UserDetailsImp user = (UserDetailsImp) auth.getPrincipal();
        // Headerにトークンを作成して載せる
        response.setHeader("X-AUTH-TOKEN", jwtProvider.createToken(user));
        // HTTP Statusは200 OK
        response.setStatus(HttpStatus.OK.value());
	}

}
