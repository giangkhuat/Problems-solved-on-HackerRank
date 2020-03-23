
public class ArrayDuplicates {
  /*
   * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
   */
  public boolean containsDuplicate(int[] nums) {
    boolean duplicate = false;
    
    HashSet<Integer> set = new HashSet<Integer> ();
    for (int i = 0; i < nums.length; i++) {
        if (!set.contains(nums[i])) {
            set.add(nums[i]);
        } else {
          duplicate = true;
        }
    }
    return duplicate;
}
}
