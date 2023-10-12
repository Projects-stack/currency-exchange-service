package com.in28minutes.microservices.currencyexchangeservice.persistence.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeEntity
{
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
