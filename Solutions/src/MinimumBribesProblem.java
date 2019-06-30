import java.math.*;
import java.util.*;

public class MinimumBribesProblem {

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {
    int len = q.length - 1, bribes = 0;
    // Iterate from end to beginning to avoid going through the whole array
    for (int i = len; i >= 0; i--) {
      // x is the difference between the label and its correct position
      int x = q[i] - (i + 1);
      // if x > 2, the person has bribed > 2 times
      if (x > 2) {
        System.out.println("Too chaotic");
        return;
      } else {
        /*
         * Else x < 0 or 0 < x < 2 Since no one can jump ahead of its original position by more than
         * 2, so any value higher than q[i] can only be till index q[i] -2. We start with that value
         * until current position If the number > num at current position => bribed Else move on
         */
        for (int j = Math.max(0, q[i] - 2); j < i; j++) {
          if (q[j] > q[i]) {
            bribes++;
          }
        }
      }
    }

    System.out.println(bribes);
    return;

  }

  private static final Scanner scanner = new Scanner(System.in);

  /* main function Taken from HackerRank website */
  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      minimumBribes(q);
    }

    scanner.close();
  }
}
