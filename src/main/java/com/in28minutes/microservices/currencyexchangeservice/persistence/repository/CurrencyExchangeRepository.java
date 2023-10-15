package com.in28minutes.microservices.currencyexchangeservice.persistence.repository;

import java.util.Optional;

import com.in28minutes.microservices.currencyexchangeservice.persistence.db.CurrencyExchangeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long>
{
    Optional<CurrencyExchangeEntity> findByFromAndTo(String from, String to);
}
