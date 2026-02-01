package com.welcomeapp.controller;

import com.welcomeapp.service.WelcomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    private final WelcomeService welcomeService;

    public WelcomeController(WelcomeService service) {
        this.welcomeService = service;
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return welcomeService.greet(name);
    }
}
