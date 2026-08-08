package com.example.demo.controller;

import com.example.demo.service.InfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return infoService.getGreeting() + "\n"
                + "Host: " + request.getHeader("Host") + "\n"
                + "X-Real-IP: " + request.getHeader("X-Real-IP") + "\n"
                + "X-Forwarded-For: " + request.getHeader("X-Forwarded-For") + "\n";
    }

    @GetMapping("/health")
    public String health() {
        return infoService.getHealthStatus() + "\n";
    }
}
