
public class IncreasingTripleSub {
  public boolean increasingTriplet(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }

    int minOne = Integer.MAX_VALUE;
    int minTwo = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < minOne) {
        minOne = nums[i];
      }
      if (nums[i] > minOne) {
        minTwo = Math.min(nums[i], minTwo);
      }
      if (nums[i] > minTwo) {
        return true;
      }
    }
    return false;
  }
}
