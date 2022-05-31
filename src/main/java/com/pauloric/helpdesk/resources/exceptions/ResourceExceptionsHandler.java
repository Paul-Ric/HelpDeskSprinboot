package com.pauloric.helpdesk.resources.exceptions;

import java.time.LocalDate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pauloric.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.pauloric.helpdesk.services.exceptions.ObjectnotFoundException;

@ControllerAdvice
public class ResourceExceptionsHandler {
	
	@ExceptionHandler(ObjectnotFoundException.class)
	private ResponseEntity<StandardError> objectnotFoundExceptions(ObjectnotFoundException ex,
			HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(),"Object Not Found", ex.getMessage(),request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	private ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
			HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(),"Violacão de dados", ex.getMessage(),request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException ex,
			HttpServletRequest request){
		ValidationError errors= new ValidationError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Erro na validação dos campos" , ex.getMessage(),request.getRequestURI() );
		
		for(FieldError x: ex.getBindingResult().getFieldErrors()) {
			errors.addErrors(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
