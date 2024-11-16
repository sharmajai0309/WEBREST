package com.Backend.jai.ExceptionHandler;

import java.util.Date; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Backend.jai.Exception.ErrorResponse;
import com.Backend.jai.Exception.StudentNotfoundException;

@RestControllerAdvice
public class CustomHandler {

	
	/* 1.Handling the Exception
	 * 2.Exception Type : StudentNotfoundException
	 * 3.ReturnType     : ResponseEntity
	 *
	 * 
	 * 
	 * 
	 */
	
	@ExceptionHandler(value = StudentNotfoundException.class)
	public ResponseEntity<?>showcustomHndlerMsg(StudentNotfoundException  snfe){
		
		ErrorResponse er =  new ErrorResponse();
		
		return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		
	
}
}
