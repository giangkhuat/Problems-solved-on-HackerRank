
import java.io.*;
import java.util.*;


class shiftedArraySearch{
  /*
   * Question: Given a shifted array and a number, find index of that number in shifted array
   * Time Complexity: O(logn)
   * Space Complexity: O(n)
   * Passed 6/6 test cases
   */

  static int findPivot(int[] shiftArr, int low, int hi) {
    /*
     * If the first num in array <= the last, the whole array is not rotated,
     * return first index as pivot
     */
    if (shiftArr[0] <= shiftArr[shiftArr.length - 1]) {
      return 0;
    }
    /*
     * If arr[mid] < previous number, so this is the diving
     * point that it was increase then decrease, return this dividing point
     */
    while (low <= hi) {
      int midPoint = (hi + low) / 2;
      if (shiftArr[midPoint] < shiftArr[midPoint - 1]) {
        return midPoint;
      } else if (shiftArr[midPoint] > shiftArr[0]) {
        low = midPoint + 1;
      } else {
        hi = midPoint - 1;
      }
    }
    return 0;
  }

  static int findIndex(int[] shiftArr, int num, int lo, int hi) {
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (shiftArr[mid] == num) {
        return mid;
      } else if (shiftArr[mid] < num) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  static int shiftedArrSearch(int[] shiftArr, int num) {
    if (shiftArr.length == 0) {
      return -1;
    }

    int pivot = findPivot(shiftArr, 0, shiftArr.length - 1);
    // if pivot == 0 or num < smallest number in first half of shiftArray
    // num is from pivot -> end
    if (pivot == 0 || num < shiftArr[0]) {
      return findIndex(shiftArr, num, pivot, shiftArr.length - 1);
    } else {
      return findIndex(shiftArr, num, 0, pivot - 1);
    }

  }

  public static void main(String[] args) {

  }

}
