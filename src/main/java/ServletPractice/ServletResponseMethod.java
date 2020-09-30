/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPractice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rewbuglag
 */
public class ServletResponseMethod extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */
        String s = request.getPathInfo();
        switch (s == null ? "" : s) {
            case "/redirectAbsolute":
                response.sendRedirect("http://www.google.com");
                break;
            case "/redirectRelative1": // /servlets/response/redirectRelative1
                response.sendRedirect(request.getContextPath() + "/index.html");
                break;
            case "/redirectRelative2": // /servlets/response/redirectRelative2
                response.sendRedirect("../WEB-INF/web.xml");
                break; // fail because /WEB-INF is unreachable from outside
            case "/redirect/relative3": // /servlets/response/redirect/relative3
                response.sendRedirect("../../index.html");
                break;
            case "/redirect/relative4": // /servlets/response/redirect/relative4
                response.sendRedirect("../../error/redirect");
                break;
            case "/send400":
                response.sendError(400, "intentionally send 400");
                break;
            case "/send500":
                response.sendError(500, "intentionally send 500");
                break;
            case "/internalError":
                Object o = null; // This will throw NullPointerException,
                o.toString(); // which will result in StatusCode 500.
                break;
            case "/throwException": // This will result in StatusCode 500.
                throw new ServletException("intentionally throw exception");
            default:
                response.setContentType("text/html;charset=UTF-8");
        }
        try (PrintWriter out = response.getWriter()) {
            out.print("<!DOCTYPE html><html><head>");
            out.print("<title>Exploring HttpServletResponse Methods</title>");
            out.print("</head><body><h1>HttpServletResponse object</h1>");
            out.print(request.getRequestURL() + "</body></html>");
            log("serve: " + request.getRequestURL());
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
