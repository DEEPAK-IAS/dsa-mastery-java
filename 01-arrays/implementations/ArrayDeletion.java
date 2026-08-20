import java.util.Arrays;

public class ArrayDeletion {

    /**
     * Deletes the first element of the array.
     * Time Complexity:  O(n)
     * Space Complexity: O(n) auxiliary space
     */
    public static int[] deleteAtBeginning(int[] numbers) {
        validateArray(numbers);

        int[] newNumbers = new int[numbers.length - 1];
        for (int i = 1; i < numbers.length; i++) {
            newNumbers[i - 1] = numbers[i];
        }
        return newNumbers;
    }

    /**
     * Deletes the last element of the array.
     * Time Complexity:  O(n)
     * Space Complexity: O(n) auxiliary space
     */
    public static int[] deleteAtEnd(int[] numbers) {
        validateArray(numbers);

        int[] newNumbers = new int[numbers.length - 1];
        for (int i = 0; i < newNumbers.length; i++) {
            newNumbers[i] = numbers[i];
        }
        return newNumbers;
    }

    /**
     * Deletes the element at a specified index.
     * Time Complexity:  O(n)
     * Space Complexity: O(n) auxiliary space
     */
    public static int[] deleteAtIndex(int[] numbers, int index) {
        validateArray(numbers);

        if (index < 0 || index >= numbers.length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        int[] newNumbers = new int[numbers.length - 1];

        // Copy elements before target index
        for (int i = 0; i < index; i++) {
            newNumbers[i] = numbers[i];
        }

        // Copy elements after target index (shifted left by 1)
        for (int i = index + 1; i < numbers.length; i++) {
            newNumbers[i - 1] = numbers[i];
        }

        return newNumbers;
    }

    /**
     * Deletes the first occurrence of a specific value.
     * Time Complexity:  O(n)
     * Space Complexity: O(n) auxiliary space
     */
    public static int[] deleteByValue(int[] numbers, int value) {
        validateArray(numbers);

        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                index = i;
                break; // Found first occurrence
            }
        }

        // If value was not found, return original array
        if (index == -1) {
            return numbers;
        }

        return deleteAtIndex(numbers, index);
    }

    private static void validateArray(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Cannot delete from an empty array");
        }
    }

    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Delete Beginning: " + Arrays.toString(deleteAtBeginning(original)));
        System.out.println("Delete End: " + Arrays.toString(deleteAtEnd(original)));
        System.out.println("Delete Index 2: " + Arrays.toString(deleteAtIndex(original, 2)));
        System.out.println("Delete Value 40: " + Arrays.toString(deleteByValue(original, 40)));
        System.out.println("Delete Missing Value (99): " + Arrays.toString(deleteByValue(original, 99)));
    }
}