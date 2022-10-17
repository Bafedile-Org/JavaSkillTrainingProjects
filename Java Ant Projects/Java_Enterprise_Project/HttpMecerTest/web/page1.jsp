<%-- 
    Document   : page1
    Created on : 17 Oct 2022, 1:04:51 PM
    Author     : Dimakatso Sebatane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mecer Http Test</title>
         <!--<link rel="stylesheet" href="css/style.css">-->
    </head>
    <body>
        <form  method="POST" action="http://localhost:8080/HttpMecerTest/firstpost">
            <label>Enter a name</label>
            <input name="field" value="" placeholder="Enter your name here"/><br><br>
            <label>Choose items below</label><br>
            <select size="2" name="list" MULTIPLE>
                <option name="listItem1"  value="item1" selected="">Item One</option>
                <option name="listItem2"  value="item2" selected="">Item Two</option>
                <option name="listItem3"  value="item3" selected="">Item Threeee</option>
            </select><br><br>
            <input type="submit" name="submit" value="submit"/>
        </form>
    </body>
</html>
