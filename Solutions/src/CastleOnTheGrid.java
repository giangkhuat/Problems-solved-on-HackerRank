import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class CastleOnTheGrid {
  static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int[][] game;
  static boolean[][] visited;
  static int len;
  static Queue<Point> moves = new LinkedList<Point>();

  public static boolean isVisited(Point current) {
    return visited[current.x][current.y];
  }

  static void generateMoves(Point current) {
    int x = current.x;
    int y = current.y;
    // from here we find all reachable neighbors, add it to the queue and calculate the path
    // leading to that neighbor
    int currentSteps = game[x][y];

    // move up
    for (int i = x; i >= 0 && game[i][y] != -1; i--) {
      moves.add(new Point(i, y));
      // update path scores leading to this new point if it is smaller than previous
      game[i][y] = Math.min(currentSteps + 1, game[i][y]);
    }

    // move right
    for (int i = y; i < len && game[x][i] != -1; i++) {
      moves.add(new Point(x, i));
      // update path scores leading to this new point if it is smaller than previous
      game[x][i] = Math.min(currentSteps + 1, game[x][i]);
    }

    // move down
    for (int i = x; i < len && game[i][y] != -1; i++) {
      moves.add(new Point(i, y));
      // update path scores leading to this new point if it is smaller than previous
      game[i][y] = Math.min(currentSteps + 1, game[i][y]);
    }

    // move left
    for (int i = y; i >= 0 && game[x][i] != -1; i--) {
      moves.add(new Point(x, i));
      // update path scores leading to this new point if it is smaller than previous
      game[x][i] = Math.min(currentSteps + 1, game[x][i]);
    }

  }

  static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    len = grid.length;
    moves.add(new Point(startX, startY));

    visited = new boolean[len][len];
    game = new int[len][len];

    // mark all as unvisited
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        visited[i][j] = false;
      }
    }

    // populate number of moves to reach it cell as the largest number
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (grid[i].charAt(j) == '.') {
          game[i][j] = Integer.MAX_VALUE;
        } else {
          game[i][j] = -1;
        }
      }
    }

    game[startX][startY] = 0;


    while (!moves.isEmpty()) {
      Point current = moves.poll();
      if (!isVisited(current)) {
        visited[current.x][current.y] = true;
        generateMoves(current);
      }
    }

    return game[goalX][goalY];

  }



  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] grid = new String[n];

    for (int i = 0; i < n; i++) {
      String gridItem = scanner.nextLine();
      grid[i] = gridItem;
    }

    String[] startXStartY = scanner.nextLine().split(" ");

    int startX = Integer.parseInt(startXStartY[0]);

    int startY = Integer.parseInt(startXStartY[1]);

    int goalX = Integer.parseInt(startXStartY[2]);

    int goalY = Integer.parseInt(startXStartY[3]);

    int result = minimumMoves(grid, startX, startY, goalX, goalY);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
