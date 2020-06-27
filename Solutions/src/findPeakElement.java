
public class findPeakElement {
  // Time complexity: O(logk)
  public static int findPeak(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = (right + left) / 2;
      if (nums[mid] < nums[mid + 1]) {
        // ascending slope, peak is on the right
        left = mid + 1;

      } else {
        right = mid;
        // the number is on descending slope, then the peak is to the left

      }
    }
    // when we break out, left == right and we shrink the regionwe need to find
    return left;
  }
  
  public static void main(String[] args) throws Exception {
    
  }
  
}
