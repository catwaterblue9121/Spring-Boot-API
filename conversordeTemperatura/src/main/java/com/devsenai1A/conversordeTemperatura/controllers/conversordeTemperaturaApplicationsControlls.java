package com.devsenai1A.conversordeTemperatura.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class conversordeTemperaturaApplicationsControlls {

    @GetMapping("/celsius-para-fahrenheit")
    public Map<String, Double> celsiusParaFahrenheit(@RequestParam double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        Map<String, Double> resposta = new HashMap<>();
        resposta.put("celsius", celsius);
        resposta.put("fahrenheit", fahrenheit);
        return resposta;
    }

    @GetMapping("/fahrenheit-para-celsius")
    public Map<String, Double> fahrenheitParaCelsius(@RequestParam double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        Map<String, Double> resposta = new HashMap<>();
        resposta.put("fahrenheit", fahrenheit);
        resposta.put("celsius", celsius);
        return resposta;
    }
}