package com.devsenai1a.calculadora;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public Object dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return "Erro: divisão por zero não é permitida.";
        }
        return a / b;
    }

    @PostMapping("/calcular")
    @ResponseBody
    public Map<String, Object> calcularJson(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operacao) {

        Map<String, Object> resp = new HashMap<>();
        double resultado = 0;
        String erro = null;

        switch (operacao.toLowerCase()) {
            case "somar":
                resultado = num1 + num2;
                break;
            case "subtrair":
                resultado = num1 - num2;
                break;
            case "multiplicar":
                resultado = num1 * num2;
                break;
            case "dividir":
                if (num2 == 0) {
                    erro = "Divisão por zero não é permitida.";
                } else {
                    resultado = num1 / num2;
                }
                break;
            default:
                erro = "Operação inválida.";
        }

        if (erro != null) {
            resp.put("erro", erro);
        } else {
            resp.put("resultado", resultado);
        }

        return resp;
    }
}
