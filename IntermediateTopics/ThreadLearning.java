package IntermediateTopics;

import java.io.IOException;

public class ThreadLearning extends BasicExcerices {
  @Override
  public void exercise() throws IOException {
    System.out.println("@@ Application Started @@");

    Printer printer = new Printer();

    /**
     * Starting a new Thread
     * The run method will be called not in the sequential way
     * the code appears
     * The task will start in a new parallel thread
     * the print @@ Application Finished @@
     * Will be likely to be print before the "doc printing" of the parallel thread
     */
    MyTask task = new MyTask(printer);
    task.start();

    /**
     * Synchronize the Thread
     * until "task" Thread is finished
     * no other Thread will be executed
     */
    // try {
    // task.join();
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }

    /**
     * Starting a new Thread
     * With the Runnable interface
     */
    Thread task2 = new Thread(new MySecondTask(printer));
    task2.start();

    System.out.println("@@ Application Finished @@");
  }
}

class MyTask extends Thread {

  Printer pRef;

  MyTask(Printer pRef) {
    this.pRef = pRef;
  }

  @Override
  public void run() {
    try {
      pRef.printDocuments(10, "document");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class CoreClass {

  Printer pRef;

  CoreClass(Printer pRef) {
    this.pRef = pRef;
  }

  public void execute() {
    try {
      pRef.printDocuments(10, "image");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class MySecondTask extends CoreClass implements Runnable {

  Printer pRef;

  MySecondTask(Printer pRef) {
    super(pRef);
  }

  @Override
  public void run() {
    execute();
    Thread childThread = new Thread(new MyThirdTask(super.pRef));
    childThread.start();
  }
}

class MyThirdTask implements Runnable {

  Printer pRef;

  MyThirdTask(Printer pRef) {
    this.pRef = pRef;
  }

  @Override
  public void run() {
    try {
      pRef.printDocuments(10, "xls");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Printer {
  /**
   * @param numOfCopies
   * @param docName
   * @throws InterruptedException
   * 
   *                              Antoher way to achieve synchronization
   *                              is via the synchronized keyword
   *                              it locks the method from being accessed from
   *                              other threads
   *                              that insist on this same method
   */
  synchronized void printDocuments(int numOfCopies, String docName) throws InterruptedException {
    for (int i = 1; i <= numOfCopies; ++i) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Printing " + docName + " # " + i);
    }
  }
}
