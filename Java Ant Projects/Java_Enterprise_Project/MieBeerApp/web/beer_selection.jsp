<%-- 
    Document   : beer_selection
    Created on : 18 Oct 2022, 1:24:04 PM
    Author     : Dimakatso Sebatane
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beer Results</title>
    </head>
    <body>
        <h1 align='center' >Beer recommendations for you!</h1>
        <p>
            <%
                List<String> theStyles = (List)request.getAttribute("styles");
                for(String s: theStyles){
                    out.println(String.format("<br/>Try %s",s));
                }
                %>
        </p>
    </body>
</html>
