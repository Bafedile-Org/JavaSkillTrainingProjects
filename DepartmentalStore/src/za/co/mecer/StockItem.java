package za.co.mecer;

/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class StockItem{
    private String itemName;
    private int stockNum;
    private double itemPrice;
    
    public StockItem(){
        this("Notepad",23,15);
    }
    
    public StockItem(String itemName, int stockNum,double itemPrice){
        this.itemName = itemName;
        this.setStockNum(stockNum);
        this.setItemPrice(itemPrice);
        
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public void setStockNum(int stockNum){
        this.stockNum = stockNum;
    }
    
    public int getStockNum(){
        return stockNum;
    }
    
    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }
    
    public double getItemPrice(){
        return itemPrice;
    }
    @Override
    public String toString(){
        return String.format("%nItem Name: %s%n"
                + "Item Price: %.2f Each%n"
                + "Number Of Available Items: %d%n",itemName,itemPrice,stockNum);
    }
}
