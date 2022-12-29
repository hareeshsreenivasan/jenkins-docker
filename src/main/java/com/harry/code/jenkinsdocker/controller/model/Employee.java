package com.harry.code.jenkinsdocker.controller.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeDOB;
}
