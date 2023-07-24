package com.in28minutes.microservices.currencyexchangeservice.controllers;

import com.in28minutes.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ) {
        String environmentPort = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyExchangeByFromAndTo(from, to);
        currencyExchange.setEnvironment(environmentPort);
        return currencyExchange;
    }
}
