<%-- 
    Document   : register
    Created on : Oct 24, 2015, 12:44:03 PM
    Author     : NIKHIL
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    if("POST".equalsIgnoreCase(request.getMethod()))
    {
        if(request.getParameter("register")!=null)
        {
            if(request.getParameter("register").equals("Register"))
            {
                String name= request.getParameter("nameReg");
                String email= request.getParameter("emailReg");
                String securityQues= request.getParameter("secReg");
                String password=request.getParameter("passReg");
                String repassword= request.getParameter("repassReg");
                
                if((!name.isEmpty()) && (!email.isEmpty()) && (!securityQues.isEmpty()) && (!password.isEmpty()) && (!repassword.isEmpty()))
                {
                    if(password.equals(repassword))
                    {
                        Connection con = null;
                        PreparedStatement ps;
                        ResultSet rs;
                        String query;
                        
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        try
                        {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex3.3?zeroDateTimeBehavior=convertToNull","root","");
                            query = "insert into userinfo (name,email,security,password) values (?,?,?,?)";
                            ps = con.prepareStatement(query);
                            ps.setString(1,name);
                            ps.setString(2,email);
                            ps.setString(3,securityQues);
                            ps.setString(4,password);
                            
                            ps.executeUpdate();
                            
                            session = request.getSession();
                            session.setAttribute("userEmail", email);
                            response.sendRedirect("dashboard.jsp");
                                    
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                    }
                }
            }
        }
    }
    
    
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
    </head>
    <body>
        <form action="" method="post">
            <input type="text" name="nameReg" placeholder="Enter your Name" size="50">
            <br><br>
            <input type="text" name="emailReg" placeholder="Enter your Email" size="50">
            <br><br>
            <input type="text" name="secReg" placeholder="In which city you were born??" size="50">
            <br><br>
            <input type="password" name="passReg" placeholder="Enter your Password" size="50">
            <br><br>
            <input type="password" name="repassReg" placeholder="Re-Enter your Password" size="50">
            <br><br>
            <input type="submit" name="register" value="Register">
        </form>
    </body>
</html>
