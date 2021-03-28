package com.example.demo.exception;

public class IsSimpleSpaceException extends Exception{
	//warningを回避するための宣言
	private static final long serialVersionUID = 1L; 
	
	public IsSimpleSpaceException(String message){
		super(message);
	}
}