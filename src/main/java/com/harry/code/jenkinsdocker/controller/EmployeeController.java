package com.harry.code.jenkinsdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @GetMapping("/ping")
    public String ping(){
        return "Thank you @"+new Date();
    }
}
