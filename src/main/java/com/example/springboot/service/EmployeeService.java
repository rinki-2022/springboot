package com.example.springboot.service;

import com.example.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeesByName(String name);
}
