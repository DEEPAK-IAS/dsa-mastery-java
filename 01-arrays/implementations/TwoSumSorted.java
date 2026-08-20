import java.util.Arrays;

public class TwoSumSorted {

  public static int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      return new int[] { -1, -1 };
    }

    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
      int currentSum = numbers[left] + numbers[right];

      if (currentSum == target) {
        return new int[] { left, right };
      }
      if (currentSum < target) {
        left++;
      }
      if (currentSum > target) {
        right--;
      }
    }

    return new int[] { -1, -1 }; // Pair not found
  }

  public static void main(String[] args) {
    int[] numbers = { 2, 7, 11, 15 };
    int target = 9;

    int[] result = twoSum(numbers, target);

    System.out.println("Original Array: " + Arrays.toString(numbers));
    System.out.println("Target: " + target);
    System.out.println("Found Indices: " + Arrays.toString(result));
  }
}