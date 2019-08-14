import java.util.*;

public class Fibonacci {

  /*
   * Dynamic Programming Solution
   *  Time-Complexity: O(n)
   */

  public static int fibonacci(int n) {
    int[] dp = new int[n + 2]; // to handle n and 0 case
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 2] + dp[i - 1];
    }
    return dp[n];
    // Complete the function.
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();
    System.out.println(fibonacci(n));
  }
}

