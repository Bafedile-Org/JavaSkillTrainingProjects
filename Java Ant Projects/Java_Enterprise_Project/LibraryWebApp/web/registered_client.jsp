<%-- 
    Document   : registered_client
    Created on : Oct 23, 2022, 10:42:35 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registered Client Page</title>
        <link rel="stylesheet" href="css/style.css">
        <script src='js/script.js'></script>
    </head>
    <body>
        <header>
            <h1 align='center'>DM LIBRARY</h1>
        </header>
        <div  align='center'>
            <form id='form' method="POST" action='client'  >
                <h3>Registered Client</h3>
                <div>
                    <label>Firstname</label>
                    <input type='text' placeholder="Enter your firstname" name='firstname'>
                </div><br>
                <div>
                    <label>Lastname</label>
                    <input type='text' placeholder="Enter your lastname" name='lastname'>
                </div><br>
                <div>
                    <label>Identity Number</label>
                    <input type='text' placeholder="Enter your identity number" name='identityNum' minlength="13" maxlength="13">
                </div><br>
                <div>
                    <input type='submit' name='registerClient' value='Loan book'>
                    <input type='button'  value='Register Client' onclick='loanBook()'>
                </div>
            </form></div>
    </body>
</html>
