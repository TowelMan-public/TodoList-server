package com.example.demo.entity;

public class UserInSpaceEntity {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column have_user_list.space_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private Integer spaceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column have_user_list.user_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private Integer userId;
	
	private String username;
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column have_user_list.authority_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	private Integer authorityId;

	
	public UserInSpaceEntity() {}
    
    public UserInSpaceEntity(Integer spaceId, Integer userId, Integer authorityId) {
		this.spaceId = spaceId;
		this.userId = userId;
		this.authorityId = authorityId;
	}
	
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column have_user_list.space_id
	 * @return  the value of have_user_list.space_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Integer getSpaceId() {
		return spaceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column have_user_list.space_id
	 * @param spaceId  the value for have_user_list.space_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setSpaceId(Integer spaceId) {
		this.spaceId = spaceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column have_user_list.user_id
	 * @return  the value of have_user_list.user_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column have_user_list.user_id
	 * @param userId  the value for have_user_list.user_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column have_user_list.authority_id
	 * @return  the value of have_user_list.authority_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Integer getAuthorityId() {
		return authorityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column have_user_list.authority_id
	 * @param authorityId  the value for have_user_list.authority_id
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}