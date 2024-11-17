package com.example.springboot.service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return employeeRepository.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
       // return employeeRepository.save(employee);
        return null;
    }

    @Override
    public Employee getSingleEmployee(Long id) {
       // Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Optional<Employee> optionalEmployee = null;
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        throw new RuntimeException("Employee not found for id: "+id);
    }

    @Override
    public void deleteEmployee(Long id) {
       // employeeRepository.deleteById(id);
        //employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
      //  return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> findByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }
}
