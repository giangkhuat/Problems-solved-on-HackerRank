class searchRangeBinSearch {

/*
 * Modify binary search, when we found the element, we keep going 
 * so condition is when <= or >=, keep moving left or right until low <= end
 */

  public static int searchStart(int[] nums, int target) {
    int low = 0;
    int hi = nums.length - 1;
    int startIndex = -1;
    while (low <= hi) {
      int mid = (low + hi) / 2;
      if (nums[mid] >= target) {
        // we dont stop, we keep going left to find the start index
        hi = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      }
      if (nums[mid] == target) {
        startIndex = mid;
      }
    }
    return startIndex;

  }

  public static int searchEnd(int[] nums, int target) {
    int low = 0;
    int hi = nums.length - 1;
    int endIndex = -1;
    while (low <= hi) {
      int mid = (low + hi) / 2;
      if (nums[mid] <= target) {
        // we dont stop, we keep going left to find the start index
        low = mid + 1;
      } else if (nums[mid] > target) {
        hi = mid - 1;
      }
      if (nums[mid] == target) {
        endIndex = mid;
      }
    }
    return endIndex;
  }

  public int[] searchRange(int[] nums, int target) {
    int[] arr = new int[2];
    int startIndex = -1;
    int endIndex = -1;
    // first search for the starting index
    // for all elements that
    // search for ending index
    if (nums.length != 0) {
      startIndex = searchStart(nums, target);
      endIndex = searchEnd(nums, target);

    }
    arr[0] = startIndex;
    arr[1] = endIndex;

    return arr;
  }
}
