package com.example.demo.exception;

public class SpaceIsnotPublicException extends Exception{
	//warningを回避するための宣言
	private static final long serialVersionUID = 1L;
	
	public SpaceIsnotPublicException(String message){
		super(message);
	}
}