package com.in28minutes.microservices.currencyexchangeservice.web.controller;

import java.math.BigDecimal;

import com.in28minutes.microservices.currencyexchangeservice.business.common.GlobalConstants;
import com.in28minutes.microservices.currencyexchangeservice.business.service.CurrencyExchangeService;
import com.in28minutes.microservices.currencyexchangeservice.persistence.db.CurrencyExchangeEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GlobalConstants.API + "/currency-exchange")
public class CurrencyExchangeController
{
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;
    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchangeEntity retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
    {
        CurrencyExchangeEntity currencyExchangeEntity = currencyExchangeService.findByFromAndTo(from, to);
        String port = environment.getProperty(GlobalConstants.LOCAL_SERVER_PORT);
        currencyExchangeEntity.setEnvironment(port);
        return currencyExchangeEntity;
    }
}
