package za.co.mecer.process;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dimakatso Sebatane
 */
public abstract class ProcessRequest {

    public abstract void processTheRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void sendResponse(HttpServletResponse response, String res) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            out.println(String.format("%s", res));
            out.flush();
        }
    }
}
