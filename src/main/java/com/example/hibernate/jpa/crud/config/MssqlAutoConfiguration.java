package com.example.hibernate.jpa.crud.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "mssqlEntityManagerFactory", 
    transactionManagerRef = "mssqlTransactionManager", 
    basePackages = "com.example.hibernate.jpa.crud.repo1.dao")
@EnableTransactionManagement
public class MssqlAutoConfiguration {

    @Autowired
    private Environment env;

    public MssqlAutoConfiguration() {
        super();
    }

    @Bean(name = "mssqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mssqlEntityManagerFactory(
            final EntityManagerFactoryBuilder builder, 
            final @Qualifier("mssqlDataSource") DataSource mssqlDataSource) {

        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect1"));

        return builder
            .dataSource(mssqlDataSource)
            .packages("com.example.hibernate.jpa.crud.repo1.model")
            .persistenceUnit("mssqlDb")
            .properties(properties)
            .build();
    }
    
    @Bean(name = "mssqlTransactionManager")
    public PlatformTransactionManager mssqlTransactionManager(
        final @Qualifier("mssqlDataSource") DataSource dataSource,
        @Qualifier("mssqlEntityManagerFactory") EntityManagerFactory mssqlEntityManagerFactory) {
        
        return new JpaTransactionManager(mssqlEntityManagerFactory);
    }
}
