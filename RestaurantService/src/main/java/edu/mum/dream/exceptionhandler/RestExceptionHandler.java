package edu.mum.dream.exceptionhandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

    	ErrorResponse error = new ErrorResponse();
		error.setStatus(status.value());
		error.setTimeStamp(new Date());
		List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		error.setMessage(errors);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
  	
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	 
	 ErrorResponse error = new ErrorResponse();
		error.setStatus( HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimeStamp(new Date());
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		error.setMessage(errors);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
 }
 
    
  

}
