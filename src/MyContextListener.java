/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPractice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rewbuglag
 */
@WebServlet(name = "MyContextListener", urlPatterns = {"/MyContextListener"})
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("emf", "MyObject");
        context.setInitParameter("test", "initparameter");
        context.log("add attribute emf");
//        ServletContextListener.super.contextInitialized(sce); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
//        ServletContextListener.super.contextDestroyed(sce); //To change body of generated methods, choose Tools | Templates.
    }
}
