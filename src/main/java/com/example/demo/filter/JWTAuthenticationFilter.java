package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.example.demo.provider.JWTProvider;

@Component
public class JWTAuthenticationFilter extends GenericFilterBean {

    // トークンを検証するためのProvider
	@Autowired
    private JWTProvider provider;

    // ログインに対するフィルタリングを行う
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) 
    		throws IOException, ServletException {
    	
        final String token = provider.resolveToken((HttpServletRequest) request);
        
        //TODO デバッグ用コード　デバッグが終わったら消すこと
        String url =  ((HttpServletRequest)request).getRequestURI();
        
        if (token != null && provider.validateToken(token)) {
            final Authentication auth = provider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        
        filterChain.doFilter(request, response);
    }
}