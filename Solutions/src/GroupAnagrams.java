import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/*
 * Question: Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Solution: Sort each string in the array
Use this sorted version as the key in the map [string, listof string]
Compare and add to the map
Add all values of the map to the list of list at the end
 */
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    ArrayList<List<String>> stringList = new ArrayList<>();

    int len = strs.length;

    for (int i = 0; i < len; i++) {
      String current = strs[i];
      char[] tmpArr = current.toCharArray();
      Arrays.sort(tmpArr);
      String sorted = new String(tmpArr);
      if (!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<String>());
      }
      // now we add the current string to the list (value) of the corresponding key
      map.get(sorted).add(current);
    }

    stringList.addAll(map.values());
    return stringList;
  }
}
