import java.util.*;

public class RansomNote {

  // Complete the checkMagazine function below.
  /*
   * Idea: 
   * Check corner case: If note has more words than magazine, return No
   * Else :
   *   * Put all words in magazine in a hashMap, key is the word, value is the number it repeated
   *   * Iterating through note
   *      * If the map does not contain current word, return No
   *      * If it does, check if val = 0, return no
   *                   * else val ! = 0, decrement val
   */
  static void checkMagazine(String[] magazine, String[] note) {
    if (note.length > magazine.length) {
      System.out.println("No");
      return;
    } else {
      HashMap<String, Integer> map = new HashMap<>();
      for (int i = 0; i < magazine.length; i++) {
        if (map.containsKey(magazine[i])) {
          map.put(magazine[i], map.get(magazine[i]) + 1);
        } else {
          map.put(magazine[i], 1);
        }
      }

      for (int i = 0; i < note.length; i++) {
        if (!map.containsKey(note[i])) {
          System.out.println("No");
          return;
        } else {
          if (map.get(note[i]) == 0) {
            System.out.println("No");
            return;
          } else {
            map.put(note[i], map.get(note[i]) - 1);
          }
        }
      }
      System.out.println("Yes");
      return;
    }
  }

  /*
   * Two below functions taken from HackerRank website
   */
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] note = new String[n];

    String[] noteItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String noteItem = noteItems[i];
      note[i] = noteItem;
    }

    checkMagazine(magazine, note);

    scanner.close();
  }
}
