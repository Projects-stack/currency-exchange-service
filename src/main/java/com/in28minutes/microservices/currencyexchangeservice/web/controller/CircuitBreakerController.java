package com.in28minutes.microservices.currencyexchangeservice.web.controller;

import lombok.extern.slf4j.Slf4j;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController
{
    @GetMapping("/sampleApi")
//    @Retry(name = "sampleApi", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sample()
    {
        log.info("Sample API call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();
    }

    public String hardcodedResponse(Exception ex)
    {
        if (ex != null)
            return "Fallback response ---> " + ex.getMessage();
        return "Fallback response";
    }
}
