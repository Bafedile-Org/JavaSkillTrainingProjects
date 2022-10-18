package za.co.mecer.process.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.process.ProcessRequest;
import za.co.mecer.service.BeerExpert;
import za.co.mecer.service.impl.BeerExpertImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProcessRequestImpl extends ProcessRequest {

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeerExpert beerExpert = new BeerExpertImpl();
        String selColour = request.getParameter("colour");
        List<String> beerList = beerExpert.getBrand(selColour);
        request.setAttribute("styles", beerList);
        RequestDispatcher view = request.getRequestDispatcher("suggest");
        view.forward(request, response);
    }

}
