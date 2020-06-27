class jumpGameDynProgramming {
  
  /*
   * Starting at the last index
   * Work backwards, if at the position [n-1], 
   *     n-1 + nums[n-1= = steps to reach position n-1 + steps we can take
   *     to reach nums[n] is >= last Reachable position => update last reachable position
   *  Check if we can reach 0 from backward
   */
    public boolean canJump(int[] nums) {
        int lastIndexCanReach = nums.length -1;
        for (int i = lastIndexCanReach - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIndexCanReach ) {
                lastIndexCanReach  = i;
            }
        }
        return lastIndexCanReach == 0;
        
    }
}