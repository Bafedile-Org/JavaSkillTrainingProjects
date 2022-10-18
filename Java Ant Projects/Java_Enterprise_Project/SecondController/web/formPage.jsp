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
    </head>
    <body>
        <h1>Enter your details</h1>
        <p>Please fill in the form below to submit your unique identifiable details</p>
        <form method="GET" action="http://localhost:8080/SecondController/control">
            <label>Firstname</label><br>
            <input type="text" name="firstname" placeholder="Enter your first name here"/><br><br>
            <label>Lastname</label><br>
            <input type="text" name="lastname" placeholder="Enter your last name here"/><br><br>
            <label>Age</label><br>
            <input type="number" name="age" placeholder="Enter your age here"/><br><br>
            <label>Select your gender</label><br>
            <select name="gender" size="2" MULTIPLE>
                <option name="male" value="male">Male</option>
                <option name="female" value="female">Female</option>
            </select><br><br>
            <input type="submit" name="pro" value="submit"/>
            <input type="button" name="back" onclick="goToHome()" value="home"/>
        </form><br>
        
    </body>
</html>
