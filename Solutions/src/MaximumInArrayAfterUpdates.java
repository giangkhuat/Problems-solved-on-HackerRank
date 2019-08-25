import java.io.*;
import java.util.Scanner;


public class MaximumInArrayAfterUpdates {

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
