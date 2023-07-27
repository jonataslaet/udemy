package com.in28minutes.microservices.currencyconversionservice.controllers;

import com.in28minutes.microservices.currencyconversionservice.entities.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("quantity") BigDecimal quantity
    ) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> currencyConversionResponseEntity = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,
                uriVariables
        );
        CurrencyConversion currencyConversion = currencyConversionResponseEntity.getBody();
        return new CurrencyConversion(
                currencyConversion.getId(),
                from, to,
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " rest template"
        );
    }

    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("quantity") BigDecimal quantity
    ) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);
        return new CurrencyConversion(
                currencyConversion.getId(),
                from, to,
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " feign"
        );
    }
}
