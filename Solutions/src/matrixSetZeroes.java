import java.util.ArrayList;
import java.util.Iterator;

public class matrixSetZeroes {
  /*
   * If there is an alement in the matrix = 0, set the whole row and col = 0
   * 
   */
  /*
   * First solution
   */
  public static class Pair {
    int row;
    int col;

    public Pair(int i, int j) {
      row = i;
      col = j;
    }
  }

  public void setZeroes(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;

    ArrayList<Pair> lst = new ArrayList<Pair>();

    for (int i = 0; i < height; i++) {
      for (int k = 0; k < width; k++) {
        if (matrix[i][k] == 0) {
          lst.add(new Pair(i, k));
        }
      }
    }

    Iterator<Pair> it = lst.iterator();

    while (it.hasNext()) {
      Pair tmp = it.next();
      int row = tmp.row;
      int col = tmp.col;
      for (int m = 0; m < width; m++) {
        matrix[row][m] = 0;
      }
      for (int n = 0; n < height; n++) {
        matrix[n][col] = 0;
      }
    }
  }
  
  /*
   * Second solution: Usig BFS
   */
  
  public void setZeroes2(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0 && !visited[i][j]) {
          helper(matrix, visited, i, j);
        }
      }
    }
  }

  public void helper(int[][] matrix, boolean[][] visited, int i, int j) {
    visited[i][j] = true;
    for (int r = 0; r < matrix.length; r++) {
      if (matrix[r][j] != 0) {
        matrix[r][j] = 0;
        visited[r][j] = true;
      }
    }
    for (int c = 0; c < matrix[0].length; c++) {
      if (matrix[i][c] != 0) {
        matrix[i][c] = 0;
        visited[i][c] = true;
      }
    }
  }

}
