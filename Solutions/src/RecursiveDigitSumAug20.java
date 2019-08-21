import java.io.*;
import java.util.*;

/*
 * The Solution below uses recursion and can be unnecessarily complicated
 * The solution can be implemented with O(1) time complexity using modular arithmetic
 *     * The Digit Sum of a Number to Base 10 is Equivalent to Its Remainder Upon Division by 9
 *     * Link Reference: http://applet-magic.com/digitsummod9.htm 
 * Constraints:
 *     * 1 <=n <= 10^100000
 *     * 1 <= k < 10^5
 * Since the numbers after concatenate k times are likely to > Integer.MAX_VALUE and also can not be
 * stored in a string, in each call to superDigit, we
 *     * Turn string into Stream object (n.chars()), which is a sequence of elements
 *     * Map each of those characters in the stream to long, get numeric value and sum them up
 *     * Turn them into string
 */

public class RecursiveDigitSumAug20 {

  // Complete the superDigit function below.
  static int superDigit(String n, int k) {
    n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";
    // Base Case
    if (n.length() <= 1) {
      return Character.getNumericValue(n.charAt(0));
    } else {
      // Else call superDigit on that string again
      return superDigit(n, 1);
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    String n = nk[0];

    int k = Integer.parseInt(nk[1]);

    int result = superDigit(n, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
