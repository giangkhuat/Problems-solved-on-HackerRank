import java.io.*;
import java.util.Scanner;


public class MaximumInArrayAfterUpdates {
  
  /*
   * Time comlexity: O(n + m)
   * Space complexity: O(1)
   * 
   * Idea: Using prefix sum algorithm(https://stackoverflow.com/questions/56249944/array-manipulation-hackerrank-questions-java/56327605#56327605)
   *  Assume our original array: 
   *  Indices: 1   2    3   4   5
   *   A[i]    0   0    0   0   0
   * Query From indices 1->3 Add 5
   *   A[i]    5   5    5   0   0 
   * Calculate the differences between a[i] and a[i-1], we get the array
   *           5   0    0   - 5  0
   *  => This is why we add 5 and -5 on indices 1/begin and 4/end+1 to store the difference between numbers
   *  Apply prefix sum algorithm => Get the original array
   *  A[i]     5    5    5    0  0
   *  So using this principle, we store only k in indices a and -k in b+1
   *  to get the difference array, apply prefix sum algorithm we will get the original numbers
   */

  // Complete the arrayManipulation function below.
  static long arrayManipulation(int n, int[][] queries) {
    int len = queries.length;
    long[] arr = new long[n + 2];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = 0;
    }


    for (int i = 0; i < len; i++) {
      int[] query = queries[i];
      int a = query[0];
      int b = query[1];
      int k = query[2];
      arr[a] = arr[a] + k;
      if (b + 1 <= arr.length) {
        arr[b + 1] = arr[b + 1] - k;
      }
    }

    long max = arr[0];
    long x = 0;

    for (int i = 0; i < arr.length; i++) {
      x = x + arr[i];
      max = Math.max(x, max);
    }

    return max;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] queries = new int[m][3];

    for (int i = 0; i < m; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }

    long result = arrayManipulation(n, queries);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
