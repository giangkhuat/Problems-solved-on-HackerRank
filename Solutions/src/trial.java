
import java.io.*;
import java.util.*;


public class trial {

  // Complete the isBalanced function below.
  static boolean isOpeningBracket(char c) {
    return (c == '{') || (c == '[') || (c == '(');
  }

  static boolean isClosingBracket(char bracket) {
    return (bracket == ']') || (bracket == '}') || (bracket == ')');
  }

  static boolean isMatched(Stack<Character> stack, char bracket) {
    char c = stack.peek();
    if ((bracket == '}') && (c == '{')) {
      return true;
    } else if ((bracket == ']') && (c == '[')) {
      return true;
    } else if ((bracket == ')') && (c == '(')) {
      return true;
    } else {
      return false;
    }
  }

  static String isBalanced(String s) {
    int len = s.length();
    if (len % 2 != 0) {
      return "NO";
    }
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (isOpeningBracket(c)) {
        stack.push(c);
      } else if (isClosingBracket(c)) {
        if (isMatched(stack, c)) {
          stack.pop();
        } else {
          return "NO";
        }
      }
    }
    if (stack.empty()) {
      return "YES";
    } else {
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

