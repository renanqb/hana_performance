package com.example.hibernate.jpa.crud.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ConfigDatasources {

    @Autowired
    private Environment env;

    @Bean(name = "mssqlDataSource")
    public DataSource mssqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource1.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource1.url"));
        dataSource.setUsername(env.getProperty("spring.datasource1.username"));
        dataSource.setPassword(env.getProperty("spring.datasource1.password"));
 
        return dataSource;
    }

    @Primary
    @Bean(name = "hanaDataSource")
    public DataSource hanaDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource2.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource2.url"));
        dataSource.setUsername(env.getProperty("spring.datasource2.username"));
        dataSource.setPassword(env.getProperty("spring.datasource2.password"));
 
        return dataSource;
    }
}
