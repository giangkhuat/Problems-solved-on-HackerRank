import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
  
  /*
   * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Time Complexityt: O(n)

lowerboundLeft = 0    upperboundRight = width - 1
   +---------------+
   |               |
   |               |   
   |               |    
   +----------------+
lowerboundTop= 0     upperboundBelow = height - 1

   */

  public static boolean isWithinBorder(List<Integer> lst, int width, int height) {
    return lst.size() < width * height;
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();

    if (matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }

    int width = matrix[0].length;
    int height = matrix.length;

    int lowerboundLeft = 0;
    int upperboundRight = width - 1;
    int lowerboundTop = 0;
    int upperboundBelow = height - 1;

    boolean withinBorder = isWithinBorder(res, width, height);

    while (withinBorder) {
      // go right , the whole row
      for (int j = lowerboundLeft; j <= upperboundRight
          && isWithinBorder(res, width, height); j++) {
        res.add(matrix[lowerboundTop][j]);
      }
      // go down to upperboundBelow - 1
      for (int i = lowerboundTop + 1; i <= upperboundBelow - 1
          && isWithinBorder(res, width, height); i++) {
        res.add(matrix[i][upperboundRight]);
      }
      // down right conerer to down left
      for (int k = upperboundRight; k >= lowerboundLeft
          && isWithinBorder(res, width, height); k--) {
        res.add(matrix[upperboundBelow][k]);
      }
      // down left to upperleft
      for (int m = upperboundBelow - 1; m >= lowerboundTop + 1
          && isWithinBorder(res, width, height); m--) {
        res.add(matrix[m][lowerboundLeft]);
      }
      lowerboundLeft++;
      upperboundRight--;
      lowerboundTop++;
      upperboundBelow--;
      withinBorder = isWithinBorder(res, width, height);
    }
    return res;

  }

}
