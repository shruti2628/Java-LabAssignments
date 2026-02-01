package com.welcomeapp.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	private final MessageFormatter formatter;

    public WelcomeService(MessageFormatter formatter) {
        this.formatter = formatter;
    }

    public String greet(String name) {
        String message = "Welcome " + name + " to Spring Boot!";
        return formatter.format(message);
    }
}