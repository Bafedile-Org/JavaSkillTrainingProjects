package za.co.mecer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.process.ClientsLibraryProcess;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet("/loan")
public class LibraryLoanController extends LibraryController {
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("bookLoan");
    }
    
}
