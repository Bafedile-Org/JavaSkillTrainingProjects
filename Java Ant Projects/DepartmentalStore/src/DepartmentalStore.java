
import java.util.ArrayList;
import java.util.Scanner;
import za.co.mecer.StockItem;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class DepartmentalStore {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new DepartmentalStore().run();

    }

    private void run() {
        int choice, stockNum;
        String itemName, itemNameRep;
        double itemPrice;
        ArrayList<StockItem> stock = new ArrayList<>();
        
        stock.add(new StockItem("Milk", 24, 19.5));
        stock.add(new StockItem("Bread", 9, 15.00));
        stock.add(new StockItem("Fruit-Juice", 14, 12.5));
        
        
        
        stock.add(new StockItem("Cooking-Oil", 33, 99.99));
        stock.add(new StockItem("Corned-Meat", 17, 24.99));

        do {
            choice = getChoice(); // get the choice of the user 

            switch (choice) {
                case 1:
                    System.out.printf("The number of items in the stock list is: %d%n", stock.size());
                    break;
                case 2:
                    itemName = getItemName();
                    checkItem(itemName, stock);
                    break;
                case 3:
                    itemName = getItemName();
                    itemNameRep = getReplaceItemName();
                    itemPrice = getItemPrice();
                    stockNum = getStockNum();
                    StockItem newStockItem = new StockItem(itemNameRep, stockNum, itemPrice);
                    
                    replaceItem(newStockItem, itemName, stock);
                    break;
                case 4:
                    displayStockItems(stock);

                default:
                    break;

            }
        } while (choice != 4);

    }

    private int getChoice() {

        int choice = 0;
        do {
            System.out.print("Please choose from the below\n"
                    + "1 Fetch the current number of items in the stock list\n"
                    + "2 Check for a particular item in the list\n"
                    + "3 Replace an item in the list\n"
                    + "4 Display the Items\n"
                    + "5 Exit the program\n"
                    + "Your choice: ");
            choice = input.nextInt();
            if (choice == 5) {
                System.out.printf("%n---------------------------------------------%n"
                        + "Thank you for using our application!!"
                        + "%n---------------------------------------------%n");
                break;
            }

        } while (choice < 1 && choice > 4);
        return choice;
    }

    private String getItemName() {

        String itemName;

        System.out.print("Please enter the name of the item: ");
        itemName = input.next();
        return itemName;

    }

    private String getReplaceItemName() {
        String itemName;

        System.out.print("Please enter the name of the item to replace with: ");
        itemName = input.next();
        return itemName;
    }

    private double getItemPrice() {
        System.out.print("Please enter the price of the item: ");
        double itemPrice = input.nextDouble();

        return itemPrice;
    }

    private int getStockNum() {
        System.out.print("Please enter the number of  available items in the stock:  ");
        int stockNum = input.nextInt();

        return stockNum;
    }

    private void checkItem(String itemName, ArrayList<StockItem> stock) {
        for (StockItem stockItem : stock) {
            if (stockItem.getItemName().equalsIgnoreCase(itemName)) {
                System.out.printf("%nItem %s found at index: %d%n%n", itemName, stock.indexOf(stockItem));
            }
        }

    }

    private void replaceItem(StockItem stockItem, String itemName, ArrayList<StockItem> stock) {
        for (StockItem item : stock) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                stock.set(stock.indexOf(item), stockItem);

            }
        }
    }

    private void displayStockItems(ArrayList<StockItem> stock) {
        StockItem stocks[] = new StockItem[stock.size()];
        stocks = stock.toArray(stocks);
//        for (int i = 0; i < stocks.length; i++) {
//            stocks[i] = stock.get(i);
//        }
        System.out.println("\n------------------------------------------------\n");
        for (StockItem item : stocks) {
            System.out.println(item);
        }
    }

}
