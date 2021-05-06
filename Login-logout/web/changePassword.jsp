<%-- 
    Document   : changePassword
    Created on : May 6, 2021, 8:19:25 PM
    Author     : dell
--%>


<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    if("POST".equalsIgnoreCase(request.getMethod()))
    {
        if(request.getParameter("changePwd")!=null)
        {
            if(request.getParameter("changePwd").equals("Change Password"))
            {
                String securityQuesFP = request.getParameter("securityFP");
                String passFP = request.getParameter("passFP");
                String repassFP = request.getParameter("repassFP");
                
                if((!securityQuesFP.isEmpty()) && (!passFP.isEmpty()) && (!repassFP.isEmpty()))
                {
                    if(passFP.equals(repassFP))
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
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex3.3?zeroDateTimeBehavior=convertToNull", "root","");
                            query = "select * from userinfo where security=? AND email=?";
                            ps = con.prepareStatement(query);
                            ps.setString(1, securityQuesFP);
                            ps.setString(2, request.getParameter("uemail"));
                            
                            rs = ps.executeQuery();
                            
                            if(rs.next())
                            {
                                query = "update userinfo set password=? where email=?";
                                ps = con.prepareStatement(query);
                                ps.setString(1,passFP);
                                ps.setString(2,request.getParameter("uemail"));
                                ps.executeUpdate();
                                out.println("<br> Password Changed Successfully... Please <a href=\"index.jsp\"> Click Here </a> to login... <br>");
                            }
                            else
                            {
                                out.println("Invalid Credentials provided!!!!");
                            }

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
        <title>Change Password</title>
    </head>
    <body>
        <form action="" method="post">
            <input type="text" name="securityFP" placeholder="In which city you were born??" size="50">
            <br><br>
            <input type="password" name="passFP" placeholder="Enter your new Password" size="50">
            <br><br>
            <input type="password" name="repassFP" placeholder="Re-Enter your new Password" size="50">
            <br><br>            
            <input type="submit" name="changePwd" value="Change Password">
        </form>
    </body>
</html>

