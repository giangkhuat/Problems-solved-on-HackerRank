import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChar {
  /* first version */
  /*
   * We use a set to keep track if the element is already repeated
   * as we iterate:
   *    * If we saw a[j] is already in the set
   *       * Then we remove the character at left bound and increment i to shorten the range
   *    * Else we add a[j] to the set, increment j to expand window
   *        * Update range
   * => Problem: we don't need to increment i 1 by 1 because we know all the j-i
   * characters will not be included in the next window 
   * So i can jump to j immediately
   */
  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<Character>();
    int max_len = 0;
    int len = s.length();
    int i = 0, j = 0;
    while (i < len && j < len) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));

        max_len = Math.max(max_len, j - i + 1);
        j++;
      } else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return max_len;

  }
  
  /*
   * Econd version
   */
  public int lengthOfLongestSubstring2(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>(); // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
        if (map.containsKey(s.charAt(j))) {
            i = Math.max(map.get(s.charAt(j)), i);
        }
        ans = Math.max(ans, j - i + 1);
        map.put(s.charAt(j), j + 1);
    }
    return ans;
}

}
