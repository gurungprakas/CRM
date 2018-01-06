 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.entity;

/**
 *
 * @author Prakas
 */
public class ComplainStatus {
    private int id;
    private String status,color;

    public ComplainStatus() {
    }
    
    public ComplainStatus(int id) {
        this.id=id;
    }

    public ComplainStatus(int id, String status, String color) {
        this.id = id;
        this.status = status;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
