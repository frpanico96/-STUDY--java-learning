import java.util.Arrays;

public class ArrayLearning extends DsaBaseClass {
  /**
   * Linear Data Structure
   * Contiguos memory location
   * Access element randomly
   * homogeneous elements i.e. similar elements
   * Storing information - linear fashion
   * Suitable for applications that require frequentsearching
   * *********************
   * 1 - dimensional array
   * 1D can be related to a row
   * Elements are store one after the other
   * Only one subscript or index is used
   * Declaration
   * Datatype varname[size]
   * Datatype varname [] = {el1, el2, el3, el4}
   * *********************
   * 2 - Dimensional Array
   * 2D can be related to a table or matrix
   * Elements are store one after the other
   * Two subscripts or indeces are use
   * *********************
   * Advantages
   * Random Access elements
   * Easy sorting and searching
   * Replacement of multiple variables
   * *********************
   * Size is fixed
   * Difficult to insert and delete
   * if capacity is more and occupancy is less, most of the array gets wasted
   * Needs contiguous memory
   */

  @Override
  public void excercise() {
    int[] a1 = new int[6];
    System.out.print("1dArray elements: ");
    for (int i = 0; i < a1.length; ++i) {
      a1[i] = i;
      System.out.print(a1[i] + " ");
    }
    System.out.print("\n");

    int[][] a2 = new int[3][4];
    System.out.println("2dArray elements");
    for (int i = 0; i < a2.length; ++i) {
      for (int j = 0; j < a2[i].length; ++j) {
        a2[i][j] = (i * 4) + j;
        System.out.print(a2[i][j] + "\t");
      }
      System.out.print("\n");
    }

    arraySort();
    System.out.print("Starting array: ");
    for (int i = 0; i < a1.length; ++i) {
      System.out.print(a1[i] + " ");
    }
    System.out.print("\n");
    int searchKey = 3;
    int searchIndex = linearSearch(a1, searchKey);
    if (searchIndex > -1)
      System.out.println("Found: " + searchKey + " at index: " + searchIndex);
    else
      System.out.println("Key " + searchKey + " not found");
    searchKey = 10;
    searchIndex = linearSearch(a1, searchKey);
    if (searchIndex > -1)
      System.out.println("Found: " + searchKey + " at index: " + searchIndex);
    else
      System.out.println("Key " + searchKey + " not found");
  }

  private void arraySort() {
    int[] a1 = new int[] { 3, 6, 2, 9, 5, 8, 1 };
    System.out.print("Starting Array: ");
    for (int i = 0; i < a1.length; ++i) {
      System.out.print(a1[i] + " ");
    }
    Arrays.sort(a1);
    System.out.print("\nSorted Array: ");
    for (int i = 0; i < a1.length; ++i) {
      System.out.print(a1[i] + " ");
    }
    System.out.print("\n");
  }

  private int linearSearch(int a[], int key) {
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == key)
        return i;
    }
    return -1;
  }

}
