package com.example.vehicle_service_booking.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBookingNotFound(
            BookingNotFoundException exception) {

        Map<String, String> error = new HashMap<>();

        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        
        
    }
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationErrors(
	            MethodArgumentNotValidException exception) {

	        Map<String, String> errors = new HashMap<>();

	        for (var fieldError : exception.getBindingResult().getFieldErrors()) {
	            errors.put(
	                fieldError.getField(),
	                fieldError.getDefaultMessage()
	            );
	        }

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
}
