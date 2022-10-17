package za.co.mecer.process;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ExampleProcess extends ProcessRequest {

    @Override
    public void processTheRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        String value = request.getParameter("val");
        int i = 0;
        try {
            i = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            sendResponse(response, String.format("Enter a digit"));
            return;
        }
        i += 2354;
        sb.append(String.format("<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>Answer Page</title>\n"
                + "        <!--<link rel=\"stylesheet\" href=\"css/style.css\">-->\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>The Answer</h1>\n"
                + "<p>%s</p>\n"
                + "<a href=\"../controller\">Homepage</a>"
                + "    </body>\n"
                + "</html>", String.format("{\"Ans\": \"%d\"}", i)));

        sendResponse(response, sb.toString());
    }

}
