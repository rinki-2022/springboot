package com.example.springboot.service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

//    private static  List<Employee> list = new ArrayList();
//    static{
//        Employee emp = new Employee();
//        emp.setName("raj");
//        emp.setAge(22);
//        emp.setLocation("UK");
//        emp.setEmail("raj@hotmail.com");
//        emp.setDepartment("HR");
//
//        Employee emp1 = new Employee();
//        emp1.setName("rani");
//        emp1.setAge(22);
//        emp1.setLocation("UK");
//        emp1.setEmail("rani@hotmail.com");
//        emp1.setDepartment("HR");
//
//        list.add(emp1);
//        list.add(emp);
//    }
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        throw new RuntimeException("Employee not found for id: "+id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }
}
