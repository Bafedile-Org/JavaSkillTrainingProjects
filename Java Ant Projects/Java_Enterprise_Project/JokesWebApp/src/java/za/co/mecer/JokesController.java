package za.co.mecer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.joke.Joke;
import za.co.mecer.joke.JokeImpl;
import za.co.mecer.process.ProcessGetRequest;
import za.co.mecer.process.ProcessPostRequest;
import za.co.mecer.process.ProcessRequest;

/**
 *
 * @author Dimakatso Sebatane
 */
public class JokesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String category = request.getParameter("category");
        String joke = request.getParameter("joke");
        Joke jo = new JokeImpl();
        ProcessRequest processReq;

        if (request.getParameter("submit").equalsIgnoreCase("post_joke")) {
            if (category.isEmpty() || joke.isEmpty()) {
                response.sendRedirect("/jokes");
                return;
            }
            jo.setCategory(category);
            jo.setJoke(joke);
            processReq = RequestActionFactory.createRequestPostAction(jo);
            if (processReq != null) {
                processReq.processRequest(request, response);
            }
        } else {
            processReq = RequestActionFactory.createRequestGetAction();
            processReq.processRequest(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";

    }// </editor-fold>

    abstract static class RequestActionFactory {

        public static ProcessRequest createRequestPostAction(Joke joke) {
            if (joke != null) {
                return new ProcessPostRequest(joke);
            }
            return null;
        }

        public static ProcessRequest createRequestGetAction() {
            return new ProcessGetRequest();
        }

    }
}
