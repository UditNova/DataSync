package com.dataprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataprocessing.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
