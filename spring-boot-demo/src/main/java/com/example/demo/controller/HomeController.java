package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "Hello Spring boot";
    }

    @GetMapping("/reload")
    public String reload() {
        return "Reload baby";
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi babe";
    }
}
