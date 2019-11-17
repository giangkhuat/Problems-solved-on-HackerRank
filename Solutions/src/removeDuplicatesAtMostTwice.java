class removeDuplicatesAtMostTwice {
  public int removeDuplicates(int[] nums) {
    int len = nums.length - 1;
    int i = 0, j = 1;
    while (j <= len) {
      if (nums[j] == nums[i]) {
        // if i is the first element
        if (i == 0) {
          i++;
          j++;
        } else if (nums[i] == nums[i - 1]) { // repeat more than 2 times, then just increment j to find a different leement
          j++;
        } else { // repeat less than 2 times
          i++; // increment i
          nums[i] = nums[j]; // move elements from j to i position 
          // i+1 element might be != j position
          j++;
        }
      } else if (nums[j] != nums[i]) {
        nums[++i] = nums[j++];
      }
    }
    return i + 1;
  }
}
