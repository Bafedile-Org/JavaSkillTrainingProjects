package za.co.mecer.impl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Individuals {

    public void setBloodGroup(String bloodGroup);

    public String getBloodGroup();

    public void setName(String name);

    public String getName();

    public default void setBloodGroupId(String bloodGroup) {
        int bloodId;
        switch (bloodGroup.toUpperCase()) {
            case "A":
                bloodId = 1;
                break;
            case "B":
                bloodId = 2;
                break;
            case "AB":
                bloodId = 3;
                break;
            default:
                bloodId = 4;

        }
    }

    public int getBloodGroupId();

}
