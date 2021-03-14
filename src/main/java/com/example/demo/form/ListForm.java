package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.RegexpMessage;

import lombok.Data;

@Data
public class ListForm {
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.UpdateGroup.class,Groups.DeleteGroup.class,Groups.ContentGetGroup.class})
	private Integer listId;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.UpdateGroup.class,Groups.InsertGroup.class})
	private String listName;
	@NotNull(groups = {Groups.UpdateGroup.class,Groups.InsertGroup.class})
	@DateTimeFormat(pattern ="yyyy/m/d")
	private Date listDate;
	@NotNull(groups = {Groups.UpdateGroup.class,Groups.InsertGroup.class})
	@DateTimeFormat(pattern ="H:m")
	private Date listTime;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.InsertGroup.class})
	private Integer spaceId;
}
