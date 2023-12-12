import java.util.Scanner;

public class SearchAlgoLearning extends DsaBaseClass {
  /**
   * *********************
   * Linear Search Algorithm
   * Helps search element in a linear data structure
   * It checks each and every element of the data structure
   * 
   * linearSearch(arr, item)
   * for each element in array
   * if item == element
   * return its index
   * return -1
   * 
   * Brute force algorithm
   * Best Time Complexity: O(1)
   * Average Time Complexity: O(n)
   * Worst Time Complexity: O(n)
   * Space Complexity: O(1)
   * *********************
   * Binary search algorithm
   * It can be used on sorted arrays
   * Follows divide and conquer strategy
   * space always reduce to half in every iteration
   * Very efficien technique
   * Requires order on which partition the array will occur
   * 
   * Iterative Algorithm
   * binarySearch(arr, item)
   * loop until beginning < end
   * midIndex =(beginning + end)/2
   * if(item == arr[midIndex])
   * return midIndex
   * else if(item > arr[midIndex])
   * beg = midIndex + 1
   * else
   * end = midIndex - 1
   * 
   * Recursive Algorithm
   * binarySearch(arr, item, beg, end)
   * if beg <= end
   * midIndex = (beg + end)/2
   * if item == arr[midIndex]
   * return midIndex
   * else if(arr[midIndex] > item)
   * return binarySearch(arr, item, beg, midIndex - 1)
   * else
   * return binarySearch(arr, item, midIndex + 1, end)
   * 
   * Best Time Complexity: O(1)
   * Average Time Complexity: O(log(n))
   * Worst Time Complexity: O(log(n))
   * Space Complexity O(1)
   */

  @Override
  public void excercise() {
    int[] a1 = new int[] { 6, 4, 3, 5, 8, 1, 2 };
    int[] a2 = new int[] { 10, 20, 30, 40, 50, 60 };
    Scanner s1 = new Scanner(System.in);
    // System.out.print("Enter element to search: ");
    int key = 2;
    System.out.println("[Linear Search] Element is at index: " + linearSearch(a1, key));
    System.out.println("[Binary Search] Element is at index: " + binarySearch(a2, key, 0, a2.length - 1));
    s1.close();
  }

  int linearSearch(int[] arr, int item) {
    for (int i = 0; i < arr.length; ++i) {
      if (arr[i] == item) {
        return i;
      }
    }
    return -1;
  }

  int binarySearch(int[] arr, int item, int first, int last) {
    if (first <= last) {
      int midIndex = (first + last) / 2;
      if (arr[midIndex] == item) {
        return midIndex;
      }
      if (arr[midIndex] > item) {
        return binarySearch(arr, item, first, midIndex - 1);
      } else {
        return binarySearch(arr, item, midIndex + 1, last);
      }

    }

    return -1;
  }

}
