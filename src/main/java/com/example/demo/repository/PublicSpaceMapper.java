package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.SpaceEntity;

@Mapper
public interface PublicSpaceMapper {

	List<SpaceEntity> getPublicSpace(int userId);

}