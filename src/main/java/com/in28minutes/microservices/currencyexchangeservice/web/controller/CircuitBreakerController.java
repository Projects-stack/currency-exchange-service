package com.in28minutes.microservices.currencyexchangeservice.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController
{
    @GetMapping("/sampleApi")
    public String sample()
    {
        return "Sample API";
    }
}
