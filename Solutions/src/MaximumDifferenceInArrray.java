
/*
 * keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).
Given an array arr[] of integers, find out the maximum difference between any two elements such that
 larger element appears after the smaller number.
filter_none
 */
public class MaximumDifferenceInArrray {
  int maxDiff(int arr[], int arr_size) {
    int max_diff = arr[1] - arr[0];
    int min_element = arr[0];
    int i;
    for (i = 1; i < arr_size; i++) {
      if (arr[i] - min_element > max_diff)
        max_diff = arr[i] - min_element;
      if (arr[i] < min_element)
        min_element = arr[i];
    }
    return max_diff;
  }
}
