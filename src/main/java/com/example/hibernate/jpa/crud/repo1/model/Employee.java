package com.example.hibernate.jpa.crud.repo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
 
    public Employee() {
  
    }
 
    public Employee(String firstName, String lastName, String emailAddress) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.emailAddress = emailAddress;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Column(name = "email_address", nullable = false)
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Employee [id=" 
            + id + ", firstName=" 
            + firstName + ", lastName=" 
            + lastName 
            + ", emailAddress=" + emailAddress 
            + "]";
    }
}