<%-- 
    Document   : details
    Created on : Oct 18, 2022, 4:19:30 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <% String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String age = request.getParameter("age");
       
                 %> 
                 <a href="../SecondController">HomePage</a>
                 
                 <%
        out.println(String.format("<h1>Your User Details</h1>"
                + " <p>Welcome <strong> %s %s  aged  %s</strong> to java web applications development</p>",firstname,lastname,age));
        %> 
       
    </body>
</html>
