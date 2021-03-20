package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.SpacePrimaryEntity;
import com.example.demo.repository.SpacePrimaryEntityMapper;

public class SpacePrimaryLogicSharedService {
	@Autowired
	SpacePrimaryEntityMapper spacePrimaryEntityMapper;

	public SpacePrimaryEntity insertSpacePrimary() {
		SpacePrimaryEntity entity = new SpacePrimaryEntity();
		spacePrimaryEntityMapper.insertSelective(entity);
		return entity;
	}
}
