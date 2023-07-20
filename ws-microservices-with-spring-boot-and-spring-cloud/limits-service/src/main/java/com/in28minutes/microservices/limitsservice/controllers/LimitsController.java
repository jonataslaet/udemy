package com.in28minutes.microservices.limitsservice.controllers;

import com.in28minutes.microservices.limitsservice.beans.Limits;
import com.in28minutes.microservices.limitsservice.configs.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {

//        return new Limits(1, 1000);
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
