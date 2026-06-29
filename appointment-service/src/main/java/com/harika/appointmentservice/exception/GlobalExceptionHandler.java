package com.harika.appointmentservice.exception;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateResourceException(
	        DuplicateResourceException ex,
	        HttpServletRequest request) {

	    ErrorResponse errorResponse = new ErrorResponse();

	    errorResponse.setTimestamp(LocalDateTime.now());
	    errorResponse.setStatus(HttpStatus.CONFLICT.value());
	    errorResponse.setError(HttpStatus.CONFLICT.getReasonPhrase());
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setPath(request.getRequestURI());

	    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	    
	    
	    
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
	        ResourceNotFoundException ex,
	        HttpServletRequest request) {

	    ErrorResponse errorResponse = new ErrorResponse();

	    errorResponse.setTimestamp(LocalDateTime.now());
	    errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	    errorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setPath(request.getRequestURI());

	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(
	        MethodArgumentNotValidException ex,
	        HttpServletRequest request) {

	    String message = ex.getBindingResult()
	                       .getFieldError()
	                       .getDefaultMessage();

	    ErrorResponse errorResponse = new ErrorResponse();

	    errorResponse.setTimestamp(LocalDateTime.now());
	    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
	    errorResponse.setMessage(message);
	    errorResponse.setPath(request.getRequestURI());

	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(
	        Exception ex,
	        HttpServletRequest request) {

	    ErrorResponse errorResponse = new ErrorResponse();

	    errorResponse.setTimestamp(LocalDateTime.now());
	    errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    errorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
	    errorResponse.setMessage(ex.getMessage());
	    errorResponse.setPath(request.getRequestURI());

	    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	


}
