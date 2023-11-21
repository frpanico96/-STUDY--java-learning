import java.util.Iterator;
import java.util.Stack;

public class StackLearning extends DsaBaseClass {
  /**
   * Linear Data Structure
   * Follow LIFO principle (Last In First Out)
   * Only top elements are accessible
   * Insertion and deletion take place from the top
   * 4 major operations
   * push(element) - used to insert element to the top - O(1) constat in time
   * pop() - removes the top element from stack - O(1) constant in time
   * isEmpty() - returns true if stack is empty - O(1) constant in time
   * peek() - to get the top of element of stack - O(1) constant in time
   * *********************
   * Applications
   * Recursion
   * Parsing
   * Browser
   * Editors
   * *********************
   * Stack is an in-built structure in JAVA (Collection framework)
   * Stack extends Vector class which has the sort method
   * *********************
   * Advantages
   * Data mantains a LIFO order
   * Last element is readily available for use
   * All operations are O(1) complexity
   * *********************
   * Disadvantages
   * Manipulation is restricted to top of the Stack
   * Not much flexible
   */
  @Override
  public void excercise() {
    // Created Stack
    Stack<Integer> s1 = new Stack<Integer>();
    // Insert element
    s1.push(2);
    s1.push(3);
    s1.push(9);
    s1.push(4);
    s1.push(1);
    System.out.println(s1);
    // Deleting element
    s1.pop();
    System.out.println(s1);
    // Peek operation
    System.out.println("Top of stack: " + s1.peek());
    // Check emptiness
    boolean status = s1.empty();
    System.out.println("Empty: " + status);
    // Search
    int idx = s1.search(4);
    if (idx == -1) {
      System.out.println("4 not found");
    } else {
      System.out.println("4 found at index: " + idx);
    }
    // Iterating stack
    Iterator<Integer> it = s1.iterator();
    while (it.hasNext()) {
      System.out.println("Stack Element: " + it.next());
    }
    // Size
    System.out.println("Size of stack: " + s1.size());
    // Sort
    s1.sort(null);
    System.out.println("Sorted stack: " + s1);
  }

}
