package com.example.demo.form.space;

import javax.validation.constraints.NotBlank;

import com.example.demo.RegexpMessage;
import com.example.demo.form.Groups;

import lombok.Data;

@Data
public class SpaceForm {
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.ScopeUpdateGroup.class,Groups.DeleteGroup.class,Groups.Secession.class,Groups.GetGroup.class})
	private Integer spaceId;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.ScopeUpdateGroup.class,Groups.MakeGroup.class})
	private Integer scopeId;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.MakeGroup.class})
	private String spaceName;
}
