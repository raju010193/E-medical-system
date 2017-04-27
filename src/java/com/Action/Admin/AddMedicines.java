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
public class AddMedicines extends HttpServlet {

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
       //get the medicine data from html form 
        String mName=request.getParameter("mname");
        String mCompany=request.getParameter("mcompany");
        String hospitalBranch=request.getParameter("hbranch");
        String manufacturingDate=request.getParameter("mdate");
        String expireDate=request.getParameter("exdate");
        String lableName=request.getParameter("lname");
        
        //temparary store in 
        
        FormBeans beans=new FormBeans();
        beans.setMedicineName(mName);
        beans.setMedicineCompany(mCompany);
        beans.setHospitalBranch(hospitalBranch);
        beans.setManufacturingDate(manufacturingDate);
        beans.setExpireDate(expireDate);
        beans.setLableName(lableName);
        
        //call the database of dao layaer
        
        boolean flag=new AdminDao().addMedicine(beans);
        String path="";
        if(flag){
        request.setAttribute("adminMessage", "Medicine Added Successfully!!");
        
            ArrayList<FormBeans> requests = new AdminDao().PatientRequests();

            if (!requests.isEmpty()) {
                request.setAttribute("requests", requests);
                // response.sendRedirect("upload.jsp?status='uploded'");
                path = "./adminHome.jsp?name=?";
            } else {
                request.setAttribute("adminMessage", "Appointment Requests Not Found");
               
                path = "./adminHome.jsp?";
            }
        
        path="./adminHome.jsp";
        }else{
            request.setAttribute("adminMessage", "Operation Failed!!");
                ArrayList<FormBeans> requests = new AdminDao().PatientRequests();

            if (!requests.isEmpty()) {
                request.setAttribute("requests", requests);
                // response.sendRedirect("upload.jsp?status='uploded'");
                path = "./adminHome.jsp?name=?";
            } else {
                request.setAttribute("adminMessage", "Appointment Requests Not Found");
               
                path = "./adminHome.jsp?";
            }
            
            path="./adminHome.jsp";
        }
        RequestDispatcher dis=request.getRequestDispatcher(path);
        dis.include(request, response);
        
        
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
