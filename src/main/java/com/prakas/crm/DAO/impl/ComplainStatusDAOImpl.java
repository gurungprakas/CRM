/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.DAO.impl;

import com.prakas.crm.DAO.ComplainStatusDAO;
import com.prakas.crm.constant.SqlConstant;
import com.prakas.crm.dbutil.DbConnection;
import com.prakas.crm.entity.ComplainStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prakas
 */
public class ComplainStatusDAOImpl implements ComplainStatusDAO{
    private DbConnection db=new DbConnection();
    
    @Override
    public int insert(ComplainStatus status) throws ClassNotFoundException, SQLException {
        db.connect();
        PreparedStatement stmt=db.initStatement(SqlConstant.COMPLAIN_STATUS_INSERT);
        stmt.setString(1,status.getStatus());
        stmt.setString(2,status.getColor());
        int result=db.update();
        db.close();
        return result;
        
    }

    @Override
    public List<ComplainStatus> getAll() throws ClassNotFoundException, SQLException {
       List<ComplainStatus> statusList=new ArrayList<>();
       db.connect();
       db.initStatement(SqlConstant.COMPLAIN_STATUS_GETALL);
        //System.out.println(SqlConstant.COMPLAIN_STATUS_GETALL);
        ResultSet rs=db.query();
        while(rs.next ()){
        ComplainStatus status=new ComplainStatus();
        status.setId(rs.getInt("status_id"));
        status.setStatus(rs.getString("status"));
        status.setColor(rs.getString("color"));
        statusList.add(status);
    }
        db.close();
        return statusList;
    }

    @Override
    public ComplainStatus getbyId(int id) throws ClassNotFoundException, SQLException {
        ComplainStatus status=null;
          db.connect();
       PreparedStatement stmt=db.initStatement(SqlConstant.COMPLAIN_STATUS_GETBYID);
       stmt.setInt(1, id);
        //System.out.println(SqlConstant.COMPLAIN_STATUS_GETALL);
        ResultSet rs=db.query();
      if(rs.next ()){
        status=new ComplainStatus();
        status.setId(rs.getInt("status_id"));
        status.setStatus(rs.getString("status"));
        status.setColor(rs.getString("color"));
        
    }
        db.close();
        return status;
    }
    
    
}
