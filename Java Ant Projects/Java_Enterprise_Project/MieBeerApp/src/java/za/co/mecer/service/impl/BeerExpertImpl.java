package za.co.mecer.service.impl;

import java.util.List;
import za.co.mecer.dao.BeerExpertDAO;
import za.co.mecer.dao.impl.BeerExpertDAOImpl;
import za.co.mecer.service.BeerExpert;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BeerExpertImpl implements BeerExpert {

    private BeerExpertDAO beerExpertDao;

    public BeerExpertImpl() {
        beerExpertDao = new BeerExpertDAOImpl();
    }

    @Override
    public List<String> getBrand(String colour) {
        if (colour == null || colour.isEmpty()) {
            return null;
        }
        return beerExpertDao.getBrand(colour);
    }

}
