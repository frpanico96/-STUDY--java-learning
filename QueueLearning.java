public class QueueLearning extends DsaBaseClass {
  /**
   * Linear Data Structure
   * Follows FIFO principle: First In First Out
   * Insertion can take place from rear end
   * Deletion can take place from front end
   * 4 major operations:
   * enqueue(element) - used to insert element at rear end
   * dequeue() - removes element at front end
   * peekfirst() - get first element of the queue (front end)
   * peeklast() - get last element of the queue (rear end)
   * All operations are O(1) complexity
   * *********************
   * Applications
   * Scheduling
   * Mantaining playlist
   * Interrupt handling
   * *********************
   * Queue is a built-in JAVA Interface
   * it has to be extended by interfaces and classes
   * Queue belongs to collection package of JAVA
   * before implementing enqueue/dequeue emptiness of queue need to be checked
   * *********************
   * Advantages
   * Mantains data in FIFO fashion
   * Insertion and deletion is O(1)
   * *********************
   * Disadvantages
   * Manipulation is restricted front and rear
   * Not much flexible
   */
  @Override
  public void excercise() {
    QueueUsingArray q1 = new QueueUsingArray(5);
    q1.enqueu(2);
    q1.enqueu(3);
    q1.enqueu(4);
    q1.enqueu(1);
    q1.enqueu(0);
    q1.enqueu(6);
    q1.display();
    q1.dequeue();
    q1.dequeue();
    q1.dequeue();
    q1.dequeue();
    q1.display();
    q1.dequeue();
    q1.dequeue();
    q1.display();

  }

  class QueueUsingArray {
    int front = 0, rear = 0;
    int capacity;
    int[] queue;

    QueueUsingArray(int size) {
      capacity = size;
      queue = new int[capacity];
    }

    void enqueu(int value) {
      if (rear == capacity) {
        System.out.println("Queue is full!");
        return;
      }
      queue[rear] = value;
      ++rear;
    }

    void dequeue() {
      if (rear == 0) {
        System.out.println("Queue is empty!");
        return;
      }
      for (int i = 0; i < rear - 1; ++i) {
        queue[i] = queue[i + 1];
      }
      --rear;
    }

    void display() {
      if (rear == 0) {
        System.out.println("Queue is empty!");
        return;
      }
      System.out.print("Queue: | ");
      for (int i = 0; i < rear; ++i) {
        System.out.print(queue[i] + " | ");
      }
      System.out.print("\n");
    }

  }
}
