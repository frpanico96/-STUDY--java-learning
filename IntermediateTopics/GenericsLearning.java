package IntermediateTopics;

import java.io.IOException;
import java.util.ArrayList;

public class GenericsLearning extends BasicExcerices {
  @Override
  public void exercise() throws IOException {
    Container<Integer> integerContainer = new Container<Integer>();
    integerContainer.setValue(3);
    ;
    integerContainer.show();

    Container<String> stringContainer = new Container<String>();
    stringContainer.setValue("Hello");
    ;
    stringContainer.show();

    Integer[] a = { 100, 22, 58, 41, 6, 50 };

    Character[] c = { 'v', 'g', 'a', 'c', 'x', 'd', 't' };

    String[] s = { "Virat", "Rohit", "Abhinay", "Chandu", "Sam", "Bharat", "Kalam" };

    sortGeneric(a);
    sortGeneric(c);
    sortGeneric(s);

  }

  class Container<T> {
    T value;

    void show() {
      System.out.println(value.getClass().getName());
    }

    void setValue(T value) {
      this.value = value;
    }

    /**
     * This defines an arraylist which type
     * can be any class that extends Number
     * Integer, Float, Double, exc.
     */
    void demoExtend(ArrayList<? extends Number> obj) {

    }

    /**
     * This defines an arraylist which type
     * can be any super class of T
     */
    void demoSuper(ArrayList<? super T> obj) {

    }
  }

  /**
   * Example of generic bubble sort method
   */
  <T extends Comparable<T>> void sortGeneric(T[] a) {
    // As we are comparing non-primitive data types
    // We have to use Comparable class
    for (int i = 0; i < a.length - 1; ++i) {
      for (int j = 0; j < a.length - i - 1; ++j) {
        if (a[j].compareTo(a[j + 1]) > 0) {
          swap(j, j + 1, a);
        }
      }
    }
    System.out.print("Generic sorted array: ");
    for (T i : a) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  <T> void swap(int i, int j, T[] a) {
    T tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
