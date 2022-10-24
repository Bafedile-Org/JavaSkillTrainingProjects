package za.co.mecer.model;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Order {

    private String name;
    private String items;
    private String tel;
    private Integer orderid;

    public Order() {

    }

    public Order(Integer orderid, String name, String items, String tel) {
        this.name = name;
        this.items = items;
        this.tel = tel;
        this.orderid = orderid;
    }

    /**
     * @return the orderid
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n"
                + "Items: %s%n"
                + "Telephone: %s%n%n", name, items, tel);
    }
}
