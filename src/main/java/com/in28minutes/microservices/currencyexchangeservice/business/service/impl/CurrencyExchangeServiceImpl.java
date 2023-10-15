package com.in28minutes.microservices.currencyexchangeservice.business.service.impl;

import com.in28minutes.microservices.currencyexchangeservice.business.service.CurrencyExchangeService;
import com.in28minutes.microservices.currencyexchangeservice.persistence.db.CurrencyExchangeEntity;
import com.in28minutes.microservices.currencyexchangeservice.persistence.repository.CurrencyExchangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("currencyExchangeService")
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService
{

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public CurrencyExchangeEntity findByFromAndTo(String from, String to)
    {
        return currencyExchangeRepository.findByFromAndTo(from, to).orElseThrow(() ->
                    new RuntimeException("Unable to find data for " + from + " to " + to));
    }
}
