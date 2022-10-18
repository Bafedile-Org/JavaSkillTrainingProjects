package za.co.mecer.process;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dimakatso Sebatane
 */
public class StartProcess extends ProcessRequest {

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        String firstName, lastName;
        int age;
        firstName = request.getParameter("firstname");
        lastName = request.getParameter("lastname");
        age = new Integer(request.getParameter("age"));

        sb.append(String.format("<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>JSP Page</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "<h1>Your User Details</h1> \n"
                + "<p>Welcome <strong> %s %s  aged  %s</strong> to java web applications development</p>\n"
                + "        <a href=\"../SecondController\">HomePage</a>\n"
                + "    </body>\n"
                + "</html>", firstName, lastName, age));
        sendResponse(response, sb.toString());
    }

}
