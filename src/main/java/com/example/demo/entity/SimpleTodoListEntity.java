package com.example.demo.entity;

import java.util.Date;

public class SimpleTodoListEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column simple_todo_list.user_id
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column simple_todo_list.list_id
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    private Integer listId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column simple_todo_list.list_name
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    private String listName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column simple_todo_list.list_date
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    private Date listDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column simple_todo_list.user_id
     *
     * @return the value of simple_todo_list.user_id
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column simple_todo_list.user_id
     *
     * @param userId the value for simple_todo_list.user_id
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column simple_todo_list.list_id
     *
     * @return the value of simple_todo_list.list_id
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public Integer getListId() {
        return listId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column simple_todo_list.list_id
     *
     * @param listId the value for simple_todo_list.list_id
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public void setListId(Integer listId) {
        this.listId = listId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column simple_todo_list.list_name
     *
     * @return the value of simple_todo_list.list_name
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public String getListName() {
        return listName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column simple_todo_list.list_name
     *
     * @param listName the value for simple_todo_list.list_name
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public void setListName(String listName) {
        this.listName = listName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column simple_todo_list.list_date
     *
     * @return the value of simple_todo_list.list_date
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public Date getListDate() {
        return listDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column simple_todo_list.list_date
     *
     * @param listDate the value for simple_todo_list.list_date
     *
     * @mbg.generated Fri Apr 30 22:14:58 JST 2021
     */
    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }
}