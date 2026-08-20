import java.util.Arrays;

public class ArrayInsertion {

    /*
     * ============================================================
     * INSERT AT BEGINNING
     * ============================================================
     *
     * Example:
     *
     * [10, 20, 30]
     * insert 5
     *
     * [5, 10, 20, 30]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] insertAtBeginning(
            int[] numbers,
            int value) {

        validateArray(numbers);

        int[] newNumbers =
                new int[numbers.length + 1];

        newNumbers[0] = value;

        for (int i = 1; i < newNumbers.length; i++) {
            newNumbers[i] = numbers[i - 1];
        }

        return newNumbers;
    }


    /*
     * ============================================================
     * INSERT AT END
     * ============================================================
     *
     * Example:
     *
     * [10, 20, 30]
     * insert 40
     *
     * [10, 20, 30, 40]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] insertAtEnd(
            int[] numbers,
            int value) {

        validateArray(numbers);

        int[] newNumbers =
                new int[numbers.length + 1];

        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i];
        }

        newNumbers[numbers.length] = value;

        return newNumbers;
    }


    /*
     * ============================================================
     * INSERT AT INDEX
     * ============================================================
     *
     * Example:
     *
     * [10, 20, 40, 50]
     *
     * index = 2
     * value = 30
     *
     * Result:
     *
     * [10, 20, 30, 40, 50]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] insertAtIndex(
            int[] numbers,
            int value,
            int index) {

        validateArray(numbers);

        if (index < 0 || index > numbers.length) {
            throw new IndexOutOfBoundsException(
                    "Invalid insertion index: " + index
            );
        }

        int[] newNumbers =
                new int[numbers.length + 1];

        // Copy elements before index
        for (int i = 0; i < index; i++) {
            newNumbers[i] = numbers[i];
        }

        // Insert value
        newNumbers[index] = value;

        // Shift remaining elements right
        for (int i = index; i < numbers.length; i++) {
            newNumbers[i + 1] = numbers[i];
        }

        return newNumbers;
    }


    /*
     * ============================================================
     * VALIDATION
     * ============================================================
     */
    private static void validateArray(int[] numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException(
                    "Array cannot be null"
            );
        }
    }


    /*
     * ============================================================
     * MAIN
     * ============================================================
     */
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40};

        System.out.println(
                "Original: "
                        + Arrays.toString(numbers)
        );

        int[] beginning =
                insertAtBeginning(numbers, 5);

        System.out.println(
                "Beginning: "
                        + Arrays.toString(beginning)
        );

        int[] end =
                insertAtEnd(numbers, 50);

        System.out.println(
                "End: "
                        + Arrays.toString(end)
        );

        int[] middle =
                insertAtIndex(numbers, 25, 2);

        System.out.println(
                "Index 2: "
                        + Arrays.toString(middle)
        );
    }
}