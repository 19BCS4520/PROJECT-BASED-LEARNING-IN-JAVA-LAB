<%-- 
    Document   : login
    Created on : May 9, 2021, 1:40:41 AM
    Author     : dell
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Registration JSP Page</h1>

   <%

       String uname=request.getParameter("txtName");

       String pass = request.getParameter("txtPass");

      



       try{

   Class.forName("com.mysql.jdbc.Driver");

   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?zeroDateTimeBehavior=convertToNull","root","");

   PreparedStatement stmt = con.prepareStatement("select Password from jsp where Name=?");

   stmt.setString(1, uname); 

   ResultSet rs = stmt.executeQuery();

   if(rs.next()){

       if(pass.equals(rs.getString(1)))

       {

           out.println("<h1>~~~ LOGIN SUCCESSFULLL ~~~ </h1>");

       }

       }

   else{

   out.println("<h1>User Name not exist !!!!!</h1>");

   %>

   <jsp:include page="Register.html" ></jsp:include>

       <%

   }

       }catch(Exception e){out.println(e);}

  %>

   
    </body>
</html>
