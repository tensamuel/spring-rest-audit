package com.github.tensam.springrestaudit.controller;

import com.github.tensam.springrestaudit.annotation.Auditable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    @Auditable
    public String testMethod() {
        return "Hello World";
    }
}
