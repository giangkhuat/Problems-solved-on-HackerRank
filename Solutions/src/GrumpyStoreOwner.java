
public class GrumpyStoreOwner {
  
  /*
   * Leetcode Medium
   * Solution: O(n)
   */
  class Solution {


    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
      int sum = 0;
      for (int i = 0; i < customers.length; i++) {
        if (grumpy[i] == 0) {
          sum += customers[i];
        }
      }
      System.out.println("Satisfied cus" + sum);

      int maxSum = sum;
      for (int i = 0; i < X; i++) {
        if (grumpy[i] == 1) {
          sum += customers[i];
        }
      }

      System.out.println("Satisfied cus if starting at 0" + sum);
      if (sum > maxSum) {
        maxSum = sum;
      }
      int j = X;
      int i = 0;
      for (int k = 0; k < customers.length; k++) {
        System.out.print(customers[k] + "| ");
      }
      System.out.println();
      for (int k = 0; k < customers.length; k++) {
        System.out.print(grumpy[k] + "| ");
      }
      while (j < customers.length) {
        System.out.println("i = " + i + ", j + " + j);
        if (grumpy[j] == 1) {
          sum += customers[j];
          System.out.println(" Sum += customers[j]= " + sum);
        }
        if (grumpy[i] == 1) {
          sum -= customers[i];
          System.out.print(sum);
          System.out.println("Sum -= customers[i]= " + sum);
        }
        if (sum > maxSum) {
          maxSum = sum;
        }
        j++;
        i++;
      }
      return maxSum;
    }
  }

}
