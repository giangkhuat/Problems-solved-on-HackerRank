
// quick select method
public class kSmallestInArr {
  public static void swap (int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
  
  public static int partition(int[] arr, int low, int hi) {
    int pivot = arr[hi];
    int partIndex = low;
    for (int i = low; i <= hi; i++) {
      if ( arr[i] < pivot) {
        swap (arr, i, partIndex);
        partIndex++;
      }
    }
    swap (arr, partIndex, hi);
    return partIndex;
  }
  
  
  public static int kthSmallest(int[] arr, int k, int low, int hi ) {
    System.out.println("k =" + k + ", Lo = " + low + " hi = " + hi);
    int partIndex = partition(arr, low, hi);
    int result = 0;
    if (partIndex + 1== k) {
      result = arr[partIndex];
    }
    else if (partIndex + 1 < k) {
      result = kthSmallest(arr, k, partIndex +1, hi);
    } else if (partIndex + 1 > k){
      result = kthSmallest(arr, k , low, partIndex -1 );
    }
    return result;
  }
  public static void main (String[] args) throws Exception {
    int[] arr = {1, 2, 7, 4, 5, 6};
    int k = 6;
    int result = kthSmallest(arr, k , 0, arr.length -1);
    System.out.println(" The " + k + " smallest is " + result);
    
  }

}
