package com.example.hibernate.jpa.crud.repo2.dao;

import com.example.hibernate.jpa.crud.repo2.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository2 extends JpaRepository<Employee, Long>{
    
}