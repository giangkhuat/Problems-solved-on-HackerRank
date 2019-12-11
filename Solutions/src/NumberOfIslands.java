class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return 0;

    int row = grid.length;
    int count = 0;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          count++;
          exploreIsland(grid, i, j);
        }
      }
    }
    return count;

  }

  public static void exploreIsland(char[][] grid, int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
        || grid[row][col] != '1') {
      return;
    }
    grid[row][col] = '0';
    exploreIsland(grid, row - 1, col);
    exploreIsland(grid, row + 1, col);
    exploreIsland(grid, row, col - 1);
    exploreIsland(grid, row, col + 1);

  }
}
