/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rewbuglag
 */
public class ServletContextMethod extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletContextMethod</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletContextMethod at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        ServletContext context = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("<!DOCTYPE html><html><head>");
            out.print("<title>Exploring ServletContext Methods</title>");
            out.print("</head><body><h1>ServletContext object</h1><ul>");
            out.printf("<li>Server Info: %s</li>", context.getServerInfo());
            out.printf("<li>Servlet Context Path: %s</li>", context.getContextPath());
            out.printf("<li>Servlet Context Name: %s</li>",
                    context.getServletContextName());
            out.print("<li><b>List of Servlet Names</b> (with URL patterns)<ul>");
            for (String servletName : context.getServletRegistrations().keySet()) {
                out.printf("<li>\"%s\" : ", servletName);
                ServletRegistration reg = context.getServletRegistration(servletName);
                for (String mapping : reg.getMappings()) {
                    out.printf("\"%s\" ", mapping);
                }
            }
            out.print("</ul></li><li><b>Initialization Parameters</b><ul>");
            Enumeration<String> initParams = context.getInitParameterNames();
            while (initParams.hasMoreElements()) {
                String name = initParams.nextElement();
                out.printf("<li>\"%s\" = \"%s\"</li>",
                        name, context.getInitParameter(name));
            }
            out.print("</ul></li></ul>End</body></html>");
        }
        log("ServletContext methods: " + getServletName());
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
