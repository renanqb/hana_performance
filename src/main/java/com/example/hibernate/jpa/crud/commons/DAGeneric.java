package com.example.hibernate.jpa.crud.commons;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAGeneric {
	
	public static final String QUERY_MSG = "É obrigatório informar uma query sql válida!";

	@Autowired
	private ConnectionFactory factory;;

	public void executeBatch(String[] queries) throws ClassNotFoundException, SQLException {
        
        try (Connection conn = factory.getConnection(); Statement statement = conn.createStatement()) {
       
            for (String query : queries) {
                statement.addBatch(query);
            }
            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void executeBatchWtihTransaction(String[] queries) throws ClassNotFoundException, SQLException {
        
        try (Connection conn = factory.getConnection(); Statement statement = conn.createStatement()) {
            
            conn.setAutoCommit(false);
            
            for (String query : queries) {
                statement.addBatch(query);
            }
            statement.executeBatch();

            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
}
