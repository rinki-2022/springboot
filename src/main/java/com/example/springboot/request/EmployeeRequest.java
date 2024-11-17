package com.example.springboot.request;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeRequest {

    private String name;
    private List<String> department;
}
