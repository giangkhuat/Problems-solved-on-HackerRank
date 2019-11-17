import java.util.ArrayList;
import java.util.List;

public class findAllMissingNum {
  /*
   * Solution 1: O(n) time and O(1) space
   */
  public List<Integer> findMissingNumbers(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      while (nums[num - 1] != num) {
        int temp = nums[num - 1];
        nums[num - 1] = num;
        num = temp;
      }

    }

    List<Integer> returnList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        returnList.add(i + 1);
      }
    }
    return returnList;
  }

  /*
   * Solution 2: O(n) time and O(n) space
   */

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> returnList = new ArrayList<Integer>();
    int[] sortedBin = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int pos = nums[i];
      sortedBin[pos - 1] = pos;
    }

    for (int k = 0; k < nums.length; k++) {
      if (sortedBin[k] == 0) {
        returnList.add(k + 1);
      }
    }
    return returnList;

  }

}
