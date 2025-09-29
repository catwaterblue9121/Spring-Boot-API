package com.devsenai1a.calculadora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraApplicationControlls {

    @GetMapping("/somar")
    public double somar(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/subtrair")
    public double subtrair(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        return a / b;
    }
}
