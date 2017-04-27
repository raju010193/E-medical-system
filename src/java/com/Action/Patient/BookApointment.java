/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action.Patient;

import com.Beans.FormBeans;
import com.DAO.PatientDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pavan
 */
public class BookApointment extends HttpServlet {

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
       String patientName=request.getParameter("pname");
       int patientAge=Integer.parseInt(request.getParameter("page"));
       String department=request.getParameter("department");
       String gender=request.getParameter("gender");
       String slotdate=request.getParameter("date");
       String hh=request.getParameter("time");
       String min=request.getParameter("min");
       String ampm=request.getParameter("ampm");
       slotdate+=" "+hh+":"+min+" "+ampm;
       String problem=request.getParameter("problem");
       
       HttpSession session=request.getSession();
       
       String uname=(String)session.getAttribute("userName");
       FormBeans beans=new FormBeans();
       
       beans.setPatientName(patientName);
       beans.setPatientAge(patientAge);
       beans.setPatientDepartment(department);
       beans.setPatientGender(gender);
       beans.setProblemType(problem);
       beans.setBookDate(slotdate);
       
       boolean bookSlot=new PatientDao().BookSlot(beans,uname);
       
       String path="";
       if(bookSlot){
           
           ArrayList<FormBeans> history=new PatientDao().AppointmentHistory(uname);
           if(!history.isEmpty()){
               
               request.setAttribute("patientMessage", "Slot Booking Successfull!!");
               request.setAttribute("history", history);
               path="./patientHistory.jsp";
               
           }else{
                  request.setAttribute("patientMessage", "Booking Histroy is not available!!");
             
               path="./patientHistory.jsp";
           }
           
       }else{
           request.setAttribute("patientMessage", "Slot is Not available on that Date !!");
           path="./patientHistory.jsp";
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
