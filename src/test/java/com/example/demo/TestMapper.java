package com.example.demo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {
	@Insert("INSERT INTO ${tableName} VALUES( ${values} )")
	void insert(@Param("tableName") String tableName, @Param("values") String values);
	
	@Delete("DELETE FROM ${tableName}")
	void deleteAll(String tableName);
}
