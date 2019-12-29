import java.util.Arrays;

public class reorderLogFiles {
  public static void main (String[] args) throws Exception {
   
  }


  
  public static String[] reorderLog(String[] logs) {
    Arrays.sort(logs, (log1, log2) -> {
      String[] log1Split = log1.split(" ", 2);
      String[] log2Split = log2.split(" ", 2);
      boolean isDigit1 = Character.isDigit(log1Split[1].charAt(0));
      boolean isDigit2 = Character.isDigit(log2Split[1].charAt(0));
      if (!isDigit1 && !isDigit2) {
        int cmp = log1Split[1].compareTo(log2Split[1]);
        if (cmp != 0) {
          return cmp;
        } else {
          return log1Split[0].compareTo(log2Split[0]);
        }
      }

      // if first char is digit, check second char
      if (isDigit1) {
        if (isDigit2) {
          return 0;
        } else { // swap
          return 1;
        }
      } else { // else first char is character, return -1
        return -1; // no swap
      }
      
    });
    return logs;
    /*
    Arrays.sort(logs, (log1, log2) -> {
      String[] split1 = log1.split(" ", 2);
      String[] split2 = log2.split(" ", 2);
      // get the first char of second string in each array
      boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
      boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
      // if both char, compare lexico the second string
      if (!isDigit1 && !isDigit2) {
          int cmp = split1[1].compareTo(split2[1]);
          // if both str are equal, compare first string
          if (cmp != 0) {
            return cmp;
          } else {
            return split1[0].compareTo(split2[0]);
          }          
      }
      
      return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
  });
  return logs;
  */
  }
}
