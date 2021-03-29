package com.example.demo.repository;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EraseMapper {
	void eraseUnenabledUser();
	void eraseUnenabledSpace(Date beforDate);
	void eraseUnenabledList(Date beforDate);
	void eraseUnenabledContent(Date beforDate);
}
