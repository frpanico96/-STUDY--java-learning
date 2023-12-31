package DSA;

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
   * Revolves around comparison
   * In each iteration minimum element is placed at the beginning
   * 
   * selectionSort(arr)
   * iterate (n-1)times
   * set the first unsorted elements as first index
   * for each unsorted elements
   * if element < currentMin
   * set element's index as new min
   * swap element at min with first unsorted position
   * 
   * Best Time Complexity: O(n^2)
   * Average Time Complexity: O(n^2)
   * Worst Time Complexity: O(n^2)
   * Space complexity: O(1)
   * It is not guaranteed stability
   * Inplace: No extra/ausiliary memory needed
   * *********************
   * Quick Sort
   * One of the most widely used algorithm
   * Follows divide and conquer paradigm
   * Recursive algorithm
   * In each recursion
   * A pivot is chosen to partition the array
   * The pivot occupies the correct position
   * Pivot can be first, last or any random element
   * 
   * quickSort(arr, beginning, end)
   * if(beginning < end)
   * pivotindex = partition(arr, beginning, end)
   * quickSort(arr, beginning, pivotIndex - 1)
   * quickSort(arr, pivotIndex + 1, end)
   * 
   * partition(arr, beginning, end)
   * set end as pivot
   * pIndex = beginning - 1
   * for i = beginning to end-1
   * if arr[i] < pivot
   * pIndex ++
   * swap arr[i] and arr[pIndex]
   * swap pivot and arr[pIndex + 1]
   * return pIndex + 1
   * 
   * Best Time Complexity: O(nlogn)
   * Average Time Complexity: O(nlogn)
   * Worst Time Complexity: O(n^2)
   * Space complexity: O(n) basic appoach, O(logn) modified approach
   * Unstable algorithm
   * Inplace: No extra/ausiliary memory needed
   * *********************
   * Merge Sort
   * The problem is divided in two subproblems in each iteration
   * efficiency is increased drastically
   * divide and conquer approach
   * 
   * mergeSort(arr, left, right)
   * if left >= right
   * return
   * mid = (left + right)/2
   * mergeSort(arr, left, mid)
   * mergeSort(arr, mid, right)
   * merg(arr, left, mid + 1, right)
   * 
   * Merge
   * Create 2 subarrays Left and Right
   * Create 3 iterator i, j, k
   * Insert elements in Left and Right (i & j)
   * k - replace values in the original array
   * Pick lerger element from Left and Right and place in the correct position
   * If no elements in Left or Right
   * insert remaining element in original array
   */
  @Override
  public void excercise() {
    System.out.print("Initial Array:");
    int[] a1 = new int[] { 23, 16, 10, 11, 20, 11 };
    int[] arrayToSort = a1.clone();
    printArray(a1);
    System.out.print("[Insertion Sort] Sorted Array: ");
    insertionSort(arrayToSort);
    arrayToSort = a1.clone();
    System.out.print("[Selection Sort] Sorted Array: ");
    selectionSort(arrayToSort);
    arrayToSort = a1.clone();
    System.out.print("[Quick Sort] Sorted Array: ");
    quickSort(arrayToSort, 0, arrayToSort.length - 1);
    printArray(arrayToSort);
    arrayToSort = a1.clone();
    System.out.print("[Merge Sort] Sorted Array: ");
    mergeSort(arrayToSort, 0, arrayToSort.length - 1);
    printArray(arrayToSort);
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

  void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; ++i) {
      int minIndex = i;
      int min = arr[i];
      for (int j = i + 1; j < arr.length; ++j) {
        if (arr[j] < min) {
          minIndex = j;
        }
      }
      arr[minIndex] = min;
      arr[i] = arr[minIndex];
    }
    printArray(arr);
  }

  void quickSort(int[] arr, int beginning, int end) {
    if (beginning < end) {
      int pivotIndex = partition(arr, beginning, end);
      quickSort(arr, beginning, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, end);
    }
  }

  int partition(int[] arr, int beginning, int end) {
    int pivot = arr[end];
    int pIndex = beginning - 1;
    for (int i = beginning; i < end; ++i) {
      if (arr[i] < pivot) {
        ++pIndex;
        int tmp = arr[i];
        arr[i] = arr[pIndex];
        arr[pIndex] = tmp;
      }
    }
    arr[end] = arr[pIndex + 1];
    arr[pIndex + 1] = pivot;
    return pIndex + 1;
  }

  void mergeSort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    int mid = (start + end) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start, mid, end);
  }

  void merge(int[] arr, int start, int mid, int end) {
    int i, j, k;
    int lsize = mid - start + 1;
    int rsize = end - mid;
    int[] left = new int[lsize];
    int[] right = new int[rsize];
    for (i = 0; i < left.length; ++i) {
      left[i] = arr[start + i];
    }
    for (j = 0; j < right.length; ++j) {
      right[j] = arr[mid + 1 + j];
    }
    i = j = 0;
    k = start;
    while (i < lsize && j < rsize) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        ++i;
      } else {
        arr[k] = right[j];
        ++j;
      }
      ++k;
    }
    while (i < lsize) {
      arr[k] = left[i];
      i++;
      k++;
    }
    while (j < rsize) {
      arr[k] = right[j];
      j++;
      k++;
    }
  }

  void printArray(int[] arr) {
    for (int i = 0; i < arr.length; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.print("\n");
  }
}
