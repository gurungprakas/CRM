/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.DAO.impl;

import com.prakas.crm.DAO.DepartmentDAO;
import com.prakas.crm.constant.SqlConstant;
import com.prakas.crm.dbutil.DbConnection;
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
public class DepartmentDAOImpl implements DepartmentDAO{
    private DbConnection db=new DbConnection();
    
    @Override
    public int insert(Department dept) throws ClassNotFoundException, SQLException {
        db.connect();
        PreparedStatement stmt=db.initStatement(SqlConstant.DEPARTMENT_INSERT);
        stmt.setString(1,dept.getName());
        stmt.setString(2,dept.getEmail());
        int result=db.update();
        db.close();
        return result;
        
    }

    @Override
    public List<Department> getAll() throws ClassNotFoundException, SQLException {
       List<Department> deptList=new ArrayList<>();
       db.connect();
       db.initStatement(SqlConstant.DEPARTMENT_GETALL);
        //System.out.println(SqlConstant.DEPARTMENT_GETALL);
        ResultSet rs=db.query();
        while(rs.next ()){
        Department dept=new Department();
        dept.setId(rs.getInt("department_id"));
        dept.setName(rs.getString("department_name"));
        dept.setEmail(rs.getString("email"));
        deptList.add(dept);
    }
        db.close();
        return deptList;
    }

    @Override
    public Department getbyId(int id) throws ClassNotFoundException, SQLException {
        Department dept=null;
          db.connect();
       PreparedStatement stmt=db.initStatement(SqlConstant.DEPARTMENT_GETBYID);
       stmt.setInt(1, id);
        //System.out.println(SqlConstant.DEPARTMENT_GETALL);
        ResultSet rs=db.query();
      if(rs.next ()){
        dept=new Department();
        dept.setId(rs.getInt("department_id"));
        dept.setName(rs.getString("department_name"));
        dept.setEmail(rs.getString("email"));
        
    }
        db.close();
        return dept;
    }
    
    
}
