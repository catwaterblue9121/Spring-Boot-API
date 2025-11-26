package com.seuprojeto.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculadoraController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
