package DSA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class GraphLearning extends DsaBaseClass {
  /**
   * *********************
   * Concept coming from Mathematics
   * Graph is composed edges and vertices.
   * Vertices represents data
   * Edges represent relationship between vertices
   * *********************
   * Directed Graph: there is only one direction
   * Undirected Graph: no specified direction
   * Connected graph: Any vertex is connected
   * Disconnected graph: at least one vertex not connected
   * *********************
   * Adjency matrix/List is used to reresent graph programmatically
   * *********************
   * Breadth-first search
   * Algorithms to trace nodes of the graphs
   * in breadth-first order
   * that is
   * the neighbouring nodes in a single level are traversed first
   * then the nodes in the next level are traversed
   * *********************
   * Depth-first search
   * Algorithms to trace nodes of the graphs
   * in depth-first order
   * the nodes in one depth are traversed
   * than the nodes in parallel depth are traversed
   * it uses the concept of back-tracking
   * after one vertical depth node is traversed
   */
  @Override
  public void excercise() {
    GraphSerach graph = new GraphSerach(6);
    graph.edge(0, 1);
    graph.edge(0, 2);
    graph.edge(0, 5);
    graph.edge(1, 0);
    graph.edge(1, 2);
    graph.edge(2, 0);
    graph.edge(2, 1);
    graph.edge(2, 3);
    graph.edge(2, 4);
    graph.edge(3, 2);
    graph.edge(4, 2);
    graph.edge(4, 5);
    graph.edge(5, 4);
    graph.edge(5, 0);
    graph.breadthFirstSearch(0);
    graph.depthFirstSearch(0);

  }

  // BFS implementation
  class GraphSerach {
    int numberOfVertices;
    ArrayList<Integer> adjacencyList[];

    GraphSerach(int numberOfVertices) {
      this.numberOfVertices = numberOfVertices;
      this.adjacencyList = new ArrayList[numberOfVertices];
      for (int i = 0; i < numberOfVertices; ++i) {
        this.adjacencyList[i] = new ArrayList<>();
      }
    }

    void edge(int x, int y) {
      this.adjacencyList[x].add(y);
    }

    void breadthFirstSearch(int sourceVertex) {
      System.out.print("BFS Algorithm: ");
      boolean[] visited = new boolean[this.numberOfVertices];
      ArrayList<Integer> a1 = new ArrayList<Integer>();
      visited[sourceVertex] = true;
      a1.add(sourceVertex);
      while (!a1.isEmpty()) {
        sourceVertex = a1.remove(0);
        System.out.print(sourceVertex + " ");
        Iterator<Integer> it = adjacencyList[sourceVertex].iterator();
        while (it.hasNext()) {
          int n = it.next();
          if (!visited[n]) {
            visited[n] = true;
            a1.add(n);
          }
        }
      }
      System.out.print("\n");
    }

    void depthFirstSearch(int sourceVertex) {
      System.out.print("DFS Algorithm: ");
      boolean[] visited = new boolean[this.numberOfVertices];
      Stack<Integer> s1 = new Stack<Integer>();
      visited[sourceVertex] = true;
      s1.add(sourceVertex);
      while (!s1.isEmpty()) {
        sourceVertex = s1.pop();
        System.out.print(sourceVertex + " ");
        Iterator<Integer> it = adjacencyList[sourceVertex].iterator();
        while (it.hasNext()) {
          int n = it.next();
          // System.out.print(n);
          if (!visited[n]) {
            visited[n] = true;
            s1.push(n);
          }
        }
        // System.out.print("Stack: " + s1 + "\n");
      }
      System.out.print("\n");
    }
  }

}
