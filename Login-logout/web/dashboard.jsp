<%-- 
    Document   : dashboard
    Created on : Oct 24, 2015, 12:44:25 PM
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

    session = request.getSession(false);
    if(session.getAttribute("userEmail")!=null)
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
            query = "select * from userinfo where email=?";
            ps = con.prepareStatement(query);
            String emailFromSession = session.getAttribute("userEmail").toString();
            ps.setString(1,emailFromSession);
            rs = ps.executeQuery();
            if(rs.next())
            {
                out.println("Welcome, "+rs.getString("name")+"!!!");
                out.println("<br><br> Session created for you...<br><br>");
                
                int indexOfatTheRate = emailFromSession.indexOf('@');
                
                boolean cookieCheck=false;
                Cookie ck[] = request.getCookies();
                for(int i=0;i<ck.length;i++)
                {
                    if(ck[i].getName().equals("CurrentCity"+emailFromSession.substring(0,indexOfatTheRate)))
                    {
                        out.println("Your Current City is - "+ck[i].getValue()+"&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"changeCurrentCity.jsp\">Change City</a>");
                        cookieCheck = true;
                        break;
                    }
                }
                if(!cookieCheck)
                {
                    out.println("<form action=\"\" method=\"post\">");
                    out.println("<input type=\"text\" name=\"currentCity\" placeholder=\"Please, enter your Current City\" size=\"50\">"
                            + "&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"submit\" name=\"cookieSubmit\" value=\"Submit\">");
                    out.println("</form>");
                    if("POST".equalsIgnoreCase(request.getMethod()))
                    {
                        if(request.getParameter("cookieSubmit")!=null)
                        {
                            if(request.getParameter("cookieSubmit").equals("Submit"))
                            {
                                Cookie cookie = new Cookie("CurrentCity"+emailFromSession.substring(0,indexOfatTheRate),request.getParameter("currentCity"));
                                cookie.setMaxAge(10000);
                                response.addCookie(cookie);
                                response.sendRedirect("dashboard.jsp");
                            }
                        }
                    }
                    
                }
                
                //Creating Logout button...
                
                out.println("<br><br>"
                        + "<form action=\"logout.jsp\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"logout\" value=\"Logout\">");
                out.println("</form>");
                
                out.println("<br><br><a href=\"changePassword.jsp?uemail="+session.getAttribute("userEmail").toString()+"\"> Change Password </a>");
            }
            
                    
            
                    
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
               
    }
    
    if("POST".equalsIgnoreCase(request.getMethod()))
    {
        if(request.getParameter("login")!=null)
        {
            if(request.getParameter("login").equals("Login"))
            {
                String email = request.getParameter("emailLogin");
                String password = request.getParameter("passLogin");
                
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
                    query = "Select * from userinfo where email=? and password=?";
                    ps = con.prepareStatement(query);
                    ps.setString(1,email);
                    ps.setString(2,password);
                    rs = ps.executeQuery();
                    
                    if(rs.next())
                    {
                        //Login successful!
                        //Creating Session...
                        session = request.getSession();
                        session.setAttribute("userEmail", email);
                        response.sendRedirect("dashboard.jsp");
                    }
                    else
                    {
                        out.println("Invalid Email id or Password!!! Please ");
                        out.println("<a href=\"index.jsp\"> Try Again </a>");
                        
                    }
                    
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }
               
           }
        }
        else if (request.getParameter("registerLogin")!=null)
        {
            if(request.getParameter("registerLogin").equals("I'm New User"))
            {
                response.sendRedirect("register.jsp");
            }
        }
            
    }
    
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
    </body>
</html>
