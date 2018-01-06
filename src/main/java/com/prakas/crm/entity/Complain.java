/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.entity;

import java.util.Date;

/**
 *
 * @author Prakas
 */
public class Complain {
    private int id;
    private Customer customer;
    private Department department;
    private String subject,description;
    private Date complainDate;
    private ComplainStatus status;

    public Complain() {
    }

    public Complain(int id, Customer customer, Department department, String subject, String description, ComplainStatus status) {
        this.id = id;
        this.customer = customer;
        this.department = department;
        this.subject = subject;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComplainStatus getStatus() {
        return status;
    }

    public void setStatus(ComplainStatus status) {
        this.status = status;
    }
        
    
    
}
