public class MinMax {

  public static int findMin(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }

    int min = numbers[0];
    for (int element : numbers) {
      if (element < min) {
        min = element;
      }
    }
    return min;

  }

  public static int findMax(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int max = numbers[0];
    for (int element : numbers) {
      if (element > max) {
        max = element;
      }
    }
    return max;
  }

  public static int findMinIndex(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int minIndex = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[minIndex] > numbers[i]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public static int findMaxIndex(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int maxIndex = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[maxIndex] < numbers[i]) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  public static void findMinAndMax(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
    int min = numbers[0];
    int max = numbers[0];
    for (int element : numbers) {
      if (min > element) {
        min = element;
      }
      if (max < element) {
        max = element;
      }
    }
    System.out.println(min + "," + max);
  }

  public static void main(String[] args) {

    int[] numbers = { 10, 5, 20, 3, 15 };
    System.out.println(findMax(numbers));
    int [] numbers1 = {-10, -5, -20, -3};
    System.out.println(findMin(numbers1));
  }

}
