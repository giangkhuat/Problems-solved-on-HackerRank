
public class tapeEquilibriumCodility {
  public static void main (String[] args) throws Exception {
    int[] arr = {3, 1, 2, 4, 3};
    System.out.println("Min differnce is " + findMinDif(arr));
    
  }
  
  public static int findMinDif(int[] arr) {
    int leftSum = arr[0];
    int rightSum = 0;
    int min_dif = Integer.MAX_VALUE;
    
    for (int i = 1; i < arr.length;i++) {
      rightSum = rightSum + arr[i];
    }
    
    for (int k = 1; k < arr.length ;k++) {
      int dif = Math.abs(leftSum - rightSum);
      if (dif < min_dif) {
        min_dif = dif;
      }
      leftSum = leftSum + arr[k];
      rightSum = rightSum - arr[k];
    }
    return min_dif;
  }

}
