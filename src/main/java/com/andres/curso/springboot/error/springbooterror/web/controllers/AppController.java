package com.andres.curso.springboot.error.springbooterror.web.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    // conceito de manejar exceptions é para tornar execões mais amigavéis
    @GetMapping("/app")
    public String index() {
        // int error = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "OK 200";
    }

}
