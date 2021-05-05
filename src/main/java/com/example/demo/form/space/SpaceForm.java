package com.example.demo.form.space;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.configurer.RegexpMessage;
import com.example.demo.form.Groups;

import lombok.Data;

@Data
public class SpaceForm {
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.ScopeUpdateGroup.class,Groups.DeleteGroup.class,Groups.Secession.class,Groups.GetGroup.class})
	private Integer spaceId;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups = {Groups.ScopeUpdateGroup.class,Groups.MakeGroup.class})
	private String spaceName;
	
	@Max(value=3, message=RegexpMessage.SCOPE,groups = {Groups.MakeGroup.class})
	@Min(value=1, message=RegexpMessage.SCOPE,groups = {Groups.MakeGroup.class})
	private Integer scopeId;
}
