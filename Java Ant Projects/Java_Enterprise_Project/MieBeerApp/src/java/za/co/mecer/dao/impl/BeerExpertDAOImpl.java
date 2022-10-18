package za.co.mecer.dao.impl;

import java.util.ArrayList;
import java.util.List;
import za.co.mecer.dao.BeerExpertDAO;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BeerExpertDAOImpl implements BeerExpertDAO {

    @Override
    public List<String> getBrand(String colour) {
        List<String> brands = new ArrayList<>();
        switch (colour.toLowerCase()) {
            case "amber":
                brands.add("Jack Black");
                brands.add("CBC");
                brands.add("Lion");
                break;
            case "light":
                brands.add("Oros");
                brands.add("Stella Artois");
                brands.add("Windhoek");
                break;
            default:
                brands.add("Corona");
                brands.add("Black Label");
                brands.add("Castle");
        }

        return brands;
    }

}
