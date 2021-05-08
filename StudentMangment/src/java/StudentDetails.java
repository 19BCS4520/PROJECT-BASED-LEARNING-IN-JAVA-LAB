/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author dell
 */
@WebServlet(urlPatterns = {"/StudentDetails"})
public class StudentDetails extends HttpServlet {

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
           String reg=request.getParameter("reg");
           int n1=Integer.parseInt(request.getParameter("n1"));
           int n2=Integer.parseInt(request.getParameter("n2"));
            int n3=Integer.parseInt(request.getParameter("n3"));
            int n4=Integer.parseInt(request.getParameter("n1"));
            int n5=Integer.parseInt(request.getParameter("n1"));
            Connection con=null;
            Statement st=null;
            ResultSet rs=null;
            
            try
            {
            Class.forName("com.mysql.jdbc.Driver"); 

          
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?zeroDateTimeBehavior=convertToNull","root","");

          st=con.createStatement();  
          st.executeUpdate("insert into details values( '"+reg+"','"+n1+"','"+n2+"','"+n3+"','"+n4+"','"+n5+"')");
          System.out.println("Record inserted");
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentDetails at " + request.getContextPath() + "</h1>");
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
