package com.vti.demorail79app.exception;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            var message = "sorry! Invalid form";
            var errors = new HashMap<String, String>();
        for (var error : ex.getFieldErrors()) {
            var key = error.getField();
            var value = error.getDefaultMessage();
            errors.put(key, value);
        }

        var response = new ErrorResponse(message, errors);
        return new ResponseEntity<>(response, headers, status);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception){
        var message = "sorry! Invalid form";
        var errors = new HashMap<String, String>();
        for (var constraint : exception.getConstraintViolations()) {
            var key = constraint.getPropertyPath().toString();
            var value = constraint.getMessage();
            errors.put(key, value);
        }
        var response = new ErrorResponse(message, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
