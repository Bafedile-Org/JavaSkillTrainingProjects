<%-- 
    Document   : jokes
    Created on : 18 Oct 2022, 2:44:43 PM
    Author     : Dimakatso Sebatane
--%>

<%@page import="za.co.mecer.service.Jokes"%>
<%@page import="java.util.List"%>
<%@page import="za.co.mecer.joke.Joke"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hahahaha!!!</title>
    </head>
    <body>
        <h1>Have a laughter!!!</h1>
        <h2>Here are some good jokes</h2>
        <%
            List<Joke> jokeList = (List<Joke>)request.getAttribute("jokeList");
            for(Joke joke: jokeList){
                out.println(String.format("%s\t%s",joke.getCategory(),joke.getJoke()));
            }
            %>
    </body>
</html>
