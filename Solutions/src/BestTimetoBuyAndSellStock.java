
public class BestTimetoBuyAndSellStock {
  /*
   * Suppose we have original array: [a0, a1, a2, a3, a4, a5, a6]
   * 
   * what we are given here(or we calculate ourselves) is: [b0, b1, b2, b3, b4, b5, b6]
   * 
   * where, b[i] = 0, when i == 0 b[i] = a[i] - a[i - 1], when i != 0
   * 
   * suppose if a2 and a6 are the points that give us the max difference (a2 < a6) then in our given
   * array, we need to find the sum of sub array from b3 to b6.
   * 
   * b3 = a3 - a2 b4 = a4 - a3 b5 = a5 - a4 b6 = a6 - a5
   * 
   * adding all these, all the middle terms will cancel out except two i.e.
   * 
   * b3 + b4 + b5 + b6 = a6 - a2
   * 
   * a6 - a2 is the required solution.
   * 
   * so we need to find the largest sub array sum to get the most profit
   */
  // Using Kadane's
  public int maxProfit(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for (int i = 1; i < prices.length; i++) {
      maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
      maxSoFar = Math.max(maxCur, maxSoFar);
    }
    return maxSoFar;
  }

  /*
   * Iterate at each i, determine if it is the lowest point to buy
   * If it is, update
   * Else determine profit to sell stock at this point comparing the min_to_buy
   */
  public int maxProfitSimple(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    int min_to_buy = Integer.MAX_VALUE;
    int max_profit = 0;

    for (int i = 0; i < prices.length ; i++) {
      int buyPrice = prices[i];
      if (buyPrice <= min_to_buy) {
          min_to_buy = buyPrice;
      } else {
          int profit = 0 - min_to_buy + prices[i];
          max_profit = Math.max(profit, max_profit);
      }
      
  }
    return max_profit;
  }

}
