
public class VendingItem {
  
  private double price;
  private double change = 0.0;
  
  public VendingItem(double itemPrice) {
    this.price = itemPrice;
  }

  public double getPrice() {
    return price;
  }
  
  public double setChange(double changeReturn) {
    this.change = changeReturn;
  }
  

}
