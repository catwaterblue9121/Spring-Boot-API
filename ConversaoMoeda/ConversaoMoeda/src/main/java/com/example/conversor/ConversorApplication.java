package com.example.conversor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/conversor")
public class ConversorApplication {

    private static final double DOLAR_PARA_REAL = 5.0;
    private static final double EURO_PARA_REAL = 6.0;

    public static void main(String[] args) {
        SpringApplication.run(ConversorApplication.class, args);
    }

    @GetMapping("/converter")
    public Map<String, Object> converter(
            @RequestParam String moedaOrigem,
            @RequestParam double valor) {

        moedaOrigem = moedaOrigem.toLowerCase();

        if (valor < 0) {
            return Map.of("erro", "Valor deve ser positivo");
        }

        if (!moedaOrigem.equals("real") && !moedaOrigem.equals("dolar") && !moedaOrigem.equals("euro")) {
            return Map.of("erro", "Moeda inválida. Use: real, dolar ou euro");
        }

        Map<String, Double> resultados = new HashMap<>();

        switch (moedaOrigem) {
            case "real":
                resultados.put("dolar", valor / DOLAR_PARA_REAL);
                resultados.put("euro", valor / EURO_PARA_REAL);
                break;

            case "dolar":
                double valorEmReal = valor * DOLAR_PARA_REAL;
                resultados.put("real", valorEmReal);
                resultados.put("euro", valorEmReal / EURO_PARA_REAL);
                break;

            case "euro":
                double valorEmReal2 = valor * EURO_PARA_REAL;
                resultados.put("real", valorEmReal2);
                resultados.put("dolar", valorEmReal2 / DOLAR_PARA_REAL);
                break;
        }

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("moedaOrigem", moedaOrigem);
        resposta.put("valorOriginal", valor);
        resposta.put("conversoes", resultados);

        return resposta;
    }
}