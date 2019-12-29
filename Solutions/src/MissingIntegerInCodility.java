import java.util.Arrays;
/*
 * Write a function:

that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer that does not occur in A.

For example, given:

    A[0] = 1
    A[1] = 3
    A[2] = 6
    A[3] = 4
    A[4] = 1
    A[5] = 2

the function should return 5.

 */

public class MissingIntegerInCodility {
  
  public static void main (String[] args ) throws Exception {
    
  }
  
  /*
   * Time complexity: 0(n)
   */
  public int solution(int[] A) {

    int smallest = 1;

    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {

      if (A[i] == smallest) {

        smallest++;
      }
    }

    return smallest;
  }

}
