package com.andres.curso.springboot.error.springbooterror.web.controllers;

import com.andres.curso.springboot.error.springbooterror.web.exceptions.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero(Exception exception) {


        return  ResponseEntity.internalServerError().body("error da exepction 500");
    }

}
