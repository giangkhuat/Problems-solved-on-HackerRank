import java.io.*;
import java.util.*;

public class MaximizeMin {

  // Complete the maxMin function below.
  static int maxMin(int k, int[] arr) {
    int len = arr.length;
    Arrays.sort(arr);
    int unfairness = Integer.MAX_VALUE;
    // i stops at len - k because we need k elements after i
    for (int i = 0; i <= len - k; i++) {
      int tmp = arr[i + k - 1] - arr[i];
      if (tmp <= unfairness) {
        unfairness = tmp;
      }
    }
    return unfairness;
  }

  // Taken from HackerRank Website
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int k = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int arrItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      arr[i] = arrItem;
    }

    int result = maxMin(k, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
