/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rewbuglag
 */
public class ServletMethod extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print("<!DOCTYPE html><html><head>");
            out.print("<title>Exploring Servlet Methods</title>");
            out.print("</head><body>");
            out.printf("<h1>%s</h1><ul>", getServletInfo());
            out.printf("<li>Servlet Name : %s</li>", getServletName());
            out.print("<li>Servlet's init parameter: <ul>");
            Enumeration<String> params = getInitParameterNames();
            while (params.hasMoreElements()) {
                String paramName = params.nextElement();
                String paramValue = getInitParameter(paramName);
                out.printf("<li>Name: '%s' Value: '%s'</li>", paramName, paramValue);
            }
            out.print("</li></ul></ul></body></html>");
        }
        log("Serve: " + getServletInfo());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return String.format("This is a %s object; an instance of %s class.",
                getServletName(), getClass().getName());
    }// </editor-fold>

    @Override
    public void init() {
        log("Initialization: " + getServletInfo());
    }
}
