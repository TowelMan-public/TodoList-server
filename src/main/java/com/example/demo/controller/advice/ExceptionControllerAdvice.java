package com.example.demo.controller.advice;


import javax.validation.ConstraintViolationException;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo.exception.AlreadyUsedException;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.exception.SpaceIsnotPublicException;
import com.example.demo.exception.UserAleadyJoinSpaceException;

import lombok.Value;

@RestControllerAdvice
public class ExceptionControllerAdvice{

	@ExceptionHandler(AlreadyUsedException.class)
	@ResponseStatus(HttpStatus.NOT_EXTENDED)
	public ErrorResponse alreadyUsedExceptionHandle(AlreadyUsedException e) {
		return new ErrorResponse("AlreadyUsedException",e.getMessage());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse constraintViolationExceptionHandle(ConstraintViolationException e) {
		return new ErrorResponse("ConstraintViolationException",e.getMessage());
	}
	
	@ExceptionHandler(HaveNotAuthorityInSpaceException.class)
	@ResponseStatus(HttpStatus.NOT_EXTENDED)
	public ErrorResponse haveNotAuthorityInSpaceExceptionHandle(HaveNotAuthorityInSpaceException e) {
		return new ErrorResponse("HaveNotAuthorityInSpaceException",e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e) {
		return new ErrorResponse("MethodArgumentNotValidException",e.getMessage());
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse notFoundExceptionHandle(NotFoundException e) {
		return new ErrorResponse("NotFoundException",e.getMessage());
	}
	
	@ExceptionHandler(SpaceIsnotPublicException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse spaceIsnotPublicExceptionHandle(SpaceIsnotPublicException e) {
		return new ErrorResponse("SpaceIsnotPublicException",e.getMessage());
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse typeMismatchExceptionHandle(TypeMismatchException e) {
		return new ErrorResponse("TypeMismatchException",e.getMessage());
	}
	
	@ExceptionHandler(UserAleadyJoinSpaceException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse userAleadyJoinSpaceException(UserAleadyJoinSpaceException e) {
		return new ErrorResponse("UserAleadyJoinSpaceException",e.getMessage());
	}
	
	@Value
	public class ErrorResponse {
	    String errorCode;
	    String message;
	}
}
