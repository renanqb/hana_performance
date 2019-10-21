package com.example.hibernate.jpa.crud.repo2.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

@Repository
public class TabelaoInsertRepositoryJPA {
    
    @PersistenceContext(unitName = "hanaEntityManagerFactory")
    EntityManager entityManager;

    public void insertWithQuery(String[] queries, int count) throws SQLException {
        System.out.println("-> insertWithQuery.in -> " + new Date());
        
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.doWork(new Work() {
            @Override
            public void execute(Connection conn) throws SQLException {
                 
                System.out.println("-> insertWithQuery.doWork.execute.in -> " + new Date());

                Statement statement = conn.createStatement();
                for (String query : queries) {
                    statement.addBatch(query);
                }                
                statement.executeBatch();
                statement.close();

                boolean getOut = false;
                if (getOut) {
                    session.getTransaction().rollback();
                    throw new SQLException("-> insertWithQuery.doWork.execute.out with exeption");
                }

                System.out.println("-> insertWithQuery.doWork.execute.out -> " + new Date());
            }
        });

        session.getTransaction().commit();
        
        System.out.println("-> insertWithQuery.out -> " + new Date());
    }
}
