import java.util.Scanner;

public class MagicWord {

/*
 * .Each character should be replaced by the nearest Dhananjay's Magical alphabet.

2.If the character is equidistant with 2 Magical alphabets. The one with lower ASCII
 value will be considered as its replacement.
 */
  public static void main(String[] args) throws Exception {

    Scanner ob = new Scanner(System.in);

    int t = ob.nextInt();

    for (int i = 1; i <= t; i++)

    {

      int n = ob.nextInt();

      String s = ob.next();

      String w = magic(s);

      System.out.println(w);

    }
  }

  public static String magic(String s) {
    StringBuilder returnStr = new StringBuilder();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char tmp = s.charAt(i);
      if (isPrime((int) tmp)) {
        returnStr.append(tmp);
      } else {
        tmp = magic_letter(tmp);
        returnStr.append(tmp);
      }
    }
    return returnStr.toString();
  }

  public static boolean isPrime(int num) {

    int tmp = num / 2;
    if (num == 0 || num == 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    for (int i = 3; i <= tmp; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isInBound(char c) {
    if (c >= 'A' && c <= 'Z') {
      return true;
    } else if (c <= 'z' && c >= 'a') {
      return true;
    }
    return false;
  }

  public static char magic_letter(char c) {
    int tmp = c;
    int dif = 255;
    int p = 0;
    int[] primeNums = {67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113};

    for (int i = 0; i < primeNums.length; i++) {
      if (Math.abs(primeNums[i] - c) < dif) {
        dif = Math.abs(primeNums[i] - (int) c);
        p = primeNums[i];
      }
    }
    return (char) p;
  }


}
