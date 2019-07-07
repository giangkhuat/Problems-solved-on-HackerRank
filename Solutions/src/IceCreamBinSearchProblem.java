import java.util.*;

/* 
 * Problem's Idea: 
 * Given an array of integers, return indices of the two numbers 
 * such that they add up to a specific target.
 * 
 * Edge Cases: 
 *    * Arrays of zeros, or one element
 *    * Positive and negative numbers in array
 *    * Duplicate elements
 *    * 
 */
public class IceCreamBinSearchProblem {

  // Approach 1: HashMap table
  /* * Time-complexity: O(n) because we traverse the array with n elements
     twice. HashTable look up time is O(1) => Total is O(n)
     * Space complexity: O(n), the amount of extra space required depends on n elements
     in the table
     Passed all test cases
  */
  static void whatFlavors(int[] cost, int money) {
    // Revised after checking reference from LeetCode's Two Sum article
    // Link: https://leetcode.com/articles/two-sum/
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < cost.length; i++) {
      map.put(cost[i], i);
    }
    for (int i = 0; i < cost.length; i++) {
      int complement = money - cost[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        int firstIndex = i + 1;
        int secIndex = map.get(complement) + 1;
        System.out.println(firstIndex + " " + secIndex);
        return;
      }
    }

  }
  
  //Approach 2: Sort and Binary Search 
  // Taken from HackerRank youtube: https://www.youtube.com/watch?v=Ifwf3DBN1sc
  // Did not pass test case when n > 10,000
  

  public static int indexOf(int[] menu, int val, int excludeThis) {
    for (int i = 0; i < menu.length; i++) {
      if (menu[i] == val && i != excludeThis) {
        return i;
      }
    }
    return -1;
  }

  public static int[] getIndices(int[] cost, int val1, int val2) {
    // find index of val1, excluding -1
    int index1 = indexOf(cost, val1, -1);
    int index2 = indexOf(cost, val2, val1);
    int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
    return indices;
  }

  public static int[] findIndices(int[] cost, int money) {
    int[] sortedMenu = cost.clone();
    Arrays.sort(sortedMenu);
    for (int i = 0; i < sortedMenu.length; i++) {
      int complement = money - sortedMenu[i];
      int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
      // binarySearch return index where element should be if not in array
      if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
        int[] indices = getIndices(cost, sortedMenu[i], complement);
        return indices;
      }
    }
    return null;
  }
  
  
  // Approach 3: Refering from Stanford University
  // Link: https://web.stanford.edu/class/cs9/sample_probs/TwoSum.pdf
  /*
   * Sort the array - O(nlogn) time complexity
   * Move two pointers inwards from both sides.
   *    * If their sum == k, we are done
   *    * If sum > k, move pointer of large element backward
   *    * If sum < k, move pointer of smaller element forward
   *    Small issue: do not keep track of indices, just return true or false
   */
  
  static boolean sumsToBudget(int[] cost, int money) {
    Arrays.sort(cost);
    int lowerBound = 0, upperBound = cost.length - 1;
    while (lowerBound < upperBound) {
      int sum = cost[lowerBound] + cost[upperBound];
      if (sum < money) {
        lowerBound++;
      } else if (sum > money) {
        upperBound--;
      } else {
        return true;
      }
    }
    return false;
  }


  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int money = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] cost = new int[n];

      String[] costItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int costItem = Integer.parseInt(costItems[i]);
        cost[i] = costItem;
      }

      whatFlavors(cost, money);
    }

    scanner.close();
  }
}
