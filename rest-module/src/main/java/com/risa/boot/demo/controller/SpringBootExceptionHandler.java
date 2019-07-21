package com.risa.boot.demo.controller;

import com.risa.boot.demo.exception.ExceptionWrapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class SpringBootExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionWrapper> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(new ExceptionWrapper(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ExceptionWrapper> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex){
        return new ResponseEntity<>(new ExceptionWrapper(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
