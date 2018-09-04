/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author niit
 */
@WebServlet(name = "NewServlet1", urlPatterns = {"/NewServlet1"})
public class NewServlet1 extends HttpServlet {

    @EJB
    EmpFacadeLocal empFacade;
    
    @Resource
    UserTransaction utx;
    
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
            out.println("<title>Servlet NewServlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet1 at " + request.getContextPath() + "</h1>");
            
            try
            {
                utx.begin();
                Emp e1=new Emp();
                e1.setEmpname("tousheef");
                e1.setSalary(2000.5);
                out.println("<br>No of records are"+empFacade.count());
                empFacade.create(e1);
                out.println("<br>record inserted");
                utx.commit();
                out.println("<br>No of records are"+empFacade.count());
                List<Emp> l=empFacade.findAll();
                for(Emp e2:l)
                {
                    out.println("<br>");
                    out.println(e2.getEmpid()+",");
                    out.println(e2.getEmpname()+",");
                    out.println(e2.getSalary());
                }
            }
            catch(Exception e)
            {
                out.println("Transactions are rollbacked");
                try {
                    utx.rollback();
                } catch (Exception ex) {}
                   
                    
            }
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
