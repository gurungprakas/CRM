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
public class CustomerComplainStatus {
    private int id;
    private Complain complain;
    private ComplainStatus status;
    private Date statusUpadateDate;
    private String remarks;

    public CustomerComplainStatus() {
    }

    public CustomerComplainStatus(int id, Complain complain, ComplainStatus status, String remarks) {
        this.id = id;
        this.complain = complain;
        this.status = status;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Complain getComplain() {
        return complain;
    }

    public void setComplain(Complain complain) {
        this.complain = complain;
    }

    public ComplainStatus getStatus() {
        return status;
    }

    public void setStatus(ComplainStatus status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
}
