package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.UserDetailsImp;

@Mapper
public interface  LoginUserMapper {
	UserDetailsImp findByUsername(String username);
}
