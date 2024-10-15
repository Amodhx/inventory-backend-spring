package org.example.inventorybackendspring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/healthcheck")
public class HealthCheckController {

    static Logger logger = LoggerFactory.getLogger(HealthCheckController.class);
    @GetMapping
    public String healthCheck(){
        return "Health Check Confirmed!!! ";
    }
}
