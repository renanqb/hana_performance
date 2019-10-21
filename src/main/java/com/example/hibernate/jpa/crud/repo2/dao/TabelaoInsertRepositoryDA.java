package com.example.hibernate.jpa.crud.repo2.dao;

import java.sql.SQLException;

import com.example.hibernate.jpa.crud.commons.DAGeneric;

import org.springframework.stereotype.Component;

@Component
public class TabelaoInsertRepositoryDA extends DAGeneric {

    public void insertBatchByEvent(String[] queries) throws ClassNotFoundException, SQLException {
        super.executeBatch(queries);
    }
}