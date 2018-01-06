 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.constant;

/**
 *
 * @author Prakas
 */
public class SqlConstant {
    public final static String DEPARTMENT_INSERT="INSERT INTO tbl_departments(department_name,email) values (?,?)";
    public final static String DEPARTMENT_GETALL="SELECT * FROM tbl_departments";
    public final static String DEPARTMENT_GETBYID="SELECT * FROM tbl_departments where department_id=?";
   
    public final static String COMPLAIN_STATUS_INSERT="INSERT INTO tbl_complain_status(status,color) values(?,?)";
    public final static String COMPLAIN_STATUS_GETALL="SELECT * FROM tbl_complain_status";
    public final static String COMPLAIN_STATUS_GETBYID="SELECT * FROM tbl_complain_status where status_id=?";
    
    public final static String CUSTOMER_INSERT="INSERT INTO tbl_customers(first_name,last_name,email,contact_no,status) values (?,?,?,?,?)";
    public final static String CUSTOMER_GETALL="SELECT * FROM tbl_customers";
    public final static String CUSTOMER_GETBYID="SELECT * FROM tbl_customer where customer_id=?";
    
    public final static String COMPLAIN_INSERT="INSERT INTO tbl_complain(customer_id,department_id,subject,description,status_id) values (?,?,?,?,?)";
    public final static String COMPLAIN_GETALL="SELECT com*,cust*,department_id,department_name,dept.email as dept_email,sts.status as  com_status,st.color FROM tbl_complain com"
                                                + "join tbl_customers cust on" 
                                                + "cust.customer_id=com.customer_id"
                                                + "join tbl_departments dept on"
                                                +"dept.department_id=com.department_id"
                                                + "join tbl_complain_status sts on"
                                                +"sts.status_id=com.status_id";
    public final static String COMPLAIN_GETBYID="SELECT * FROM tbl_complain com"
                                                + "join tbl_customers cust on" 
                                                + "cust.customer_id=com.customer_id"
                                                + "join tbl_departments dept on"
                                                +"dept.department_id=com.department_id"
                                                + "join tbl_complain_status sts on"
                                                +"sts.status_id=com.status_id WHERE com.complain_id=?";
}
