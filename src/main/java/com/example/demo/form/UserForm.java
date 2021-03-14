package com.example.demo.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

import com.example.demo.RegexpMessage;

import lombok.Data;

@Data
public class UserForm {
	@NotBlank(message=RegexpMessage.EMPTY,groups= {Groups.NameGroup.class})
	private String newUsername;
	
	@NotBlank(message=RegexpMessage.EMPTY,groups= {Groups.PasswordGroup.class})
	private String newPassword;
	@NotBlank(message=RegexpMessage.EMPTY,groups= {Groups.PasswordGroup.class})
	private String oneMorePassword;
	
	@AssertTrue(message = "2つのパスワードが合致しません。もう一度お確かめください",groups= {Groups.PasswordGroup.class})
	public boolean isNotMatchesPassword() {
		return (newUsername == null || oneMorePassword == null) || (newUsername.equals(oneMorePassword));
	}
}
