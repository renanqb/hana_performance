
package com.example.hibernate.jpa.crud.repo2.dao;

import com.example.hibernate.jpa.crud.repo2.model.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository2 extends JpaRepository<City, Long> {

}