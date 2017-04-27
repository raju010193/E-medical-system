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
public class Medicines extends HttpServlet {

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
        String path = "";
        HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("userName");
        try {
            ArrayList<FormBeans> medicine = new PatientDao().Medicines(userName);

            if (!medicine.isEmpty()) {
                request.setAttribute("medicine", medicine);
                path = "./patientMedicine.jsp";
            } else {
                request.setAttribute("patientMessage", "Medicine Records not Found");
                ArrayList<FormBeans> profile = new PatientDao().Profile(userName);

                if (!profile.isEmpty()) {
                    request.setAttribute("profile", profile);
                    path = "./patientHome.jsp";
                } else {
                    request.setAttribute("patientMessage", "No Records Found");
                    path = "./patientHome.jsp";
                }
                path = "./patientHome.jsp";
            }
        } catch (Exception e) {
            request.setAttribute("patientMessage", "No Records Found");
            path = "./patientHome.jsp";
            e.printStackTrace();
        }
        RequestDispatcher dis = request.getRequestDispatcher(path);
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
