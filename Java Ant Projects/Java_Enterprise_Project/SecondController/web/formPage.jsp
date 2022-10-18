<%-- 
    Document   : formPage
    Created on : Oct 18, 2022, 3:08:38 AM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Form Page</title>
        <script src="js/main.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <form method="POST" action="results">
            <h1>Enter your details</h1>
            <p>Please fill in the form below to submit your unique identifiable details</p>
            <label>Firstname</label><br>
            <input type="text" name="firstname" placeholder="Enter your first name here"/><br><br>
            <label>Lastname</label><br>
            <input type="text" name="lastname" placeholder="Enter your last name here"/><br><br>
            <label>Age</label><br>
            <input type="number" name="age" placeholder="Enter your age here"/><br><br>
            <label>Select your gender</label><br>

            <label>Male</label>
            <input type="radio" name="gender" value="male"><label>Female</label>
            <input type="radio" name="gender" value="female"><br><br>
            <input type="submit" name="button"value="submit"/>
            <input type="button" name="back" onclick="goToHome()" value="home"/>
        </form><br>

    </body>
</html>
