package DSA;

public class PrimMinimalSpanningTreeAlgo extends DsaBaseClass {
  /**
   * *********************
   * Spanning tree
   * All vertices are connected and constructed from a graph
   * A graph can have multiple spanning trees
   * A minimal spanning tree whose sum of weights of edges is the minimum
   * 
   */

  int nNodes = 6;

  @Override
  public void excercise() {
    int[][] graph = initializeGraph();
    int i, j, k, x, y;
    boolean[] visited = new boolean[nNodes];
    int[] minEdge = new int[nNodes];
    for (k = 1; k < nNodes; ++k) {
      visited[k] = false;
    }
    visited[0] = true;
    minEdge[0] = 0;
    for (k = 1; k < nNodes; ++k) {
      x = y = 0;
      for (i = 0; i < nNodes; ++i) {
        for (j = 0; j < nNodes; ++j) {
          if (visited[i] && !visited[j] && graph[i][j] < graph[x][y]) {
            x = i;
            y = j;
          }
        }
      }
      System.out.println("Next selected edge: (" + x + "," + y + ")" + " cost = " + graph[x][y]);
      minEdge[y] = graph[x][y];
      visited[y] = true;
    }
    System.out.print("Minimum weights: ");
    for (k = 0; k < nNodes; ++k) {
      System.out.print(minEdge[k] + " ");
    }
    System.out.print("\n");
  }

  int[][] initializeGraph() {
    int[][] result = new int[nNodes][nNodes];
    result[0][0] = 9999;
    result[0][1] = 4;
    result[0][2] = 6;
    result[0][3] = 9999;
    result[0][4] = 9999;
    result[0][5] = 5;
    result[1][0] = 4;
    result[1][1] = 9999;
    result[1][2] = 3;
    result[1][3] = 9999;
    result[1][4] = 9999;
    result[1][5] = 9999;
    result[2][0] = 6;
    result[2][1] = 3;
    result[2][2] = 9999;
    result[2][3] = 8;
    result[2][4] = 1;
    result[2][5] = 9999;
    result[3][0] = 9999;
    result[3][1] = 9999;
    result[3][2] = 8;
    result[3][3] = 9999;
    result[3][4] = 2;
    result[3][5] = 9999;
    result[4][0] = 9999;
    result[4][1] = 9999;
    result[4][2] = 9999;
    result[4][3] = 2;
    result[4][4] = 9999;
    result[4][5] = 9;
    result[5][0] = 5;
    result[5][1] = 9999;
    result[5][2] = 9999;
    result[5][3] = 9999;
    result[5][4] = 9;
    result[5][5] = 9999;

    return result;
  }

}
