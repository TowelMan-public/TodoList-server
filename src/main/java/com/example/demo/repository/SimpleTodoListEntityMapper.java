package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.SimpleTodoListEntityExample;
import com.example.demo.entity.SimpleTodoListEntity;

@Mapper
public interface SimpleTodoListEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_todo_list
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    long countByExample(SimpleTodoListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_todo_list
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int deleteByExample(SimpleTodoListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_todo_list
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int insert(SimpleTodoListEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_todo_list
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int insertSelective(SimpleTodoListEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_todo_list
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    List<SimpleTodoListEntity> selectByExample(SimpleTodoListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_todo_list
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int updateByExample(@Param("record") SimpleTodoListEntity record, @Param("example") SimpleTodoListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_todo_list
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int updateByExampleSelective(@Param("record") SimpleTodoListEntity record, @Param("example") SimpleTodoListEntityExample example);
}