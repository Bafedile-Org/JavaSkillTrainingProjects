<%-- 
    Document   : index
    Created on : 17 Oct 2022, 2:18:50 PM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="css/style.css">-->
    </head>
    <body>
        <h1>Enter the form to add</h1>
        <form method="GET" action="http://localhost:8080/controller/control">
            <label>Enter a number: </label>
            <input name="val" value="" placeholder="Enter only a digit"><br>
            <select  size="2" value="pro" name="pro" MULTIPLE>
                <option name="in" value="in" selected="">In</option>
                <option name="abc" value="abc" selected="">abc</option>
            </select>
            
            <input type="submit" value="submit" name="submit">
        </form>
    </body>
</html>
