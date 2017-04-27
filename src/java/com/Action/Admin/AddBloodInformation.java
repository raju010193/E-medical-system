/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action.Admin;

import com.Beans.FormBeans;
import com.DAO.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author pavan
 */
public class AddBloodInformation extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dname=request.getParameter("dname");
        int dage=Integer.parseInt(request.getParameter("dage"));
        String dob=request.getParameter("ddate");
        String group=request.getParameter("group");
        String email=request.getParameter("email");
        String city=request.getParameter("city");
        long mobile=Long.parseLong(request.getParameter("mobile"));
        String gender=request.getParameter("gender");
        System.out.println(city+" "+gender+" "+email);
        FormBeans beans=new FormBeans();
        
        beans.setDonorName(dname);
        beans.setDonorAge(dage);
        beans.setDonorCity(city);
        beans.setDonorEmail(email);
        beans.setDonorMobile(mobile);
        beans.setDonorGender(gender);
        beans.setDonorDateOfBirth(dob);
        beans.setGroup(group);
        
        boolean flag=new AdminDao().addBlood(beans);
        
        String path="";
        if(flag){
             ArrayList<FormBeans> requests = new AdminDao().PatientRequests();

            if (!requests.isEmpty()) {
                request.setAttribute("adminMessage", "Blood Group Information Added Successfull");
                request.setAttribute("requests", requests);
                // response.sendRedirect("upload.jsp?status='uploded'");
                path = "./adminHome.jsp?name=?";
            } else {
                request.setAttribute("adminMessage", "Appointment Requests Not Found");
               
                path = "./adminHome.jsp?";
            }
        }else{
             request.setAttribute("adminMessage", "Operation Failed!!");
             ArrayList<FormBeans> requests = new AdminDao().PatientRequests();

            if (!requests.isEmpty()) {
                request.setAttribute("requests", requests);
                // response.sendRedirect("upload.jsp?status='uploded'");
                path = "./adminHome.jsp";
            } else {
                request.setAttribute("adminMessage", "Appointment Requests Not Found");
               
                path = "./adminHome.jsp?";
            }
        }
        
        RequestDispatcher dis=request.getRequestDispatcher(path);
        dis.forward(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
