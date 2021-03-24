package com.example.demo.exception;

public class UserAleadyJoinSpaceException extends Exception{
	//warningを回避するための宣言
	private static final long serialVersionUID = 1L;
	
	public UserAleadyJoinSpaceException(String message){
		super(message);
	}
}
