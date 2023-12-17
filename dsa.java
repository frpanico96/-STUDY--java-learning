import java.util.*;

public class Dsa {
  public static void main(String[] args) {
    DsaBaseClass arr = new ArrayLearning();
    DsaBaseClass stack = new StackLearning();
    DsaBaseClass queue = new QueueLearning();
    DsaBaseClass linkedList = new LinkedListLearning();
    DsaBaseClass binaryTree = new BinaryTreeLearning();
    DsaBaseClass binarySearchTree = new BinarySearchTreeLearning();
    DsaBaseClass graph = new GraphLearning();
    DsaBaseClass hash = new HashLearning();
    DsaBaseClass searchAlgo = new SearchAlgoLearning();
    DsaBaseClass sortingAlgo = new SortAlgoLearning();
    DsaBaseClass primMinimalSpanningTreeAlgo = new PrimMinimalSpanningTreeAlgo();
    DsaBaseClass towerOfHanoi = new TowerOfHanoiAlgo();

    System.out.println("#################");
    System.out.println("##### Array #####");
    arr.excercise();
    System.out.println("#################");
    System.out.println("##### Stack #####");
    stack.excercise();
    System.out.println("#################");
    System.out.println("##### Queue #####");
    queue.excercise();
    System.out.println("#################");
    System.out.println("##### LinkedList #####");
    linkedList.excercise();
    System.out.println("#################");
    System.out.println("##### Binary tree #####");
    binaryTree.excercise();
    System.out.println("#################");
    System.out.println("##### Binary Search tree #####");
    binarySearchTree.excercise();
    System.out.println("#################");
    System.out.println("##### Graph #####");
    graph.excercise();
    System.out.println("#################");
    System.out.println("##### Hash #####");
    hash.excercise();
    System.out.println("#################");
    System.out.println("##### Search Algorithms #####");
    searchAlgo.excercise();
    System.out.println("#################");
    System.out.println("##### Sorting Algorithms #####");
    sortingAlgo.excercise();
    System.out.println("#################");
    System.out.println("##### Prim's minimal spanning tree Algorithm #####");
    primMinimalSpanningTreeAlgo.excercise();
    System.out.println("#################");
    System.out.println("##### Tower of Hanoi Algorithm #####");
    towerOfHanoi.excercise();
  }
}
