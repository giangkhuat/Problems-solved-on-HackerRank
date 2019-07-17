import java.io.*;
import java.util.*;


public class BalancedBrackets {

  /*
   * Passed 20/20 test cases
   * 
   * Idea: Putting characters in a stack
   *    * If c is an opening bracket, push its corresponding closing bracket
   *    * When we encouter a closing bracket, check if is equal to the stack's top
   *         * If no, or stack is empty, return NO
   *    * finish iterating, check if stack is empty or sequence is balanced
   *    
   * Problems encoutered: Can't initialize stack with char because it is primitive data type
   * Solution: Use wrapper class Character
   */
  static String isBalanced(String sequence) {
    // If sequence's length is odd, it can't be balanced
    if (sequence.length() % 2 != 0) {
      return "NO";
    } else {
      int len = sequence.length();
      Stack<Character> s = new Stack<>();
      for (int i = 0; i < len; i++) {
        char bracket = sequence.charAt(i);
        switch (bracket) {
          case '{':
            s.push('}');
            break;
          case '(':
            s.push(')');
            break;
          case '[':
            s.push(']');
            break;
          default:
            if (s.empty() || bracket != s.peek())
              return "NO";
            s.pop();
        }
      }
      
      if (s.empty()) {
        return "YES";
      } else
        return "NO";
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      String s = scanner.nextLine();

      String result = isBalanced(s);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}

