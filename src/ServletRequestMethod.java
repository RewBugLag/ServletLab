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
public class ServletRequestMethod extends HttpServlet {

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
            out.print("<title>Exploring HttpServletRequest Methods</title>");
            out.print("</head><body>");
            out.print("<h1>HttpServletRequest object</h1><ul>");
            out.printf("<li>RequestURL: %s</li>", request.getRequestURL());
            out.printf("<li>Scheme: %s</li>", request.getScheme());
            out.printf("<li>Server Name: %s</li>", request.getServerName());
            out.printf("<li>Server Port: %s</li>", request.getServerPort());
            out.printf("<li>RequestURI: %s</li>", request.getRequestURI());
            out.printf("<li>Context Path: %s</li>", request.getContextPath());
            out.printf("<li><b>Servlet Path: %s</b></li>", request.getServletPath());
            out.printf("<li><b>Path Info: %s</b></li>", request.getPathInfo());
            out.printf("<li>Method: %s</li>", request.getMethod());
            out.printf("<li>Query String: %s</li>", request.getQueryString());
            out.print("<li>Form Parameters:<ul>");
            Enumeration<String> formParams = request.getParameterNames();
            while (formParams.hasMoreElements()) {
                String name = formParams.nextElement();
                out.printf("<li>\"%s\" = ", name);
                for (String parameterValue : request.getParameterValues(name)) {
                    out.printf("\"%s\" ", parameterValue);
                }
                out.print("</li>");
            }
            out.print("</ul></li></ul>End</body></html>");
        }
        log("Servlet request methods: " + getServletName());
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
        return "Short description";
    }// </editor-fold>

}
