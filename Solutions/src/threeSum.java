import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class threeSum {
    
    /*
    OutLine: 
    Sort the array
    Iterating through the sorted array
    At each position, given the current element
       * Have two pointers left and right
       * Repeat this until left == right:
            Calculate the sum of three numbers
            If sum == 0, add it to the set
            Iterating to find duplicates on both sides left and right
        *   If sum < 0, icnrement left
             If sum > 0, decrement right
        * Increment i to check for duplicates
    */
  public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> returnSet = new ArrayList<>();
    int len = nums.length - 1;
    int right = len;
    Arrays.sort(nums);
    for (int i = 0; i < len; i++) {
      int left = i + 1;
      right = len;
      int current = nums[i];
      while (left < right) {
        int sum = current + nums[left] + nums[right];
        if (sum == 0) {
          returnSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
          int leftVal = nums[left];
          // skip duplicates from left side
          while (left <= len && nums[left] == leftVal) {
            left++;
          }
          int rightVal = nums[right];
          while (right > left && nums[right] == rightVal) {
            right--;
          }
        } else if (sum < 0) {
          ++left;
        } else {
          right--;
        }
      }
      // handle duplicates with first num
      while (i < len && nums[i] == nums[i + 1]) {
        i++;
      }
    }
    return returnSet;
  }
}
