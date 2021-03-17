package com.example.demo.exception;

public class HaveNotAuthorityInSpaceException extends Exception{
	//warningを回避するための宣言
	private static final long serialVersionUID = 1L; 
	
	public HaveNotAuthorityInSpaceException(String message){
		super(message);
	}
}
