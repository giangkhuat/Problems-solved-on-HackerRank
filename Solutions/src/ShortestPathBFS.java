
import java.io.*;
import java.util.*;

/*
 * This question is a modified version of Dijisktra Algorithm
 * Time Complexity: O(n^2)
 * 
 */

public class ShortestPathBFS {
  
  static int max = Integer.MAX_VALUE;

  public static void initEdges(List<Integer>[] vertices, int[][] edges) {
    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < edges.length; i++) {
      int vertex = edges[i][0];
      int neighbor = edges[i][1];
      vertices[vertex].add(neighbor);
      vertices[neighbor].add(vertex);
    }
  }


  // n is number of nodes
  // m is number of edges
  // s is starting index
  static int[] bfs(int numNodes, int numEdges, int[][] edges, int s) {

    boolean[] visited = new boolean[numNodes + 1];
    int[] distance = new int[numNodes + 1];
    @SuppressWarnings("unchecked")
    List<Integer>[] vertices = new ArrayList[numNodes + 1];
    Queue<Integer> remaining = new LinkedList<Integer>();
    int[] returnArr = new int[numNodes - 1];

    // populate all edges from vertices
    initEdges(vertices, edges);

    for (int i = 0; i < distance.length; i++) {
      distance[i] = max;
    }

    distance[s] = 0;
    remaining.add(s);
    
    /*
     * Start examining  all nodes in BFS method, adding distances
     * since all paths have equal weight, we know definitely the next one we add
     * will result in higher weight than last one
     * So we don't need to compare and update the distances
     */
    while (!remaining.isEmpty()) {
      int vertex = remaining.poll();
      List<Integer> neighbors = vertices[vertex];
      Iterator<Integer> it = neighbors.iterator();
      while (it.hasNext()) {
        int currentNeighbor = it.next();
        if (distance[currentNeighbor] == max) {
          distance[currentNeighbor] = distance[vertex] + 6;
          remaining.add(currentNeighbor);
        }
      }
    }

    int i = 0, k = 1;
    while (k <= numNodes) {
      if (k != s) {
        if (distance[k] != max) {
          returnArr[i++] = distance[k];
        } else {
          returnArr[i++] = -1;
        }
      }
      k++;
    }
    
    return returnArr;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
     * named Solution.
     */
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] nm = scanner.nextLine().split(" ");
      // get nodes
      int numNodes = Integer.parseInt(nm[0]);
      // get number of edges
      int numEdges = Integer.parseInt(nm[1]);

      int[][] edges = new int[numEdges][2];

      for (int i = 0; i < numEdges; i++) {
        String[] edgesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int edgesItem = Integer.parseInt(edgesRowItems[j]);
          edges[i][j] = edgesItem;
        }
      }

      int s = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] result = bfs(numNodes, numEdges, edges, s);

      for (int i = 0; i < result.length; i++) {
        bufferedWriter.write(String.valueOf(result[i]));

        if (i != result.length - 1) {
          bufferedWriter.write(" ");
        }
      }

      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}


