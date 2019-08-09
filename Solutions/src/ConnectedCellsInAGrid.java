import java.io.*;
import java.util.*;

/*
 * Using DFS and recursion
 * Idea: 
 *    * For all entries in the matrix
 *       * If entry == 1, use DFS to count connected region starting with that entry
 *                        Toggle entry = 0 to stop counting again later
 *       * if entry is out of range or == 0, return 0
 * Passed 7/7 test cases
 * Time complexity: O(n^2)
 * Space Complexity: O(n)  
 * Problems Encoutered: 
 * How to not search yourself multiple times
 *       * First I used data structure stack, but I had issues with stack.contains(obj) and stack.search(obj), which is O(n)
 *       so I used recursion at the end
 *       => Optimize time complexity
 * Previously boundary condition was checked before I added the size, then moved to be one of the base cases
 * => reduce the number of functions called           
 */
public class ConnectedCellsInAGrid {

  static int[] rowOffset = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] colOffset = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[][] matrix;


  public static boolean validRange(int[][] matrix, int row, int col) {
    int height = matrix.length;
    int width = matrix[0].length;
    return (row >= 0 && col >= 0 && row < height && col < width);
  }

  public static int countRegion(int[][] matrix, int row, int col) {
    // Base cases: Out of range, return 0
    // If entry = 0 , return 0
    if (!validRange(matrix, row, col)) {
      return 0;
    } else if (matrix[row][col] == 0) {
      return 0;
    } else {
      // Recursive case
      int count = 1;
      // toggle entry to stop recursion later
      matrix[row][col] = 0;
      for (int i = 0; i < 8; i++) {
        count = count + countRegion(matrix, row + rowOffset[i], col + colOffset[i]);
      }
      return count;
    }
  }

  // Complete the maxRegion function below.
  static int maxRegion(int[][] grid) {
    int maxReg = 0;
    int height = grid.length;
    int width = grid[0].length;

    matrix = new int[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        matrix[i][j] = grid[i][j];
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (matrix[i][j] == 1) {
          int tempRegion = countRegion(matrix, i, j);
          maxReg = Math.max(tempRegion, maxReg);
        }
      }
    }
    
    return maxReg;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int m = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[][] grid = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] gridRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < m; j++) {
        int gridItem = Integer.parseInt(gridRowItems[j]);
        grid[i][j] = gridItem;
      }
    }

    int res = maxRegion(grid);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}

