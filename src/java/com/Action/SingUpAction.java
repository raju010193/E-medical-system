/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action;

import com.Beans.FormBeans;
import com.DAO.DataAccess;
import com.sun.faces.facelets.tag.jsf.core.LoadBundleHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pavan
 */
public class SingUpAction extends HttpServlet {

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
        System.out.println("========");
       String fname=request.getParameter("fname");
       String uname=request.getParameter("uname");
       String password=request.getParameter("psw");
       long mobile=Long.parseLong(request.getParameter("mobile"));
       String gender=request.getParameter("gender");
       int age=Integer.parseInt(request.getParameter("age"));
       String email=request.getParameter("email");
       FormBeans beans=new FormBeans();
       beans.setFname(fname);
       beans.setUname(uname);
       beans.setEmail(email);
       beans.setGender(gender);
       beans.setAge(age);
       beans.setMobile(mobile);
       beans.setPassword(password);
       
       String path="";
       
       try{
           boolean flag=new DataAccess().SingUp(beans);
           if(flag){
               request.setAttribute("signUp", "Registration Successfull...");
               path="./index.jsp";
           }else{
                request.setAttribute("signUp", "Already User Name Exists");
               path="./index.jsp";
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       RequestDispatcher res=request.getRequestDispatcher(path);
       res.forward(request, response);
               
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
