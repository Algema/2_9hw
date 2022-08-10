package com.example.hw2_9;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "не найден")
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String massage) {
        super(massage);
    }
    // не найден
}
