package za.co.mecer.process;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dimakatso Sebatane
 */
public abstract class ProcessRequest {

    public abstract void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
