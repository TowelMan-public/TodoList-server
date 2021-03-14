package com.example.demo.exception;

public class AlreadyUsedException extends Exception{
	//warningを回避するための宣言
	private static final long serialVersionUID = 1L; 
	
	public AlreadyUsedException(String message){
		super(message);
	}
}