/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakas.crm.controller;

import com.prakas.crm.DAO.ComplainDAO;
import com.prakas.crm.DAO.ComplainStatusDAO;
import com.prakas.crm.DAO.CustomerDAO;
import com.prakas.crm.DAO.DepartmentDAO;
import com.prakas.crm.DAO.impl.ComplainDAOImpl;
import com.prakas.crm.DAO.impl.ComplainStatusDAOImpl;
import com.prakas.crm.DAO.impl.CustomerDAOImpl;
import com.prakas.crm.DAO.impl.DepartmentDAOImpl;
import com.prakas.crm.constant.SystemConstant;
import com.prakas.crm.entity.Complain;
import com.prakas.crm.entity.ComplainStatus;
import com.prakas.crm.entity.Customer;
import com.prakas.crm.entity.Department;
import com.prakas.crm.system.Controller;
import com.prakas.crm.system.Mailer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prakas
 */
@WebServlet(name = "default", urlPatterns = {"/"})
public class DefaultController extends Controller {

    private ComplainDAO comDAO = new ComplainDAOImpl();
    private CustomerDAO custDAO = new CustomerDAOImpl();
    private DepartmentDAO deptDAO = new DepartmentDAOImpl();
    private ComplainStatusDAO csDAO = new ComplainStatusDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("customers", custDAO.getAll());
            request.setAttribute("departments", deptDAO.getAll());
            request.setAttribute("statuses", csDAO.getAll());
            request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Complain complain = new Complain();
            Department department=deptDAO.getbyId(Integer.parseInt(request.getParameter("deparment_id")));
            complain.setSubject(request.getParameter("subject"));
            complain.setDescription(request.getParameter("description"));
            complain.setCustomer(new Customer(Integer.parseInt(request.getParameter("customer_id"))));
            complain.setDepartment(department);
            complain.setStatus(new ComplainStatus(1));
            comDAO.insert(complain);
            Mailer mail=new Mailer();
            mail.setTo(department.getEmail());
            mail.setFrom(SystemConstant.MAIL_FORM);
            mail.setSubject("Problem:" + complain.getSubject());
            mail.setBody(complain.getDescription());
            mail.send();
        } catch (Exception ex) {
            System.out.println("ex.getMessage");
        }
    }

}
