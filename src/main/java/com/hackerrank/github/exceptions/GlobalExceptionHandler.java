package com.hackerrank.github.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle the {@link BadRequestException}
	 * 
	 * @param ex
	 * @param request
	 * @return {@link ResponseEntity} with status code 400
	 */
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> appExceptionHandler(BadRequestException ex, WebRequest request) {
		return handleExceptionInternal(ex, null, null, BAD_REQUEST, request);
	}

	/**
	 * Handle the {@link NotFoundException}
	 * 
	 * @param ex
	 * @param request
	 * @return {@link ResponseEntity} with status code 404
	 */
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> appExceptionHandler(NotFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, null, null, NOT_FOUND, request);
	}
}