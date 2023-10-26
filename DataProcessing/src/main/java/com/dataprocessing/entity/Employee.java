package com.dataprocessing.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    private int emp_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phonenumber;
    private Date hire_date;
    private String job_id;
    private int salary;
    private int manager_id;
    private int department_id;


}
