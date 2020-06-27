import java.util.Arrays;

public class CoinChangeDynProg {
  /*
   * Backtrack method:
   */
  public static int coinChangeBackTrack(int[] coins, int amount) {
    return coinChangeRec(0, coins, amount);
  }
  
  public static int coinChangeRec(int index, int[] arr, int amount) {
    // base case if the amount is just right, we exhaust hte amount, no 
    // need for more coins
    if (amount == 0) {
      return 0;
    }
    // recursive case 
    /*
     * If index < len and amount > 0, keep trying all options
     */
    if (index < arr.length && amount > 0) {
      // calculate the maximum number of options (branches) you can have for this level
      // each branch will be the number of coins u want to use for arr[index]
      int maxCoinNum = amount/arr[index];
      int minCost = Integer.MAX_VALUE;
      // for each num of current coin we decide to use, we calculate the result (depth first)
      for (int numOfcoins = 0; numOfcoins <= maxCoinNum; numOfcoins++) {
        // if there still amount left
        if (amount >= numOfcoins*arr[index]) {
          // then we explore all options even with using other coins
          int res = coinChangeRec(index+1, arr, amount - numOfcoins*arr[index]);
          // if there is such a combination 
          if (res != -1) {
            // update local miNCost
            minCost = Math.min(minCost, res + numOfcoins);
          }
        }
      }
      // get global minCost at each root if no combination for all of those options, return -1
      return (minCost == Integer.MAX_VALUE) ? -1: minCost;
    }
    // else if reach the point amount < 0 or index out of bound
    return -1;
    
    
  }
  
  public static int dp( int[] coins, int amount) {
  
    int max = amount +1;
    int[] dp = new int[amount +1];
    Arrays.fill(dp, amount);
    // mem has two dimentions, first row is the amount 0 => amount
    // each row will be coins 1, 2, 5
    dp[0] = 0;
    for (int i = 1; i <= amount;i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          // it means we can use the current coin 
          dp[i] = Math.min(dp[i], dp[i - coins[j]] +1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount] ;
  }
  
  
  
  public static void main(String[] args) throws Exception {
    int [] arr = {1 , 2, 5};
    int amount = 11;
    
    
  //  System.out.println("Coins used = " + coinChangeBackTrack(arr, amount));
    System.out.println("Coins used = " + dp(arr, amount));
  }

}
