import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BRFindPatternInString {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws Exception {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] splittedInput = line.split(";");
      String pattern = splittedInput[0];
      String blobs = splittedInput[1];
      BRFindPatternInString.doSomething(pattern, blobs);
    }
  }
  
  public static void doSomething(String pattern, String blobs) {
    String[] arr = blobs.split("\\|");
    int len = arr.length;
    int counter = 0;
    for (int i = 0; i < len; i++) {
      int tmp = checkEachBlob(pattern, arr[i]);
      counter = counter + tmp;
      System.out.print(tmp + "|");
    }
    System.out.print(counter);
  }
  
  public static int checkPattern(String pat, String blob, int start) {
    int i = 0;
    boolean match = true;
    while (i < pat.length() && match && start < blob.length()) {
      if (pat.charAt(i) != blob.charAt(start)) {
        match = false;
      } else {
        i++;
        start++;
      }
    }
    if (i == pat.length() && match) {
      return 1;
    } else {
      return 0;
    }
  }
  
   public static int checkEachBlob(String pat, String blob) {
    if (checkFirstChar(pat, blob) == -1) {
      return 0;
    } else {
      int k = checkFirstChar(pat, blob);
      int repeatNum = 0;
      while (k < blob.length()) {
        repeatNum = repeatNum + checkPattern(pat, blob, k);
        k++;
      }
      return repeatNum;
    }
  }
  
  public static int checkFirstChar(String pat, String blob) {
    if (pat.length() > blob.length() || pat.length() == 0) {
      return -1;
    } else {
      int i = 0;
      while (i < blob.length() && pat.charAt(0) != blob.charAt(i)) {
        i++;
      }
      if (i == blob.length()) {
        return -1;
      } else
        return i;
    }
  }
}