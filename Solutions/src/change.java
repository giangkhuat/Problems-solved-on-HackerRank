import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
  
  
 static double[] floatNum = {50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
 static String[] strNum = {"Fifty Pounds", "Twenty Pounds", "Ten Pounds", "Five Pounds", "Two Pounds", "One Pound", "Fifty Pence", "Twenty Pence", "Ten Pence", "Five Pence", "Two Pence", "One Pence"};
  
  /**
   * Iterate through each line of input.
   */
  
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);

    try {
        double purchasePrice = Double.parseDouble(in.readLine());
        double cash = Double.parseDouble(in.readLine());
        Main.calculateChange(purchasePrice, cash);
    } catch (Exception e) {
        System.out.println(e);
    }
  }
    
    

  public static void calculateChange(double purchasePrice, double cash) {
    if (purchasePrice == cash) {
      System.out.println("Zero");
    } else if (purchasePrice < cash) {
      double change = cash - purchasePrice;     
      System.out.println(getMoneyMes(change));
    } else {
      System.out.println("ERROR");
    }
  }
    
     public static StringBuilder getMoneyMes(double change) {
      int i  = 0;
      StringBuilder mes = new StringBuilder();
      while (change > 0 && i < 12) {
       if (change >= floatNum[i]) {
        mes.append(strNum[i]);
         if (change > floatNum[i]) {
          mes.append(", ");
         }
        change = change - floatNum[i];
        change = (double) Math.round(change * 100) / 100D;   
       } else {
         i++;
       }
      }
        return mes;
    }   
    
      

}