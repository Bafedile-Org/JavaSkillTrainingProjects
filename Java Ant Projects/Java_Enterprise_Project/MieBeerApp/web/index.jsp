<%-- 
    Document   : index
    Created on : 18 Oct 2022, 11:35:20 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beer Page</title>
    </head>
    <body>
        <h1 align='center'>Our Beer Selection Page</h1>
        <form method="POST" action="select_beer" align='center'>
            <p>Select Beer Characteristics</p>
            <p>
                Colour: <select name='colour'  size='1'>
                    <option >light</option>
                    <option >amber</option>
                    <option >brown</option>
                    <option >dark</option>
                </select>
            </p><br>
            <center>
                <input type='submit'>
            </center>
        </form>
    </body>
</html>
