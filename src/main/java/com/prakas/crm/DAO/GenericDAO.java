/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Prakas
 */
public interface GenericDAO<T>{
    int insert(T t) throws ClassNotFoundException,SQLException;
    List<T> getAll() throws ClassNotFoundException,SQLException;
    T getbyId(int id)throws ClassNotFoundException,SQLException;
    
}
