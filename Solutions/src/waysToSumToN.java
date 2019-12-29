
public class waysToSumToN {
  

/*
 * Given total = 8 and k = 2, the number of different ways of represent 8 as the sum of integers between 1 and 2, inclusive, is 5 ways:

[1, 1, 1, 1, 1, 1, 1, 1]
[1, 1, 1, 1, 1, 1, 2]
[1, 1, 1, 1, 2, 2]
[1, 1, 2, 2, 2]
[2, 2, 2, 2]
Constrains:

1 <= total <= 1000
i <= k <= 100
 */
  
  public static void main(String[] args) throws Exception {
    
  }
  
  /*
   * Recursive solution:
   * total is 0. In which case an empty sum does it.

   * total < 0. In which case there is no way to do it.

   * The range of numbers we are considering is empty. In which case there is no way to do it.

In every other case we either reduce the size of our list, or else use the largest number of our list.
   */
  public static int countWays(total, lower, upper) {
    if (total < 0) {
      return 0;
    } else if (total == 0) {
      return 1;
    } else if (upper < lower) {
      return 0;
    } else {
      int countIncludingUpper = countWays(total - upper, lower, upper);
      int countExcludingUpper = countWays(total, lower, upper -1);
      return countIncludingUpper + countExlcudingUpper;
    }
  }
}
