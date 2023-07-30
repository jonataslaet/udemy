package com.in28minutes.microservices.currencyexchangeservice.controllers;

import com.in28minutes.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ) {
        logger.info("retrieveExchangeValue called with {} to {}", from, to);
        String environmentPort = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyExchangeByFromAndTo(from, to);
        currencyExchange.setEnvironment(environmentPort);
        return currencyExchange;
    }
}
