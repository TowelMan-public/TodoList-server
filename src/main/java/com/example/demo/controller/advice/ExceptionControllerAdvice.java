package com.example.demo.controller.advice;


import javax.validation.ConstraintViolationException;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.AlreadyUsedException;
import com.example.demo.exception.HaveNotAuthorityInSpaceException;
import com.example.demo.exception.SpaceIsnotPublicException;
import com.example.demo.exception.UserAleadyJoinSpaceException;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(AlreadyUsedException.class)
	public ResponseEntity<Object> alreadyUsedExceptionHandle(AlreadyUsedException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "AlreadyUsedException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolationExceptionHandle(ConstraintViolationException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "ConstraintViolationException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
	
	@ExceptionHandler(HaveNotAuthorityInSpaceException.class)
	public ResponseEntity<Object> haveNotAuthorityInSpaceExceptionHandle(HaveNotAuthorityInSpaceException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "HaveNotAuthorityInSpaceException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "MethodArgumentNotValidException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> notFoundExceptionHandle(NotFoundException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "NotFoundException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
	
	@ExceptionHandler(SpaceIsnotPublicException.class)
	public ResponseEntity<Object> spaceIsnotPublicExceptionHandle(SpaceIsnotPublicException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "SpaceIsnotPublicException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public ResponseEntity<Object> typeMismatchExceptionHandle(TypeMismatchException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "TypeMismatchException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
	
	@ExceptionHandler(UserAleadyJoinSpaceException.class)
	public ResponseEntity<Object> userAleadyJoinSpaceException(UserAleadyJoinSpaceException e, WebRequest request) {
		return super.handleExceptionInternal(e,
                "UserAleadyJoinSpaceException",
                null,
                HttpStatus.BAD_REQUEST,
                request);
	}
}
