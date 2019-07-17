import java.io.*;
import java.util.*;

public class LargestRectangleAreaUsingStack {

  // Complete the largestRectangle function below.
  static long largestRectangle(int[] h) {
    Stack<Integer> stack = new Stack<Integer>();
    long max_area = Long.MIN_VALUE;
    long area = 0;
    int index = 0, i = 0;
    stack.push(0);
    for (i = 1; i < h.length; i++) {
      int top = stack.peek();
      if (h[i] > h[top]) {
        stack.push(i);
      } else {
        do {
          index = stack.pop();
          if (stack.empty()) {
            area = h[index] * i;
          } else {
            area = h[index] * (i - stack.peek() - 1);
          }
          max_area = Math.max(max_area, area);
        } while ((!stack.empty()) && (h[stack.peek()] > h[i]));
        stack.push(i);
      }
    }

    while (!stack.empty()) {
      index = stack.pop();
      if (stack.empty()) {
        area = h[index] * i;
      } else {
        area = h[index] * (i - stack.peek() - 1);
      }
      max_area = Math.max(max_area, area);
    }
    return max_area;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] h = new int[n];

    String[] hItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int hItem = Integer.parseInt(hItems[i]);
      h[i] = hItem;
    }

    long result = largestRectangle(h);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
