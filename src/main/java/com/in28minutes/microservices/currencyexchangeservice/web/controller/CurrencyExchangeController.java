package com.in28minutes.microservices.currencyexchangeservice.web.controller;

import java.math.BigDecimal;

import com.in28minutes.microservices.currencyexchangeservice.business.common.GlobalConstants;
import com.in28minutes.microservices.currencyexchangeservice.persistence.db.CurrencyExchangeEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GlobalConstants.API + "/currency-exchange")
public class CurrencyExchangeController
{
    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchangeEntity retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
    {
        return new CurrencyExchangeEntity(1000L, "USD", "INR", BigDecimal.valueOf(50));
    }
}
