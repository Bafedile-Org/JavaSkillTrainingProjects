<%-- 
    Document   : index
    Created on : 24 Oct 2022, 10:57:55 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Input Form</title>
    </head>
    <body>
        <h1>Enter your details</h1>
        <form method='POST' action='res/joke/form'>
            <label>Name: </label><input type="text" name='name'><br>
            <label>Telephone Number:   </label><input type="text" name='tel'><br>
           <input type="submit" value='Enter your details'>

        </form>
    </body>
</html>