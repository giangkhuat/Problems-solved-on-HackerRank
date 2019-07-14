import java.io.*;
import java.util.*;


public class DynamicProgramCandiesProblem {

  // Work in Progress
  // Passed 11/17 test cases 
  // Failed cases due to large input (off by a few numbers)
  static long candies(int n, int[] arr) {
    long[] dp = new long[arr.length];
    long[] dp2 = new long[arr.length];
    long sum = 0;
    long tmp = dp[0];
    dp[0] = 1;
    
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > tmp) {
        dp[i] = dp[i - 1] + 1;
      } else {
        dp[i] = 1;
      }
      tmp = arr[i];
    }
    
    sum = dp[arr.length - 1];
    dp2[arr.length - 1] = 1;

    for (int i = arr.length - 2; i >= 0; i--) {
      if (arr[i] > arr[i + 1])
        dp2[i] = dp2[i + 1] + 1;
      else
        dp2[i] = 1;
      if (dp[i] > dp2[i]) {
        sum += dp[i];
      } else {
        sum += dp2[i];
      }
    }

    return sum;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
   
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int arrItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      arr[i] = arrItem;
    }

    long result = candies(n, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
