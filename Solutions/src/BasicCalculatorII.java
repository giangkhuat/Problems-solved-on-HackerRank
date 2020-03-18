import java.util.Stack;

public class BasicCalculatorII {
  /*
   * If we see a number
   *   * Iterate to find the whole number
   * If not a number or the last character 
   *   * If it is + push num
   *   * If it is -, push - num
   *   * if * or / 
   *       If op = *, tmp = num * s.top()
   *       Else tmp = s.top() / num
   *       s.pop()
   *       s.push(tmp)
   *     op = s[i]
   *     num = 0
   */
  public int calculate(String s) {
    int res = 0, num = 0;
    int size = s.length();
    char op = '+';
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < size; i++) {
      char currentChar = s.charAt(i);
      if (Character.isDigit(currentChar)) {
        num = num * 10 + currentChar - '0';
        System.out.println("num = " + num);
      }
      if (!Character.isDigit(currentChar) && currentChar != ' ' || i == size - 1) {
        if (op == '+') {
          stack.push(num);
        } else if (op == '-') {
          stack.push(-num);
        } else if (op == '*' || op == '/') {
          int tmp = op == '*' ? num * stack.peek() : stack.peek() / num;
          stack.pop();
          stack.push(tmp);

        }
        op = currentChar;
        num = 0;
      }
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.peek());
      res = res + stack.pop();
    }
    return res;
  }
}
