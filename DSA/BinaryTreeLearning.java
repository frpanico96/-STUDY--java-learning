package DSA;

public class BinaryTreeLearning extends DsaBaseClass {
  /**
   * *********************
   * Hierarchical DataStructure
   * TopMost element is know as root of tree
   * Every node can have at least 2 children in binary tree
   * Can't access elements randomly using index
   * Example: File system hierarchy
   * Common traversal method
   * preorder(root): root -> left -> right
   * postorder(root): left -> right -> root
   * inorder(root): left -> root -> right
   * *********************
   * Applications
   * File hierarchy system
   * Multiple variations of binary tree has wide of applications
   * *********************
   * Advantages
   * Can represent data with some relationship
   * Insertion and search are efficient
   * *********************
   * Disadvantages
   * Sorting is difficult
   * Not much flexible
   */
  @Override
  public void excercise() {
    TreeTaversal tree = new TreeTaversal();
    tree.root = createDataSet();
    System.out.println("###### Preorder Traversal ######");
    tree.preorderTraversal(tree.root);
    System.out.print("\n");
    System.out.println("###### Postorder Traversal ######");
    tree.postorderTraversal(tree.root);
    System.out.print("\n");
    System.out.println("###### Inorder Traversal ######");
    tree.inorderTraversal(tree.root);
    System.out.print("\n");
  }

  class Node {
    char key;
    Node left, right;

    Node(char key) {
      this.key = key;
    }
  }

  class TreeTaversal {
    Node root;

    void preorderTraversal(Node root) {
      if (root == null) {
        return;
      }

      System.out.print(root.key + " ");
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }

    void inorderTraversal(Node root) {
      if (root == null) {
        return;
      }
      inorderTraversal(root.left);
      System.out.print(root.key + " ");
      inorderTraversal(root.right);
    }

    void postorderTraversal(Node root) {
      if (root == null) {
        return;
      }
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      System.out.print(root.key + " ");
    }
  }

  Node createDataSet() {
    Node root = new Node('A');
    root.left = new Node('B');
    root.right = new Node('C');
    root.left.left = new Node('D');
    root.left.right = new Node('E');
    root.right.left = new Node('F');

    return root;
  }
}
