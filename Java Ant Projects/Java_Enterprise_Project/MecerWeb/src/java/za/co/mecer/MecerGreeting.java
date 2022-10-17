package za.co.mecer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MecerGreeting extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        System.out.println(String.format("The Local Port is: %d%n", req.getLocalPort()));
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
//        pw.println("<html>");
//        pw.println("<head>");
//        pw.println("<title>MIE Greeting");
//        pw.println("</title>");
//        pw.println("</head>");
//        pw.println("<body>");
//        pw.println("<center><h1>One mug of delicious MIE coffee please</h1><center>");
//        pw.println("</body>");
//        pw.println("</html>");
        pw.println("<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>MIE Greeting</title>\n"
                + "        <link rel=\"stylesheet\" href=\"style.css\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "     <h1>One mug of delicious MIE coffee please</h1>\n"
                + "     <p> <strong>Java Enterprise is used to create responsive web applications</strong></p>\n"
                + "     <h2>More Of  Java Enterprise</h2>\n"
                + "     <p>Jakarta EE, formerly Java Platform, Enterprise Edition and Java 2 Platform,"
                + "     <br> Enterprise Edition, is a set of specifications, extending Java SE with specifications<br>"
                + "         for enterprise features such as distributed computing and web services.</p>\n"
                + "     <a href=\"index.jsp\">HomePage</a>"
                + "    </body>\n"
                + "</html>");
        pw.close();
    }

}
