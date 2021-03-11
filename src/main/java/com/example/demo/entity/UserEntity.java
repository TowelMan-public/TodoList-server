package com.example.demo.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserEntity implements UserDetails {
	//シリアライズ
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private Integer userId;
	private boolean isEnabled;
	
	//アカウントの有効期限の状態を判定
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//アカウントのロック状態を判定
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//資格情報の有効期限の状態を判定
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//権限(これは関係ない)
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("USER");
	}
}