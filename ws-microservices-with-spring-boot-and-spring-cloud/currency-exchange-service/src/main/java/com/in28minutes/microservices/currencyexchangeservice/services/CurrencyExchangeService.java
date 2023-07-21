package com.in28minutes.microservices.currencyexchangeservice.services;

import com.in28minutes.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CurrencyExchangeService {
    
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }
    
    public CurrencyExchange getCurrencyExchangeByFromAndTo(String from, String to) {
        CurrencyExchange foundByFromAndTo = currencyExchangeRepository.findByFromAndTo(from, to);
        if (Objects.isNull(foundByFromAndTo)) {
            throw new RuntimeException("Unable to find by converting from "+ from + " to " + to);
        }
        return foundByFromAndTo;
    }
}
