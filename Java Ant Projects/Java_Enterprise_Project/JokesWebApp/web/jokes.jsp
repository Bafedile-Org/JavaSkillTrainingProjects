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
        <h1 align='center'>Have a laughter!!!</h1>
        <h2 align='center'>Here are some good jokes</h2>

        <div align='center'>
            <table id='jokes_table'>


                <%

                    if (request.getParameter("category").equalsIgnoreCase("Mom_jokes")) {
                        out.println("<tr> <th>Mom Jokes</th> </tr>");
                        List<Joke> momJokes = (List<Joke>) request.getAttribute("mom_jokes");
                        for (Joke joke : momJokes) {
                            out.println(String.format("<tr><td>%s</td>  </tr>", joke.getJoke()));
                        }
                    }
                %>

            </table>
            <table id='jokes_table'>


                <%     if (request.getParameter("category").equalsIgnoreCase("Dad_jokes")) {
                        out.println("<tr> <th>Dad Jokes</th></tr>");
                        List<Joke> dadJokes = (List<Joke>) request.getAttribute("dad_jokes");
                        for (Joke joke : dadJokes) {
                            out.println(String.format("<tr><td>%s</td>  </tr>", joke.getJoke()));
                        }
                    }
                %>
            </table>
            <table id='jokes_table'>


                <%     if (request.getParameter("category").equalsIgnoreCase("Monkey_jokes")) {
                        out.println("<tr><th>Monkey Jokes</th></tr>");
                        List<Joke> monkeyJokes = (List<Joke>) request.getAttribute("monkey_jokes");
                        for (Joke joke : monkeyJokes) {
                            out.println(String.format("<tr><td>%s</td></tr>", joke.getJoke()));
                        }
                    } 
                
                if (request.getParameter("category").equalsIgnoreCase("all_jokes")){
                        out.println("<tr> <th>Mom Jokes</th> </tr>");
                        List<Joke> momJokes = (List<Joke>) request.getAttribute("mom_jokes");
                        for (Joke joke : momJokes) {
                            out.println(String.format("<tr><td>%s</td>  </tr>", joke.getJoke()));
                        }

                        out.println("<tr> <th>Dad Jokes</th></tr>");
                        List<Joke> dadJokes = (List<Joke>) request.getAttribute("dad_jokes");
                        for (Joke joke : dadJokes) {
                            out.println(String.format("<tr><td>%s</td>  </tr>", joke.getJoke()));
                        }
                        out.println("<tr><th>Monkey Jokes</th></tr>");
                        List<Joke> monkeyJokes = (List<Joke>) request.getAttribute("monkey_jokes");
                        for (Joke joke : monkeyJokes) {
                            out.println(String.format("<tr><td>%s</td></tr>", joke.getJoke()));
                        }
                    }
                %>
            </table>
        </div>
        <div>
            <br/><a href="/jokes">Add jokes</a>
        </div>
    </body>
</html>
