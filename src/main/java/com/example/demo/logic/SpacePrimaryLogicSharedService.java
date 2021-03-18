package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.SpacePrimaryEnti;
import com.example.demo.repository.SpacePrimaryEntiMapper;

public class SpacePrimaryLogicSharedService {
	@Autowired
	SpacePrimaryEntiMapper spacePrimaryEntiMapper;

	public SpacePrimaryEnti insertSpacePrimary() {
		SpacePrimaryEnti entity = new SpacePrimaryEnti();
		spacePrimaryEntiMapper.insertSelective(entity);
		return entity;
	}
}
