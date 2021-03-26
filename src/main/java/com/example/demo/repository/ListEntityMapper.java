package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.ListEntityExample;
import com.example.demo.entity.ListEntity;

@Mapper
public interface ListEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    long countByExample(ListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int deleteByExample(ListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int deleteByPrimaryKey(Integer listId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int insert(ListEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int insertSelective(ListEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    List<ListEntity> selectByExample(ListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    ListEntity selectByPrimaryKey(Integer listId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int updateByExample(@Param("record") ListEntity record, @Param("example") ListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int updateByExampleSelective(@Param("record") ListEntity record, @Param("example") ListEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int updateByPrimaryKey(ListEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo_list_details
     *
     * @mbg.generated Sun Mar 14 11:52:35 JST 2021
     */
    int updateByPrimaryKeySelective(ListEntity record);
}