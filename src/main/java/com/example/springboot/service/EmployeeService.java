package com.example.springboot.service;

import com.example.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {


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
    List<Employee> getEmployees(int pageNumber, int pageSize);
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByNameAndLocation(String name, String location);
    List<Employee> findByNameContaining(String name);
}
