package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.UserEntity;

@Mapper
public interface  UserMapper {
	UserEntity findByUsername(String username);
}
