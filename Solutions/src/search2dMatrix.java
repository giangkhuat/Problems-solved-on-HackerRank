
public class search2dMatrix {
  /*
   * Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
   */
  
  public boolean searchMatrix(int[][] matrix, int target) {

    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return false;
    }

    int height = matrix.length - 1;
    int width = matrix[0].length - 1;
    int col = width, row = 0;

    while (col >= 0 && row <= height) {
      if (matrix[row][col] == target) {
        return true;
      } else if (target > matrix[row][col]) {
        row++;
      } else if (target < matrix[row][col]) {
        col--;
      }
    }
    return false;

  }

}
