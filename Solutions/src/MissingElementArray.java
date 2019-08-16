/*
 * This is a practice problem from https://reginaldlong.com/how-do-i-practice-an-interview-problem/
 * Given an array size n containing numbers from 1 to n, find the missing element
 * 
 */
public class MissingElementArray {
  
  public static int findMissingNum(int[] arr, int n ) {
    long sum = n*(n+1)/2;
    long sumArray = 0;
    for (int i = 0; i < arr.length;i++) {
      sumArray = sumArray + arr[i];
    }
    return (int) (sum - sumArray);
  }
  
  public static void main(String[] args) throws Exception {
    // normal arrays
    int[] arr = {1, 2, 3, 5, 6, 7};
    int miss = findMissingNum(arr, 7);
    System.out.println(miss);
    // array with sum = 0
    int[] arr2 = {};
    System.out.println(findMissingNum(arr2, 0));
  }
}
