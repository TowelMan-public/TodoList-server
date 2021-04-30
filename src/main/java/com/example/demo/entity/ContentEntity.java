package com.example.demo.entity;

import java.util.Date;

public class ContentEntity {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column todo_content.content_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private Integer contentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column todo_content.list_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private Integer listId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column todo_content.title
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private String title;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column todo_content.content_text
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private String contentText;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column todo_content.is_enabled
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private Boolean isEnabled;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column todo_content.update_timestamp
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private Date updateTimestamp;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column todo_content.content_id
	 * @return  the value of todo_content.content_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Integer getContentId() {
		return contentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column todo_content.content_id
	 * @param contentId  the value for todo_content.content_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column todo_content.list_id
	 * @return  the value of todo_content.list_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Integer getListId() {
		return listId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column todo_content.list_id
	 * @param listId  the value for todo_content.list_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setListId(Integer listId) {
		this.listId = listId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column todo_content.title
	 * @return  the value of todo_content.title
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column todo_content.title
	 * @param title  the value for todo_content.title
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column todo_content.content_text
	 * @return  the value of todo_content.content_text
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public String getContentText() {
		return contentText;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column todo_content.content_text
	 * @param contentText  the value for todo_content.content_text
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column todo_content.is_enabled
	 * @return  the value of todo_content.is_enabled
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column todo_content.is_enabled
	 * @param isEnabled  the value for todo_content.is_enabled
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column todo_content.update_timestamp
	 * @return  the value of todo_content.update_timestamp
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column todo_content.update_timestamp
	 * @param updateTimestamp  the value for todo_content.update_timestamp
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
}