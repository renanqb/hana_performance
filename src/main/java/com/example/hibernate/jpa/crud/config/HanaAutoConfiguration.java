
package com.example.hibernate.jpa.crud.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "hanaEntityManagerFactory", 
    transactionManagerRef = "hanaTransactionManager", 
    basePackages = "com.example.hibernate.jpa.crud.repo2.dao")
@EnableTransactionManagement
public class HanaAutoConfiguration {

    @Autowired
    private Environment env;

    public HanaAutoConfiguration() {
        super();
    }

    @Primary
    @Bean(name = "hanaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean hanaEntityManagerFactory(
        final EntityManagerFactoryBuilder builder,
        final @Qualifier("hanaDataSource") DataSource hanaDataSource) {

        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect2"));

        return builder
            .dataSource(hanaDataSource)
            .packages("com.example.hibernate.jpa.crud.repo2.model")
            .persistenceUnit("hanaDb")
            .properties(properties)
            .build();
    }

    @Primary
    @Bean(name = "hanaTransactionManager")
    public PlatformTransactionManager hanaTransactionManager(
        final @Qualifier("hanaEntityManagerFactory") EntityManagerFactory hanaEntityManagerFactory) {
        
        return new JpaTransactionManager(hanaEntityManagerFactory);
    }
}
