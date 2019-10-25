class removeDuplicatesAtMostTwice {
  public int removeDuplicates(int[] nums) {
    int len = nums.length - 1;
    int i = 0, j = 1;
    while (j <= len) {
      if (nums[j] == nums[i]) {
        if (i == 0) {
          i++;
          j++;
        } else if (nums[i] == nums[i - 1]) {
          j++;
        } else {
          i++;
          nums[i] = nums[j];
          j++;
        }
      } else if (nums[j] != nums[i]) {
        nums[++i] = nums[j++];
      }
    }
    return i + 1;
  }
}
