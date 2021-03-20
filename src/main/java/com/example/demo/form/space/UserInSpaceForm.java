package com.example.demo.form.space;

import javax.validation.constraints.NotBlank;

import com.example.demo.RegexpMessage;
import com.example.demo.form.Groups;

import lombok.Data;

@Data
public class UserInSpaceForm {
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.InsertGroup.class,Groups.DeleteGroup.class,Groups.UpdateGroup.class,Groups.GetGroup.class})
	private Integer spaceId;
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.InsertGroup.class,Groups.DeleteGroup.class,Groups.UpdateGroup.class})
	private String username;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.InsertGroup.class,Groups.UpdateGroup.class})
	private Integer authortyId;
}
