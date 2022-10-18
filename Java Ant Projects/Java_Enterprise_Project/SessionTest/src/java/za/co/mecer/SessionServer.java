package za.co.mecer;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SessionServer extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            String pageTitle = "A we see that you are NEW. Welcome";
            Integer numberOfVisits = (Integer) session.getAttribute("numOfVisits");

            if (numberOfVisits == null) {
                numberOfVisits = 0;
            } else {
                pageTitle = "WELCOME BACK";
                numberOfVisits += 1;
            }
            session.setAttribute("numOfVisits", numberOfVisits);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Showing Sessions</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(String.format("<h1 align='center'>%s</h1>"
                    + "<p>Number of visits is %d</p>"
                    + "<p align='center'>"
                    + "<hr />"
                    + "<br>"
                    + "<br>"
                    + "<table border='1'>"
                    + "<tr>"
                    + "<td align='right><font color='#663300'>"
                    + "<b>This is visit number: </b></font></td>"
                    + "<td align='left'><font color='#CC0033'><b>%d</b></font></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td align='right'><font color='#663300'><b>Your Session ID is: </b></font></td>"
                    + "<td align='left'><font color='#CC9933'><b>%s</b></font></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td align='right'><font color='#663300'><b>The date and time your session was created is: </b></font></td>"
                    + "<td align='left'><font color='#CC9933'><b>%s</b></font></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td align='right'><font color='#663300'>"
                    + "<b>The LAST date and time your session was accessed is: </b></font></td>"
                    + "<td align='left'><font color='#CC99CC'><b>"
                    + "%s</b></font></td>"
                    + "</tr>"
                    + "</table>"
                    + "<br>", pageTitle, numberOfVisits, numberOfVisits, session.getId(), new Date(session.getCreationTime()), new Date(session.getLastAccessedTime())));
            out.println("</body>");
            out.println("</html>");
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

}
