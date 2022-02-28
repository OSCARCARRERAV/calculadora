package com.test.calculadora.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotAcceptableExceptionHandler {
	
	@ExceptionHandler(NotAcceptableException.class)
	public ResponseEntity<NotAcceptableErrorDTO> generateExceptionNotFoundException(NotAcceptableException ex) {
		NotAcceptableErrorDTO errorDTO = new NotAcceptableErrorDTO();
		errorDTO.setMessage(ex.getMessage());
	    errorDTO.setStatus(String.valueOf(ex.getStatus().value()));
	    
	    return new ResponseEntity<>(errorDTO, ex.getStatus());
	}
}
