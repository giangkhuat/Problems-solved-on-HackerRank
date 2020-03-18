import java.util.Stack;

public class BasicCalculator {
  /*
  0 1 2 3 4  5 6 7 8 9 10 11 12 13 14 15  16  17 18
  ( 1 + ( 4  + 5 + 2  ) - 3   )  + (   6   +  8  )
  ( => push 0 on stack
  1 => sum_so_far + 1 = 1
  + => saved sign = +
  ( => push 1 on stack and the sign after it [0 1 +]
  sum_so_far = 0
  4 => 4 + 0 = 4
 
 sum_so_far = 0;
 int sign = 1;
 * If a[i] is a number, iterate to get the whole number and add it to previous sum so far
 * If plus, minus sign change sign = 1/-1
 * If (, we push sum_so_far to add later, push sign  to remember when we pop, reset sum = 0 and sign = 1
  * If ), we pop to get the sign
   sum = prevSign * sum
   sum = sum + stack.pop() again to get previous result
  */
  public boolean isDigit(char tmp) {
    if (tmp >= '0' && tmp <= '9') {
      return true;
    }
    return false;
  }

  public int calculate(String s) {
    int sum = 0;
    int sign = 1;
    int size = s.length();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < size; i++) {
      char currentChar = s.charAt(i);
      int num = 0;
      // if a number
      if (currentChar >= '0' && currentChar <= '9') {
        while (i < size && isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - '0';
          i++;
        }
        i--;
        sum = sum + num * sign;
      } else if (currentChar == '+') {
        // if plus sign
        sign = 1;
      } else if (currentChar == '-') {
        // if minus sign
        sign = -1;
      } else if (currentChar == '(') {
        // if open paren
        stack.push(sum);
        stack.push(sign);
        sign = 1;
        sum = 0;
      } else if (currentChar == ')') {
        // if close paren
        int previousSign = stack.pop();
        sum = stack.pop() + sum * previousSign;
      }

    }
    return sum;
  }
}
