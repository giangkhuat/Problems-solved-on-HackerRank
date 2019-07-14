import java.io.*;
import java.util.*;

public class MaxSumSubarray {

  // Referencing Kadane's algorithm
  /*
   * Idea: store solutions for problem of size i-2 and i-1, where i is the size of the subproblem.
   *  *If i = 0, the largest sum of subarary so far is a[0] 
   *  * If i = 1, max subarray sum = max(arr[1],
   * dp[0] * i > 1, max sum is either solution for problem i-1, or solution for problem i-2, or
   * solution of problem i-2 + arr[i], or ar[i].
   */
  static int maxSubsetSum(int[] arr) {
    // dp is the array containing maximum sum of subarrays up until arr[i]
    int[] dp = new int[arr.length];
    // i = 0, the max sum so far is a[0] itself
    dp[0] = arr[0];
    dp[1] = Math.max(arr[1], dp[0]);
    for (int i = 2; i < arr.length; i++) {
      // no need to include dp[i- 2] here because if dp[i-2] < dp[i-1], then dp[i-1] would be
      // enough to find max
      dp[i] = Math.max(Math.max(arr[i], arr[i] + dp[i - 2]), dp[i - 1]);
    }
    // when we reach the end, max sum subarray will be pushed to the end
    return dp[arr.length - 1];
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = maxSubsetSum(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
