import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
  
  public static List<List<String>> group(String[] arr) {
    if (arr.length == 0) {
      return new ArrayList(); 
    }
    
    //create a map of string and list 
    Map<String, List> map = new HashMap<String, List>();
    // iterate through each string
    // create the hash for it, put it in the hash table
    // return the hash value
    for (int i = 0 ; i < arr.length ;i++) {
      String uniqueHash = computeHash(arr[i]);
      
    }
  }
  
  public static String computeHash(String str) {
    int len = str.length();
    StringBuilder build = new StringBuilder();
    int[] count = new int[26];
    for (int i =0 ;i < len; i++) {
      // check if the character 
      char c = str.charAt(i);
      count[c-'a']++;
    }
    for (int j = 0; j < 26; j++) {
      build.append(count[j]);
      build.append('#');
    }
    return build.toString();
  }
  
  
  
  public static void main (String[] args) {
    
  }
}
