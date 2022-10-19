<%-- 
    Document   : index
    Created on : 18 Oct 2022, 2:09:12 PM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <title>Jokes Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h1>Wanna make others laugh???</h1>
        <h2>Add a joke!!!</h2>
        <form method='POST' action='process'>
            <label>Category</label><br>
            <select name='category' size='1'>
                <option>Dad_Jokes</option>
                <option>Mom_Jokes</option>
                <option>Monkey_Jokes</option>
            </select><br><br>
            <label>Enter a joke</label><br>
            <textarea name='text' name='joke'></textarea><br><br>
            <!--<input type='text' name='joke'><br><br>-->
            <input type='submit' name='submit' align='left' value='post_joke'>
            <input type='submit' name='submit' align='right' value='display_jokes'>
        </form>
    </body>
</html>
