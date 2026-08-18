import java.util.Arrays;

public class ArrayTraversal {

  /**
   * Traverses the array from left to right.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void forwardTraversal(int[] numbers) {

    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }

  /**
   * Traverses the array from right to left.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void reverseTraversal(int[] numbers) {

    for (int i = numbers.length - 1; i >= 0; i--) {
      System.out.println(numbers[i]);
    }
  }

  /**
   * Traverses the array while displaying
   * both index and value.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void traversalWithIndex(int[] numbers) {

    for (int i = 0; i < numbers.length; i++) {

      int value = numbers[i];

      System.out.println(
          "Index " + i + " has value " + value);
    }
  }

  /**
   * Traverses the array using the enhanced for loop.
   *
   * Use this when you need the values but do not
   * need the index.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void traversalWithEnhancedLoop(int[] numbers) {

    for (int element : numbers) {
      System.out.println(element);
    }
  }

  /**
   * Traverses the array and modifies each element.
   *
   * This method doubles every value in the original array.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void traverseAndModify(int[] numbers) {

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = numbers[i] * 2;
    }

    System.out.println(Arrays.toString(numbers));
  }

  /**
   * Finds the first occurrence of a target value.
   *
   * Returns:
   * - index of the first occurrence
   * - -1 if the target does not exist
   *
   * Time Complexity:
   * Best: O(1)
   * Worst: O(n)
   *
   * Space Complexity: O(1)
   */
  public static int findIndex(int[] numbers, int target) {

    for (int i = 0; i < numbers.length; i++) {

      if (numbers[i] == target) {
        return i;
      }
    }

    return -1;
  }

  /**
   * Traverses a portion of the array.
   *
   * start -> inclusive
   * end -> exclusive
   *
   * Example:
   * start = 1
   * end = 4
   *
   * Traverses indexes:
   * 1, 2, 3
   *
   * Time Complexity: O(end - start)
   * Space Complexity: O(1)
   */
  public static void traverseRange(
      int[] numbers,
      int start,
      int end) {

    if (start < 0 || end > numbers.length || start > end) {
      throw new IllegalArgumentException(
          "Invalid range: start=" + start + ", end=" + end);
    }

    for (int i = start; i < end; i++) {
      System.out.println(numbers[i]);
    }
  }

  public static void main(String[] args) {

    int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };

    System.out.println("=== Forward Traversal ===");

    forwardTraversal(numbers);

    System.out.println("\n=== Reverse Traversal ===");

    reverseTraversal(numbers);

    System.out.println("\n=== Traversal With Index ===");

    traversalWithIndex(numbers);

    System.out.println("\n=== Enhanced For Loop ===");

    traversalWithEnhancedLoop(numbers);

    System.out.println("\n=== Find Index ===");

    System.out.println(
        "Index of 4: " + findIndex(numbers, 4));

    System.out.println(
        "Index of 100: " + findIndex(numbers, 100));

    System.out.println("\n=== Range Traversal ===");

    // Start inclusive, end exclusive.
    traverseRange(numbers, 0, 4);

    System.out.println("\n=== Traverse and Modify ===");

    int[] values = { 1, 2, 3, 4, 5 };

    traverseAndModify(values);
  }
}