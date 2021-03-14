package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.RegexpMessage;

import lombok.Data;

@Data
public class SimpleTodoForm {
	@NotBlank(message=RegexpMessage.EMPTY)
	private String listName;
	@DateTimeFormat(pattern ="yyyy/m/d")
	private Date listDate;
	@DateTimeFormat(pattern ="H:m")
	private Date listTime;
}
