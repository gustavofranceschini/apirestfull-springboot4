package br.com.apispringboot.apispringboot.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.apispringboot.apispringboot.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StantardError> objNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StantardError err = new StantardError(
				System.currentTimeMillis()
				,status.value()
				, "Não encontrado"
				, e.getMessage()
				, request.getRequestURI());
		return ResponseEntity.status(status).body(err);		
	}
}