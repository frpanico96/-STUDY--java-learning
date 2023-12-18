package DSA;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class LinkedListLearning extends DsaBaseClass {
  /**
   * *********************
   * Linear Data Structure
   * Elements can be stored as per memory availability
   * Can access elements in linear fashion only
   * Store homogeneous elements
   * Dynamic in size
   * Easy insertion and deletion
   * Starting element or head is the key which is generally termed as head
   * *********************
   * Applications
   * Suitable when memory is limited
   * Suitable for application that requires frequent insertion and deletion
   * *********************
   * Types of linked list
   * Singly LinkedList
   * Head -> Node (data + link) -> Node (data + link)
   * link points to next node, null if last node
   * Doubly LinkedList
   * Head -> Node (data + link) -> Node (data + link)
   * node contains previous and next node link
   * first previous = last next = null
   * Circular LinkedList
   * Head -> Node (data + link) -> Node (data + link) -> 1st Node
   * last node contains the link to first node
   * *********************
   * Advantages
   * Dynamic in size
   * No wastage as capacity and size are equal
   * Easy insertion and deletion as 1 link manipulation is required
   * Efficient memory allocation
   * *********************
   * Disadvantages
   * if head is lost, linkedlist is lost
   * No random access is possible
   */
  @Override
  public void excercise() {
    LinkedList<Integer> l1 = new LinkedList<Integer>();
    // adding elements to linkedlist
    l1.add(3);
    l1.add(7);
    l1.add(10);
    l1.add(4);
    l1.add(5);
    l1.add(8);
    l1.add(2, 6);
    System.out.print("LinkedList: " + l1 + "\n");
    // remove elements from linkedlist
    l1.remove(2);
    l1.removeFirst();
    l1.removeLast();
    // loop through linkedlist
    System.out.print("LinkedList: ");
    Iterator<Integer> it = l1.iterator();
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.print("\n");
    System.out.print("Size of LinkedList: " + l1.size() + "\n");
    System.out.print("Linked list contains 7: " + l1.contains(7) + "\n");
    System.out.print("Linked list contains 9: " + l1.contains(9) + "\n");

    // Copy elements from Stack to LinkedList
    Stack<String> s1 = new Stack<>();
    LinkedList<String> l2 = new LinkedList<>();
    s1.push("hello");
    s1.push("everyone");
    l2.addAll(s1);
    System.out.print("LinkedList created from Stack : " + l2 + "\n");

    System.out.println("@@@ Circular Linked List");
    CircularLinkedList c1 = new CircularLinkedList();
    c1.insertNode(2);
    c1.insertNode(3);
    c1.insertNode(1);
    c1.display();
    c1.deleteNode();
    c1.display();
    c1.deleteNode();
    c1.display();
    c1.deleteNode();
    c1.display();
  }

  // Circular Linked List
  class CircularLinkedList {
    Node head, tail;

    class Node {
      int data;
      Node next;

      Node(int data) {
        this.data = data;
      }
    }

    void insertNode(int data) {
      Node newNode = new Node(data);
      // First insertion
      if (head == null) {
        head = newNode;
        tail = newNode;
        tail.next = newNode;
        return;
      }
      tail.next = newNode;
      tail = newNode;
      tail.next = head;
    }

    void display() {
      Node n1 = head;
      if (tail == null && head == null) {
        System.out.println("Circular LinkedList is empty!");
        return;
      }
      System.out.print("Circular LinkedList: ");
      do {
        System.out.print(" -> " + n1.data);
        n1 = n1.next;
      } while (head != n1);
      System.out.print(" ->\n");
    }

    // Delete from head
    void deleteNode() {
      // Last element
      if (tail == head) {
        head = tail = null;
        return;
      }
      head = head.next;
      tail.next = head;
    }

  }
}
