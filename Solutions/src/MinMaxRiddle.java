import java.io.*;
import java.util.*;


public class MinMaxRiddle {

  // Complete the riddle function below.
  static long[] riddle(long[] arr) {
    int n = arr.length;
    long[] returnArray = new long[n];

    Queue<Long> queue1 = new LinkedList<Long>();
    for (int i = 0; i < n; i++) {
      queue1.add(arr[i]);
    }
    
    System.out.println(queue1.size());
    System.out.println(queue1.peek());
    System.out.println("_____________");
    
    for (int i = n; i > 0; i--) {
      Long max = queue1.peek();
      Queue<Long> tempQueue = new LinkedList<Long>();
      if (queue1.peek() != null) {
        long top = queue1.remove();
        long min;
        if (queue1.peek() != null) {
          min = Math.min(top, queue1.peek());
          tempQueue.add(min);
        } else {
          min = top;
        }
        max = Math.max(min, max);
      }
      returnArray[n - i] = (long) max;
      queue1 = tempQueue;
    }
    return returnArray;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new OutputStreamWriter(System.out));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    long[] arr = new long[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      long arrItem = Long.parseLong(arrItems[i]);
      arr[i] = arrItem;
    }

    long[] res = riddle(arr);

    for (int i = 0; i < res.length; i++) {
      bufferedWriter.write(String.valueOf(res[i]));

      if (i != res.length - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
