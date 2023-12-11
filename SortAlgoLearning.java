public class SortAlgoLearning extends DsaBaseClass {
  /**
   * *********************
   * Insertion Sort
   * It is one of the easiest and brute force sorting algorithms
   * Sort in either ascending or descending order
   * A sorted part and an unsorted part is mantained
   * With every iteration the unsorted part is moved to sorted part
   * First elemtn is pick and considered sorted
   * 
   * insertionSort(arr, size)
   * for each element i=2 to i=n-1
   * tmp = arr[i]
   * for j-1 to 0
   * if a[j] > tmp
   * right shift it by one position
   * put tmp at current j
   * 
   * Best Time Complexity: O(n)
   * Average Time Complexity: O(n^2)
   * Worst Time Complexity: O(n^2)
   * Space complexity: O(1)
   * Stable: relation of repeated number remains intact
   * Inplace: No extra/ausiliary memory needed
   * *********************
   * Selection Sort
   */
  @Override
  public void excercise() {
    System.out.print("Initial Array:");
    int[] a1 = new int[] { 23, 16, 10, 11, 20 };
    printArray(a1);
    System.out.print("[Insertion Sort] Sorted Array:");
    insertionSort(a1);
  }

  void insertionSort(int[] arr) {
    for (int i = 0; i < arr.length; ++i) {
      int tmp = arr[i];
      int j = i - 1;
      while (j >= 0 && tmp <= arr[j]) {
        arr[j + 1] = arr[j];
        arr[j] = tmp;
        --j;
      }
    }
    printArray(arr);
  }

  void printArray(int[] arr) {
    for (int i = 0; i < arr.length; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.print("\n");
  }
}
