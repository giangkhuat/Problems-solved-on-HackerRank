import java.util.HashSet;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    HashSet<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (!set.contains(nums[i])) {
        set.add(nums[i]);
      } else {
        set.remove(nums[i]);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return nums[i];
      }
    }
    return 0;

  }
}
