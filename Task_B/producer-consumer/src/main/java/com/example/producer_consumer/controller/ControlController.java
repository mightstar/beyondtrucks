package com.example.producerconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlController {

    @GetMapping("/status")
    public String getStatus() {
        return "Producer-Consumer system is running!";
    }
}
