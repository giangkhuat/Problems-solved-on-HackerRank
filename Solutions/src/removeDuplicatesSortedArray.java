class removeDuplicatesSortedArray {
  public int removeDuplicates(int[] A) {
    if (A.length < 2)
      return A.length;

    int j = 0;
    int i = 1;

    while (i < A.length) {
      if (A[i] != A[j]) {
        j++;
        A[j] = A[i];
      }

      i++;
    }

    return j + 1;
  }
  
  public int removeDuplicates2(int[] nums) {
    if (nums == null || nums.length < 2)
      return nums.length;

    int i = 0;
    int repeated = nums[0];
    int latest_pos = 1;
    
    for (i = 1; i < nums.length; i++) {
      while (i < nums.length && repeated == nums[i]) {
        i++;
      }
      if (i < nums.length) {
        nums[latest_pos] = nums[i];
        latest_pos++;
        repeated = nums[i];
      }


    }
    return latest_pos;

  }
}
