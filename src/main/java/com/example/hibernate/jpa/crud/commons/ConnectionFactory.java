package com.example.hibernate.jpa.crud.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {
    
    @Value("${spring.datasource2.url}")
	private String servidor;

	/** usuario */
	@Value("${spring.datasource2.username}")
	private String usuario;

	/** senha */
	@Value("${spring.datasource2.password}")
	private String senha;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.sap.db.jdbc.Driver");
        Connection conn = DriverManager.getConnection(servidor, usuario, senha);
        return conn;
	}

	public void closeConnection(final Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
