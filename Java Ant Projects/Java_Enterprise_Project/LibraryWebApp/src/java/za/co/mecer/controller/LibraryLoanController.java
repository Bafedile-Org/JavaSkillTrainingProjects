package za.co.mecer.controller;

import java.io.IOException;
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

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            LoanLibraryProcess process = RequestActionFactory.createRequestAction();
            process.processLoanRequest(request, response);

        } catch (LoanException ioe) {

        }
    }

    abstract static class RequestActionFactory {

        public static LoanLibraryProcess createRequestAction() {
            return new LoanLibraryProcess();
        }
    }

}
