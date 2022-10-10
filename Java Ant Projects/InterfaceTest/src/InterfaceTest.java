
import za.co.mecer.product.Product;
import static za.co.mecer.product.Product.msg;
import za.co.mecer.product.impl.Furniture;
import za.co.mecer.product.impl.Kitchenware;

/**
 * @author Dimakatso Bafedile Sebatane
 */
public class InterfaceTest {

    public static void main(String[] args) {
        new InterfaceTest().run();
    }

    private void run() {

        showProduct(new Furniture());
        System.out.println("=========================================");
        showProduct(new Kitchenware());
        msg();
    }

    private void showProduct(Product product) {
        System.out.printf("Product name: %s%n"
                + "Product price: %.2f%n"
                + "%s%n", product.getName(), product.getPrice(), product);
        product.hello();

    }

}
