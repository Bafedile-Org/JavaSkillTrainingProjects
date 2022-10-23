<%-- 
    Document   : books_library
    Created on : Oct 22, 2022, 10:03:52 PM
    Author     : Dimakatso Sebatane
--%>

<%@page import="za.co.mecer.modelImpl.AuthorBook"%>
<%@page import="za.co.mecer.modelImpl.Author"%>
<%@page import="java.util.List"%>
<%@page import="za.co.mecer.modelImpl.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Page</title>
        <link rel="stylesheet" href='css/style.css'>
        <script src='js/script.js'></script>
    </head>

    <body>
        <header>
            <h1 align='center'>DM LIBRARY</h1>
        </header>
        <h1 align='center'>Available Books</h1>
        <div>
            <table align='center' id='books_table'>
                <tr>
                    <td><strong>Author</strong></td>
                    <td><strong>Book Title</strong></td>
                </tr>
                <%
                    List<AuthorBook> bookList = (List<AuthorBook>) request.getAttribute("books");
                    for (AuthorBook book : bookList) {
                        out.println(String.format("<tr><td>%s</td><td>%s</td></tr>", book.getAuthor().getName(), book.getBook().getTitle()));
                    }
                %>
            </table>
        </div>
        <div id="btn">
            <input type='button' onclick='loanBook()'  value='Loan a book'>
        </div>
    </body>
</html>
