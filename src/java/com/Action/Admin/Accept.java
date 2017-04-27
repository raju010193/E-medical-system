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
public class Accept extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Accept</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Accept at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

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
      int id=Integer.parseInt(request.getParameter("id"));
      System.out.print("=====");
      boolean accept=new AdminDao().AcceptRequest(id);
      String path="";
      if(accept){
           ArrayList<FormBeans> requests = new AdminDao().PatientRequests();

            if (!requests.isEmpty()) {
                request.setAttribute("requests", requests);
                path = "./adminHome.jsp";
            } else {
                request.setAttribute("adminMessage", "Appointment Requests Not Found");
               
                path = "./adminHome.jsp";
            }
      }else{
          request.setAttribute("adminMessage", "Appointment Requests Accepting Failed");
               
                path = "./adminHome.jsp"; 
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
