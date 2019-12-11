import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
  // Set private so others can not change it
  private static double cashAvailable ;
  private static int itemsAvailable = 9;
 // private double amountPaid = 0.0;
  private static ArrayList<VendingItem> itemLst = new ArrayList<VendingItem>();
 // private VendingItem itemSelected = new VendingItem(0.0);
  
  
  /*
   * coinsAmount record the number of each kind of coins
   * coinsAmount[0]: number of 0.05
   * coinsAmount[1]: number of 0.10 
   * coinsAmount[2]: number of 0.25
   */
  private static int[] coinsAmount = new int[3];
  
  //Constructor
  public VendingMachine(Double cash) {
    // initialize with an amount of cash
    cashAvailable = cash;
  }
  
  /*
   * Function return number of items still available
   */
  public int getNumItemsAvailable() {
    return itemsAvailable;
  }
  
  /*
   * Function return cash amount available
   */
  public static Double getCashAvailavle() {
    return cashAvailable;
  }
  /*
   * Input: coinsAmount is an array of coins
   *
   */
 public static void insertCash(VendingItem item) {
   Scanner scan = new Scanner(System.in);
   boolean enough = false;
   double amountPaid = 0.0;
   
   // Asking the person to input cash until enough
   while (!enough) {
     double coin = scan.nextDouble();
     amountPaid = amountPaid + coin;
     if (item.getPrice() <= amountPaid) {
       enough = true;
     }
   }
   // Setting amount of change to return
   handleCash(item, amountPaid);
      
 }
 
 private static void handleCash(VendingItem item, double amountPaid) {
   double amountReturn = amountPaid - item.getPrice();
   
   // If there is cash to return
   if (amountReturn <= getCashAvailavle()) {
    item.setChange(amountReturn); 
    // call dispense Item and return amount of change
    dispenseItem(item);
    dispenseChange(amountReturn);
    cashAvailable = cashAvailable - amountReturn;
   } else {
     // else return all money for user but cashAvailbla does not change
     item.setChange(amountPaid);
     dispenseChange(amountPaid);
   }
  
}

 
 /*
  *      if (coin == 0.05) {
       coinsAmount[0]++;
     } else if (coin == 0.10) {
       coinsAmount[1]++;
     } else if (coin == 0.25) {
       coinsAmount[2]++;
     }
  */
 
 public static VendingItem dispenseItem(VendingItem dispenseItem) {
   itemsAvailable--;
   return dispenseItem;
 }
  
 /*
  * Function iterating through coinsAmount and choosing coins to return
  * Until amountReturn  = 0
  * Function return an array of 3 elements, 
  * arr[0]: number of 0.05
  * arr[1]: number of 0.01
  * arr[2]: number of 0.25 coins
  */
 public static int[] dispenseChange(double amountReturn) {  
   int arr[]= new int[3];
   for (int i = 0; i < 2; i++) {
     while (coinsAmount[i] != 0) {
       amountReturn = amountReturn - coinsAmount[i];
       arr[i]++;
     }
     if (amountReturn == 0) {
       break;
     }
   }
   return  arr;
 }
 /*
  * Workflow Maps: 
  * 
  * First present two options user, if user to decide to:
  *    * Select Item -> Check if there is available item 
  *           * If yes -> Insert Cash -> Check if cash is enough 
  *               * Check if cash available to return => dispense,
  *               * Else throw error out of money and return the money for user
  *      
  *           * Else, tell user no more items availble 
  *    * If user decided to put cash in first, 
  *           * check if item available when user select item
  *              * If not, tell user out of items
  *              * else allow user to select item and put cash in 
  *              * Repeat: 
  *                   Check if cash available to return => dispense,
  *                 * Else throw error out of money or out of items
  *  Dispense Item:
  *     * We need to return Item object 
  *     * Call dispense change if there is change
  *     * Decrease number of items available in the machine
  *     * 
  *  Dispense change: 
  *      * Decrease amount of change available to return inside cash machine
  *      * return number of change to return
  *      
  *  Program Implementation decisions:
  *  We assume this is one vending machine, one person order at a time
  *   -> one vendingItem object at a time -> no multi-thread
  *   -> item selected 
  *      
  */
  public static void main(String[] args) throws Exception {
    
    double cash = 500.0;
    int choice = 0;
    Scanner scan = new Scanner(System.in);
    
    // Initialize vending machine with cash
    VendingMachine machine = new VendingMachine(cash);
    // Initialize 9 item with prices
    initializeItems();
    
    System.out.println("Please choose 2 options below");
    System.out.println(" 1 . Select Item first");
    System.out.println(" 2. Put cash first");
    choice = scan.nextInt();
    
    // if user chose item first
    if (choice == 1) {
      if (itemsAvailable()) {
        // choose item by index 
        System.out.println("Please choose item number you want to select : 1 -> 9");
        choice = scan.nextInt();
        VendingItem itemSelected = itemsAvailable.get(i);
        // insertCash     
        insertCash(itemSelected);        
      } else {
       throw new Exception ("Sorry no more available items");
      }
    } else if (choice == 2) {
      // Else if they put cash first
      double amountPaid = 0.0;
      while (scan.hasNextDouble()) {
        double cashIn = scan.nextDouble();
        amountPaid  = amountPaid + cashIn;   
      }
      System.out.println("Please choose item number you want to select : 1 -> 9");
      choice = scan.nextInt();
      VendingItem itemSelected = itemsAvailable.get(i);
      handleCash(itemSelected, amountPaid);
    } else {
      throw new Exception (" Please choose one option");
    }
    
    
   
  }
  
  public static void initializeItems() {
    double k = 10.0;
    for (int i = 0; i < 9; i++) {
      itemLst.add(new VendingItem(Double.valueOf(k)));
      k = k + 5.0;
    }
  }
  
  public static boolean itemsAvailable() {
    return itemsAvailable > 0;
  }
  

}
