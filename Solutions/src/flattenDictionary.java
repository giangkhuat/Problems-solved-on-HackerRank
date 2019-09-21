import java.io.*;
import java.util.*;

class Solution {
 
  
  /*
  Recusrive function
 
  */
  
    /*
       SOLUTION
    
       Iterate through the Hashmap 
       map.get() -> key 
         * Check if val is a stirng
         **  If yes, I would want to pair this the key that I got and move on the next key
         
         ** key = key + 
         value pair
               * 
         ** if no, then I would want to "iterate" that object to find appropriate value 
         **       At this step, I can call flatteDictionary(key, value)
    */
  
  /*
  static void recHelper (HashMap<String, String> dict, HashMap<String, Object> originDict, String prefix ) {
    
    String newKey = prefix;
      if (originDict.get(prefix) instanceof String) {
         dict.put(prefix, originDict.get(prefix));
      } else {
        // iterate through val (which is a hashMap) and recHelper()
        recHelper(originDict.get(prefix), originDict, prefix);
      }  
  
  }
  */
  /*
  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    
  }
  */
  
  /*
  Key 2 { a: 2, b :3 }
  */
  
  /*
     "" : {
        "e": 2
     }
     ---------
     "e" : {
        "" : 2
     }
  */
  
  
  
  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * Passed 5/6 test cases
   * Case not passed:
   * {"a":{"b":{"c":{"d":{"e":{"f":{"":"awesome"}}}}}}}
Expected:
 
{"a.b.c.d.e.f":"awesome"}
Actual:
 
{a.b.c.d.e.f.=awesome}
StdError:
undefined
java.lang.AssertionError: expected:<{a.b.c.d.e.f.=awesome}> but was:<{a.b.c.d.e.f=awesome}>
   */
  
  
  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    // your code goes here
    HashMap<String, String> flatDict = new HashMap<>();
    recurse(flatDict, dict, "");
    return flatDict;
  }

  static void recurse(HashMap<String, String> flatDict, HashMap<String, Object> dict,
      String initialKey) {
    for (String key : dict.keySet()) {
      if (dict.get(key) instanceof String) {
        if (initialKey == null || initialKey == "") {
          flatDict.put(key, (String) dict.get(key));
        } else {
          flatDict.put(initialKey + "." + key, (String) dict.get(key));
        }
      } else { // recursive case
        if (initialKey == null || initialKey == "") {
          recurse(flatDict, (HashMap<String, Object>) dict.get(key), key);
        } else {
          recurse(flatDict, (HashMap<String, Object>) dict.get(key), initialKey + "." + key);
        }
      }
    }
  }
  
  
  
  
  /* Python Solution from Pramp
  ==============================
  
  function flattenDictionary(dict):
    flatDictionary = {}
    flattenDictionaryHelper("", dict, flatDictionary)

    return flatDictionary

  function flattenDictionaryHelper(initialKey, dict, flatDictionary):
      for (key : dict.keyset()):
          value = dict.get(key)

          if (!isDictionary(value)): # the value is of a primitive type
              if (initialKey == null || initialKey == ""):
                  flatDictionary.put(key, value)
              else:
                  flatDictionary.put(initialKey + "." + key, value)
          else:
              if (initialKey == null || initialKey == "")
                  flattenDictionaryHelper(key, value, flatDictionary)
              else:
                  flattenDictionaryHelper(initialKey + "." + key, value, flatDictionary)
  
  */

}