package com.example.demo.form;

import javax.validation.constraints.NotBlank;

import com.example.demo.configurer.RegexpMessage;

import lombok.Data;

@Data
public class ContentForm {
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.UpdateGroup.class,Groups.DeleteGroup.class,Groups.GetGroup.class})
	private Integer contentId;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.InsertGroup.class,Groups.UpdateGroup.class})
	private String title;
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.InsertGroup.class,Groups.UpdateGroup.class})
	private String contentText;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.InsertGroup.class})
	private Integer listId;
}
