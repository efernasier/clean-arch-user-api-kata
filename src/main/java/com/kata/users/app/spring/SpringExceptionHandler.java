package com.kata.users.app.spring;

import com.kata.users.adapter.controller.model.ErrorDTO;
import com.kata.users.usecase.exception.ValidationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpringExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public HttpEntity<ErrorDTO> handleValidationException(ValidationException e){
        ErrorDTO error = new ErrorDTO("ValidationException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
