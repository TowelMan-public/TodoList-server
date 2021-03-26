package com.example.demo.form.space;

import javax.validation.constraints.NotBlank;

import com.example.demo.configurer.RegexpMessage;

import lombok.Data;

@Data
public class PublicSpaceForm {
	@NotBlank(message=RegexpMessage.EMPTY)
	private Integer spaceId;
}
