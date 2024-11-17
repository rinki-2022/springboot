package com.example.springboot.model;

import com.example.springboot.request.EmployeeRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should not be null")
    private String name;

    private Integer age;

    private String location;

    @Email(message = "Please enter valid email")
    private String email;

    @JoinColumn(name="department_id")
    @OneToOne
    private Department department;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updateAt;

    public Employee(EmployeeRequest employeeRequest) {
        this.name = employeeRequest.getName();
    }
    public Employee() {
    }
}
