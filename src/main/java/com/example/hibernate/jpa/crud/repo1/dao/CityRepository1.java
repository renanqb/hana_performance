package com.example.hibernate.jpa.crud.repo1.dao;

import com.example.hibernate.jpa.crud.repo1.model.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository1 extends JpaRepository<City, Long> {

}