public class BinarySearchTreeLearning extends DsaBaseClass {
  /**
   * *********************
   * Binary tree with more restrictions
   * Left child must always be less than root
   * Right child must always be greater than root
   * Insertion, Deletion, Search are much more efficient than Binary Tree
   * *********************
   * Suitable for sorted hierarchical data
   * *********************
   * Advantages
   * Represent data with some relationship
   * Insertion and search are much more efficient
   * *********************
   * Disadvantages
   * Sorting is difficult
   * Not much flexible
   */
  @Override
  public void excercise() {
    BinarySolution tree = new BinarySolution();
    tree.insertKey('A');
    tree.insertKey('1');
    tree.insertKey('B');
    tree.insertKey('4');
    tree.insertKey('0');
    tree.preorderTravers(tree.root);
    System.out.print("\n");
  }

  class Node {
    char key;
    Node left, right;

    Node(char key) {
      this.key = key;
    }
  }

  class BinarySolution {
    Node root;

    void insertKey(char key) {
      System.out.println("Insert: " + key);
      root = insertInTree(root, key);
    }

    Node insertInTree(Node n, char key) {
      if (n == null) {
        System.out.println("Insert");
        n = new Node(key);
        return n;
      }
      // Go to the left
      if (key < n.key) {
        System.out.println("LEFT");
        n.left = insertInTree(n.left, key);
      }
      // go to the right
      else if (key > n.key) {
        System.out.println("RIGHT");
        n.right = insertInTree(n.right, key);
      }

      return n;
    }

    void preorderTravers(Node n) {
      if (n == null) {
        return;
      }
      System.out.print(n.key + " ");
      preorderTravers(n.left);
      preorderTravers(n.right);
    }
  }

}
