package com.example.springboot.repository;

import com.example.springboot.model.Employee;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);
    List<Employee> findByNameAndLocation(String name, String location);
    List<Employee> findByNameContaining(String name, Sort sort);

    @Query("FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name = :name")
    Integer deleteEmployeeByName(String name);

    List<Employee> findByDepartmentName(String name);

    @Query("FROM Employee where department.name=:name")
    List<Employee>  getEmployeeByDepartmentName(String name);
}
