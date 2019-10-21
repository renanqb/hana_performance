package com.example.hibernate.jpa.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.hibernate.jpa.crud.repo1.dao.CityInsertRepository1;
import com.example.hibernate.jpa.crud.repo1.dao.CityRepository1;
import com.example.hibernate.jpa.crud.repo1.dao.EmployeeRepository1;
import com.example.hibernate.jpa.crud.repo1.model.City;
import com.example.hibernate.jpa.crud.repo1.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class Company1Controller {
    
    @Autowired
    private EmployeeRepository1 employeeRepository;

    @Autowired
    private CityRepository1 cityRepository;

    @Autowired
    private CityInsertRepository1 cityInsertRepository;
    
    // City

    @GetMapping("/cities1")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @PostMapping("/cities1")
    public boolean createCity(@Valid @RequestBody City city) {
        cityInsertRepository.insertWithQuery(city.toString());
        return true;
    }

    // Employee

    @GetMapping("/employees1")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
        // return employeeRepositoryCustom.findMyWay(); 
    }

    @GetMapping("/employees1/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }
    
    @PostMapping("/employees1")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees1/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailAddress(employeeDetails.getEmailAddress());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees1/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}