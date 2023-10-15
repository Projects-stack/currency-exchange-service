package com.in28minutes.microservices.currencyexchangeservice.business.service;

import com.in28minutes.microservices.currencyexchangeservice.persistence.db.CurrencyExchangeEntity;

public interface CurrencyExchangeService
{
    CurrencyExchangeEntity findByFromAndTo(String from, String to);
}
