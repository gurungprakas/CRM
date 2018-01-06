/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.DAO.impl;

import com.prakas.crm.DAO.ComplainDAO;
import com.prakas.crm.constant.SqlConstant;
import com.prakas.crm.dbutil.DbConnection;
import com.prakas.crm.entity.Complain;
import com.prakas.crm.entity.ComplainStatus;
import com.prakas.crm.entity.Customer;
import com.prakas.crm.entity.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prakas
 */
public class ComplainDAOImpl implements ComplainDAO{
    private DbConnection db=new DbConnection();
    
    @Override
    public int insert(Complain complain) throws ClassNotFoundException, SQLException {
        db.connect();
        PreparedStatement stmt=db.initStatement(SqlConstant.COMPLAIN_INSERT);
        stmt.setInt(1,complain.getCustomer().getId());
        stmt.setInt(2,complain.getDepartment().getId());
        stmt.setString(3,complain.getSubject());
        stmt.setString(4,complain.getDescription());
        stmt.setInt(5,complain.getStatus().getId());
        int result=db.update();
        db.close();
        return result;
        
    }

    @Override
    public List<Complain> getAll() throws ClassNotFoundException, SQLException {
       List<Complain> complainList=new ArrayList<>();
       db.connect();
       db.initStatement(SqlConstant.COMPLAIN_GETALL);
        //System.out.println(SqlConstant.COMPLAIN_GETALL);
        ResultSet rs=db.query();
        while(rs.next ()){
        Complain complain=new Complain();
        complain.setId(rs.getInt("complain_id"));
        complain.setSubject(rs.getString("subject"));
        complain.setDescription(rs.getString("description"));
        Customer customer=new Customer(rs.getInt("customer_id"), rs.getString("first_name"),rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"), true);
        complain.setCustomer(customer);
        Department dept=new Department(rs.getInt("department_id"),rs.getString("department_name"), rs.getString("dept_email"));
        complain.setDepartment(dept);
        
        ComplainStatus status=new ComplainStatus(rs.getInt("status_id"),rs.getString("com_status"),rs.getString("color"));
        complain.setStatus(status);
        complainList.add(complain);
        
    }
        db.close();
        return complainList;
    }

    @Override
    public Complain getbyId(int id) throws ClassNotFoundException, SQLException {
        Complain complain=null;
          db.connect();
       PreparedStatement stmt=db.initStatement(SqlConstant.COMPLAIN_GETBYID);
       stmt.setInt(1, id);
        //System.out.println(SqlConstant.COMPLAIN_GETALL);
        ResultSet rs=db.query();
      if(rs.next ()){
        complain=new Complain();
      complain.setId(rs.getInt("complain_id"));
        complain.setSubject(rs.getString("subject"));
        complain.setDescription(rs.getString("description"));
        Customer customer=new Customer(rs.getInt("customer_id"), rs.getString("first_name"),rs.getString("last_name"), rs.getString("email"), rs.getString("contact_no"), true);
        complain.setCustomer(customer);
        Department dept=new Department(rs.getInt("department_id"),rs.getString("department_name"), rs.getString("dept_email"));
        complain.setDepartment(dept);
        ComplainStatus status=new ComplainStatus(rs.getInt("status_id"),rs.getString("com_status"),rs.getString("color"));
        complain.setStatus(status);
        
        
    }
        db.close();
        return complain;
    }
    
    
}
