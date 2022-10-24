package za.co.mecer.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.process.LoanLibraryProcess;

/**
 *
 * @author Dimakatso Sebatane
 */
@WebServlet("/loan")
public class LibraryLoanController extends LibraryController {

    String identityNum;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        request.setAttribute("identityNum", identityNum);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("bookLoan");
        try {
            if (request.getParameter("submit").equalsIgnoreCase("submit")) {
                response.sendRedirect("bookLoan");
//                dispatcher.forward(request, response);
                identityNum = request.getParameter("identityNum");

            } else {
                LoanLibraryProcess process = RequestActionFactory.createRequestAction();
                process.processLoanRequest(request, response, identityNum);
            }

        } catch (LoanException ioe) {

        }
    }

    abstract static class RequestActionFactory {

        public static LoanLibraryProcess createRequestAction() {
            return new LoanLibraryProcess();
        }
    }

}
