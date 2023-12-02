import java.util.*;

public class Dsa {
  public static void main(String[] args) {
    DsaBaseClass arr = new ArrayLearning();
    DsaBaseClass stack = new StackLearning();
    DsaBaseClass queue = new QueueLearning();
    DsaBaseClass linkedList = new LinkedListLearning();
    DsaBaseClass binaryTree = new BinaryTreeLearning();
    DsaBaseClass binarySearchTree = new BinarySearchTreeLearning();

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
  }
}
