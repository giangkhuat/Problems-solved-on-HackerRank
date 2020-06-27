import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * REcursive function: faster than 99.58 % 
 */
public class CombinationSum {
/*
 * We have a recursive function which takes in 
 *    * The set of set numbers
 *    * The combination that we are building
 *    * the array
 *    * The current position
 *    * the total left (target)
 * Algorithm: 
 *  If target = 0, we have a perfect sum
 *    Add the combination that we passed in to the set
 *    Return
 *  Else we iterate for all elements from currentPos to end
 *   and try to build these combinations 
 *   Ex: [2,3,6,7]
 *   CurrentPos = 0, we would try to build [2222] => eliminate, backtrack
 *     Then i++ = 1, try to build [233] => work, backtrack
 *     i++      = 2, [2
 *   If the current element is bigger than candiate, just break out, skip this iteration
 *   Else we add the current element to the combination and call the function again
 */
  
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return results;
    }
    
    //sort so it is ascending, we can backtrack when the last added element
    // create sum > target, no eed to explore adding more numbers to the right
    Arrays.sort(candidates);
    
    List<Integer> combination = new ArrayList<>();
    rec(results, combination, candidates, target, 0);
    return results;
    
    
  }
  
  private static void rec(List<List<Integer>> results, List<Integer> combination, int[] arr, int target, int start) {
    if (target == 0) {
      results.add(new ArrayList<Integer>(combination));
      return;
    }
    
    for (int i = start; i < arr.length; i++) {
      if (arr[i] > target) {
        break;
      } else {
        combination.add(arr[i]);
        rec(results, combination, arr, target - arr[i], i);
        // remove the previously added one so we can move on to the next
        combination.remove(combination.size() - 1);
      }
    }
    
  }
}
