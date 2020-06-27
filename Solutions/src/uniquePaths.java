class uniquePaths {
  public int uniquePathsCalculation(int m, int n) {
        /*
        Build up solution for example at paths p[1][1], there are 1 + 1 ways to get there
        col  0  1  2  3
         row 0  1  1  1  1  1
             1  1  2
             2  1
             3  1
        */
    int[][] paths = new int[n][m];
    for (int i = 0; i < m; i++) {
      paths[0][i] = 1;
    }
    for (int j = 0; j < n; j++) {
      paths[j][0] = 1;
    }

    for (int k = 1; k < n; k++) {
      for (int l = 1; l < m; l++) {
        paths[k][l] = paths[k - 1][l] + paths[k][l - 1];
      }
    }
    return paths[n - 1][m - 1];
  }
}