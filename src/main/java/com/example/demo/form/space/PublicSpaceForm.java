package com.example.demo.form.space;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.configurer.RegexpMessage;

import lombok.Data;

@Data
public class PublicSpaceForm {
	@NotNull(message=RegexpMessage.EMPTY)
	private Integer spaceId;
}
