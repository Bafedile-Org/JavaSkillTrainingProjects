package za.co.mecer.process;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.modelImpl.AuthorBook;
import za.co.mecer.serviceimpl.AuthorServiceImpl;
import za.co.mecer.services.AuthorService;

/**
 *
 * @author Dimakatso Sebatane
 */
//@WebServlet("/books")
public class BooksLibraryProcess {

    public void processGetBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AuthorService authorService = new AuthorServiceImpl();
            List<AuthorBook> authorBookList = authorService.getAuthorBooks();
            request.setAttribute("books", authorBookList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("bookLibrary");
            dispatcher.forward(request, response);
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        }
    }
}
