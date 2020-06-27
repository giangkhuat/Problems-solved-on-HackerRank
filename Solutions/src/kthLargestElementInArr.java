import java.util.PriorityQueue;

public class kthLargestElementInArr {
  /*
   * Method 1: Quickselect modify of kthsmallest element in arr
   */
  /*
   * Goal: find the kth largest element How: FInd the partition position/index of element which is
   * (n-k) smallest We want to find the 3rd largest ( 7), find index of the (7- 3 + 1)th smallest,
   * which is at index 4 (partition index++) would return 4 n - k = 7 - 3 = 4 [ 1 2 3 5 8 7 9 ] [1 2
   * 3 5 7 8 9 ]
   */


  public static void swap(int[] unique, int a, int b) {
    int tmp = unique[a];
    unique[a] = unique[b];
    unique[b] = tmp;
  }

  public static int partition(int[] unique, int low, int hi) {
    int pivot = unique[hi];
    // start partition at low bound
    int partIndex = low;

    for (int i = low; i <= hi; i++) {
      if (unique[i] < pivot) {
        swap(unique, i, partIndex);
        partIndex++;
      }
    }
    swap(unique, partIndex, hi);
    System.out.println("Partition index = " + partIndex + " num: " + unique[partIndex]);
    return partIndex;
  }

  public static int quickSelect(int[] nums, int low, int hi, int kth) {
    int result = 0;
    if (low == hi) {
      // base case we stop recursing
      result = nums[low];
    } else {
      // else we need to find partition index
      int partIndex = partition(nums, low, hi);
      System.out.println("Partition index = " + partIndex + " kth: " + kth);
      if (partIndex == kth) {
        result = nums[partIndex];
      } else if (partIndex > kth) {
        // move left because our element we need is on the left of partIndex
        result = quickSelect(nums, low, partIndex - 1, kth);
      } else {
        result = quickSelect(nums, partIndex + 1, hi, kth);
      }
    }


    return result;
  }

  public int findKthLargest(int[] nums, int k) {
    int low = 0;
    int len = nums.length - 1;
    int result = quickSelect(nums, low, len, nums.length - k);
    return result;
  }
  
  /*
   * Method 2: Using min heap:
   */
  
  public int findKthLargestTwo(int[] nums, int k) {
    
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    for (int num : nums) {
        q.add(num);
        if (q.size() > k) {
            q.remove();
        }
    }
    return q.remove();
  }
  
}
