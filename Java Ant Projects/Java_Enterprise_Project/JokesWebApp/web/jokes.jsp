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
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h1>Have a laughter!!!</h1>
        <h2>Here are some good jokes</h2>
        <table>
            <tr>
                <td><b>Mom Jokes</b></td>
                <td><b>Dad Jokes</b></td>
                <td><b>Monkey Jokes</b></td>
            </tr>
            <tr>
                <td>Mom laughed</td>
                <td>Dad shit himself really hard</td>
                <td>Monkey stole the bananas</td>
            </tr>
            <%
                List<Joke> jokeList = (List<Joke>) request.getAttribute("jokeList");
                out.println("<tr>");

                for (int i = 0; i < jokeList.size(); i++) {
                    if (jokeList.get(i).getJoke() == null) {
                        out.println("<td> </td>");
                    } else {
                        out.println(String.format("<td>%s</td>", jokeList.get(i).getJoke()));
                    }
                    if (i != 0 && (i % 3 == 0)) {
                        out.println("</tr><tr>");
                    }
                }
                out.println("</tr>");

            %>


        </table>


        <br><a href="/jokes">Add jokes</a>
    </body>
</html>
