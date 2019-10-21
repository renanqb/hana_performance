package com.example.hibernate.jpa.crud.repo1.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CityInsertRepository1 {
 
    @PersistenceContext(unitName = "mssqlEntityManagerFactory")
    private EntityManager entityManager;
    
    @Transactional(transactionManager = "mssqlTransactionManager")
    public void insertWithQuery(String query) {
        
        entityManager.createNativeQuery(query).executeUpdate();
    }
}