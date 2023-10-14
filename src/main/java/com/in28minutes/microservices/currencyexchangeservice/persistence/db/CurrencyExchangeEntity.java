package com.in28minutes.microservices.currencyexchangeservice.persistence.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchangeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    @Column(name = "conversionMultiple")
    private BigDecimal conversionMultiple;

    @Transient
    private String environment;

    public CurrencyExchangeEntity(String from, String to, BigDecimal conversionMultiple)
    {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
