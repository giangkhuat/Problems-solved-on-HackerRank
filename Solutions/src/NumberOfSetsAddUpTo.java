import java.util.HashMap;

public class NumberOfSetsAddUpTo {
  /*
   * Given an array of numbers, find number of sets
   * of num in that arrayadd up to a certain number
   */
  /*
   * Recusion Solution:
   */
  public static int countSet(int[] arr, int totalLeft, int pos) {
    if (totalLeft == 0) {
      // we have found a perfect set
      return 1;
    } else if (totalLeft < 0) {
      // unable to make a set from these numbers
      return 0;
    } else if (pos < 0) {
      // we run off the array
      return 0;
    } else if (totalLeft < arr[pos]) {
      // the currentNumber can not be in the set 
      return countSet(arr, totalLeft, pos -1);
    } else {
      //else the number of sets = set (not including current numb) + set including currentNum
      return countSet(arr, totalLeft - arr[pos], pos - 1) + countSet(arr, totalLeft, pos);
    }
  }
  
  public static int count (int[] arr, int totalLeft) {
    return countSet(arr, totalLeft, arr.length - 1);
  }
  
  // DYNAMIC PROGRAMMING
  // Create a hash table to store key and value is the number of sets
  
  public static int dpCount(int[] arr, int totalLeft) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    return dpCountHelper(arr, totalLeft, arr.length -1, map);
  }
  
  public static int dpCountHelper(int[] arr, int totalLeft, int pos, HashMap<String, Integer> map) {
    String key = "" + totalLeft + pos;
    int tmpVal =0;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    else if (totalLeft == 0) {
      // we have found a perfect set
      return 1;
    } else if (totalLeft < 0) {
      // unable to make a set from these numbers
      return 0;
    } else if (pos < 0) {
      // we run off the array
      return 0;
    } else if (totalLeft < arr[pos]) {
      // the currentNumber can not be in the set
      tmpVal = dpCountHelper](arr, totalLeft, pos -1, map);
      
    } else {
      //else the number of sets = set (not including current numb) + set including currentNum
      tmpVal = dpCountHelper(arr, totalLeft - arr[pos], pos - 1, map) + dpCountHelper(arr, totalLeft, pos, map);
    }
    map.put(key,tmpVal);
    return tmpVal;
  }
  
  public static void main (String[] args) throws Exception {
    
  }
}
