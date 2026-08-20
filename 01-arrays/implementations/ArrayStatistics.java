public class ArrayStatistics {

    /**
     * Finds the sum of all elements.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findSum(int[] numbers) {
        validateArray(numbers);

        int sum = 0;

        for (int element : numbers) {
            sum += element;
        }

        return sum;
    }


    /**
     * Finds the average of all elements.
     *
     * Important:
     * Use double division to preserve decimal values.
     *
     * Example:
     * [1, 2] -> 1.5, not 1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static double findAverage(int[] numbers) {
        validateArray(numbers);

        int sum = 0;

        for (int element : numbers) {
            sum += element;
        }

        return (double) sum / numbers.length;
    }


    /**
     * Counts even numbers.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countEvenNumbers(int[] numbers) {
        validateArray(numbers);

        int count = 0;

        for (int element : numbers) {
            if (element % 2 == 0) {
                count++;
            }
        }

        return count;
    }


    /**
     * Counts odd numbers.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countOddNumbers(int[] numbers) {
        validateArray(numbers);

        int count = 0;

        for (int element : numbers) {
            if (element % 2 != 0) {
                count++;
            }
        }

        return count;
    }


    /**
     * Counts positive numbers.
     *
     * Zero is neither positive nor negative.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countPositiveNumbers(int[] numbers) {
        validateArray(numbers);

        int count = 0;

        for (int element : numbers) {
            if (element > 0) {
                count++;
            }
        }

        return count;
    }


    /**
     * Counts negative numbers.
     *
     * Zero is neither positive nor negative.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countNegativeNumbers(int[] numbers) {
        validateArray(numbers);

        int count = 0;

        for (int element : numbers) {
            if (element < 0) {
                count++;
            }
        }

        return count;
    }


    /**
     * Validates that the array exists and contains at least one element.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    private static void validateArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException(
                    "Array cannot be null or empty"
            );
        }
    }


    public static void main(String[] args) {

        int[] numbers = {10, -5, 20, 3, -2, 8};

        System.out.println("Array: [10, -5, 20, 3, -2, 8]");

        System.out.println("Sum: "
                + findSum(numbers));

        System.out.println("Average: "
                + findAverage(numbers));

        System.out.println("Even count: "
                + countEvenNumbers(numbers));

        System.out.println("Odd count: "
                + countOddNumbers(numbers));

        System.out.println("Positive count: "
                + countPositiveNumbers(numbers));

        System.out.println("Negative count: "
                + countNegativeNumbers(numbers));
    }
}
