package za.co.mecer.organism.impl;

import za.co.mecer.organism.directions.Directions;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Organisms {

    void move(Organisms[][] org, Directions dir);

    void breed(Organisms[][] org);
}
