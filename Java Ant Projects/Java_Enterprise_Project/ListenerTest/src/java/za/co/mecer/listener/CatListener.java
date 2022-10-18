package za.co.mecer.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import za.co.mecer.Cat;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CatListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
//        Cat cat = new Cat("Norweign Forest");
        Cat cat = new Cat(servletContext.getInitParameter("catbreed"));
        servletContext.setAttribute("kat", cat);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
