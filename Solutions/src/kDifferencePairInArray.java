import java.util.HashMap;
import java.util.Map;

public class kDifferencePairInArray {
  /*
  Iterate array nums
  If hashmap contains nums[i]
     * if k == 0 and there is already a number there or val ==1 
     result++
     * Increment value of that key
  Else if not contains
     We check if (nums[i] - k) in map => result++
               If nums(i) + k in map => result++
     Map.put(nums[i[, 1])
  */
  public int findPairs(int[] nums, int k) {
    
    if (nums.length == 0 || k < 0) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int num : nums) {
      if (map.containsKey(num)) {
        if ((k == 0) && map.get(num) == 1) {
          result++;
        }
        map.put(num, map.get(num) + 1);
      } else {
        if (map.containsKey(num - k)) {
          result++;
        }
        if (map.containsKey(num + k)) {
          result++;
        }
        map.put(num, 1);
      }
    }
    return result;
  }

}
