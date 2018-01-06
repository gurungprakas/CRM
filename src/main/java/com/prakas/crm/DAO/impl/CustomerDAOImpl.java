/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.DAO.impl;

import com.prakas.crm.DAO.CustomerDAO;
import com.prakas.crm.constant.SqlConstant;
import com.prakas.crm.dbutil.DbConnection;
import com.prakas.crm.entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prakas
 */
public class CustomerDAOImpl implements CustomerDAO{
    private DbConnection db=new DbConnection();
    
    @Override
    public int insert(Customer customer) throws ClassNotFoundException, SQLException {
        db.connect();
        PreparedStatement stmt=db.initStatement(SqlConstant.CUSTOMER_INSERT);
        stmt.setString(1,customer.getFirstName());
        stmt.setString(2,customer.getLastName());
        stmt.setString(3,customer.getEmail());
        stmt.setString(4,customer.getContactNo());
        stmt.setBoolean(5,customer.isStatus());
        
        int result=db.update();
        db.close();
        return result;
        
    }

    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {
       List<Customer> customerList=new ArrayList<>();
       db.connect();
       db.initStatement(SqlConstant.CUSTOMER_GETALL);
        //System.out.println(SqlConstant.CUSTOMER_GETALL);
        ResultSet rs=db.query();
        while(rs.next ()){
        Customer customer=new Customer();
        customer.setId(rs.getInt("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email"));
        customer.setContactNo(rs.getString("contact_no"));
        customer.setStatus(rs.getBoolean("status"));
        customerList.add(customer);
    }
        db.close();
        return customerList;
    }

    @Override
    public Customer getbyId(int id) throws ClassNotFoundException, SQLException {
        Customer customer=null;
          db.connect();
       PreparedStatement stmt=db.initStatement(SqlConstant.CUSTOMER_GETBYID);
       stmt.setInt(1, id);
        //System.out.println(SqlConstant.CUSTOMER_GETALL);
        ResultSet rs=db.query();
      if(rs.next ()){
        customer=new Customer();
        customer.setId(rs.getInt("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email"));
        customer.setContactNo(rs.getString("contact_no"));
        customer.setStatus(rs.getBoolean("status"));
        
    }
        db.close();
        return customer;
    }
    
    
}
