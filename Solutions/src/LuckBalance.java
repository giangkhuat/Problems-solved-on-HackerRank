import java.io.*;
import java.util.*;

public class LuckBalance {

  // Complete the luckBalance function below.
  static int luckBalance(int k, int[][] contests) {
    int maxLuck = 0, counter = 0;
    // Sort the array according to their luck in descending order ( so o2 comparing to o1)
    Arrays.sort(contests, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        int result = Integer.compare(o2[0], o1[0]);
        return result;
      }
    });

    for (int i = 0; i < contests.length; i++) {
      if (contests[i][1] == 0) {
        maxLuck = maxLuck + contests[i][0];
      } else {
        if (counter < k) {
          maxLuck = maxLuck + contests[i][0];
          counter++;
        } else {
          maxLuck = maxLuck - contests[i][0];
        }
      }
    }
    return maxLuck;
  }

  // Taken from HackerRank website
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[][] contests = new int[n][2];

    for (int i = 0; i < n; i++) {
      String[] contestsRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 2; j++) {
        int contestsItem = Integer.parseInt(contestsRowItems[j]);
        contests[i][j] = contestsItem;
      }
    }

    int result = luckBalance(k, contests);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}

