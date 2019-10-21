package com.example.hibernate.jpa.crud.repo1.dao;

import com.example.hibernate.jpa.crud.repo1.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository1 extends JpaRepository<Employee, Long> {

}