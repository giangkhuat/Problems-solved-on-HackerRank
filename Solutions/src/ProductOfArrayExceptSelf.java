
public class ProductOfArrayExceptSelf {
  /*
   * First solution:
   * O(n) time
   * O(n) space
   */
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] productFromLeft = new int[len];
    int[] productFromRight = new int[len];

    productFromLeft[0] = nums[0];
    for (int i = 1; i < len; i++) {
      productFromLeft[i] = productFromLeft[i - 1] * nums[i];
    }

    productFromRight[len - 1] = nums[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      productFromRight[i] = productFromRight[i + 1] * nums[i];
    }

    int[] returnArr = new int[len];

    for (int i = 0; i < len; i++) {
      if (i == 0) {
        returnArr[i] = productFromRight[1];
      } else if (i == len - 1) {
        returnArr[i] = productFromLeft[len - 2];
      } else {
        returnArr[i] = productFromLeft[i - 1] * productFromRight[i + 1];
      }
    }
    return returnArr;

  }
  
  /*
   * Second
   * Time COmplexity: O(n)
   * Space: O(1)
   */
  public int[] productExceptSelf2(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    
    res[0] = 1;
    for (int i = 1; i < len; i++) {
        res[i] = nums[i-1] * res[i-1];
    }
    int right = 1;
    for(int k = len-1; k>=0;k--) {
        res[k]= res[k] * right;
        right = right * nums[k];
    }
    return res;
    
}
}
