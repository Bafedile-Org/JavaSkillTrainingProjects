package za.co.mecer;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.joke.Joke;
import za.co.mecer.joke.JokeImpl;
import za.co.mecer.process.ProcessRequest;
import za.co.mecer.process.ProcessRequesting;
import za.co.mecer.service.Jokes;
import za.co.mecer.service.impl.JokesImpl;

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
        RequestDispatcher dispatcher;
        Joke jo = new JokeImpl();
        Jokes jokes = new JokesImpl();
        ProcessRequest processReq;

        if (category.isEmpty() || joke.isEmpty()) {
            dispatcher = request.getRequestDispatcher("jokes.jsp");
            dispatcher.forward(request, response);
        }

        if (request.getParameter("submit").equalsIgnoreCase("post_joke")) {
            jo.setCategory(category);
            jo.setJoke(joke);
            processReq = RequestActionFactory.createRequestAction(jo);
            if (processReq != null) {
                processReq.processRequest(request, response);
            }

        } else {
            List<Joke> jokeList = jokes.getJokes();
            request.setAttribute("jokeList", jokeList);
            dispatcher = request.getRequestDispatcher("display");
            dispatcher.forward(request, response);
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

        public static ProcessRequest createRequestAction(Joke joke) {
            if (joke != null) {
                return new ProcessRequesting(joke);
            }
            return null;
        }

    }
}
