package com.andres.curso.springboot.error.springbooterror.web.controllers;

import com.andres.curso.springboot.error.springbooterror.web.exceptions.Error;
import com.andres.curso.springboot.error.springbooterror.web.exceptions.ErrorRFC7807;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorRFC7807> divisionByZero(Exception exception, HttpServletRequest request) {

        ErrorRFC7807 error = new ErrorRFC7807("Divisão por zero",
                "Não é possivel efeturar divisão por zero",
                request.getRequestURL().toString(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorRFC7807> notFound(Exception exception, HttpServletRequest request) {
        ErrorRFC7807 error = new ErrorRFC7807("Recurso não encontrado",
                "Não é possivel localizar o recurso solicitado",
                request.getRequestURL().toString(),
                HttpStatus.NOT_FOUND.value(),
                new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "String inválido não possui um número");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

}
