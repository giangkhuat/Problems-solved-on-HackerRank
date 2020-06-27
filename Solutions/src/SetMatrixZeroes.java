
public class SetMatrixZeroes {


  public void setZeroes(int[][] matrix) {
    boolean isCol = false;
    // iterate and mark the first cell of row i and column j to 0
    for (int i = 0; i < matrix.length; i++) {
      // if any num in first col = 0, then the whole col is 0
      if (matrix[i][0] == 0) {
        isCol = true;
      }
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    // iterate to starting set the cell to 0 if corresponding col and row = 0
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    // See if the first row needs to be set to zero as well
    if (matrix[0][0] == 0) {
      for (int j = 0; j < C; j++) {
        matrix[0][j] = 0;
      }
    }
    
    
    if (isCol) {
      for (int i = 0; i < R; i++) {
        matrix[i][0] = 0;
      }
    }
  }


  public static void main(String[] args) throws Exception {

  }
}
