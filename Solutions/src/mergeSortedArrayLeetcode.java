public class mergeSortedArrayLeetcode {
    public void merge(int A[], int m, int B[], int n) {
      /*
       * starting from right of first array, 
       *    * If A[i] > B[j] then we put A[i] in there nad decrement A pointer
       *    * Else we put B element and decrement n pointer
       *    * At the end we know if there are elements left, if the elements left 
       *    are smallest elements from both arrays
       *    If it is from A, then all elements from B already been put in A and we finish
       *    Else it must be from B, therefore we iterate through B to pick up the rest
       *    elements
       * Edge cases:
       *   * A = [2, 0]
       *    b= [1] => put 2 at bottom first, 
       *    Then put 1
       */
        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}