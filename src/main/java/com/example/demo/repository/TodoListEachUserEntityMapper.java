package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.TodoListEachUserEntityExample;
import com.example.demo.entity.TodoListEachUserEntity;

@Mapper
public interface TodoListEachUserEntityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table todo_list_eacch_user
	 * @mbg.generated  Tue Mar 16 20:39:48 JST 2021
	 */
	long countByExample(TodoListEachUserEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table todo_list_eacch_user
	 * @mbg.generated  Tue Mar 16 20:39:48 JST 2021
	 */
	int deleteByExample(TodoListEachUserEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table todo_list_eacch_user
	 * @mbg.generated  Tue Mar 16 20:39:48 JST 2021
	 */
	int insert(TodoListEachUserEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table todo_list_eacch_user
	 * @mbg.generated  Tue Mar 16 20:39:48 JST 2021
	 */
	int insertSelective(TodoListEachUserEntity record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table todo_list_eacch_user
	 * @mbg.generated  Tue Mar 16 20:39:48 JST 2021
	 */
	List<TodoListEachUserEntity> selectByExample(TodoListEachUserEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table todo_list_eacch_user
	 * @mbg.generated  Tue Mar 16 20:39:48 JST 2021
	 */
	int updateByExample(@Param("record") TodoListEachUserEntity record,
			@Param("example") TodoListEachUserEntityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table todo_list_eacch_user
	 * @mbg.generated  Tue Mar 16 20:39:48 JST 2021
	 */
	int updateByExampleSelective(@Param("record") TodoListEachUserEntity record,
			@Param("example") TodoListEachUserEntityExample example);
}