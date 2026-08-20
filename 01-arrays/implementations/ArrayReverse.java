import java.util.Arrays;

public class ArrayReverse {

    /**
     * Reverses the array in-place.
     *
     * Example:
     * [1, 2, 3, 4, 5]
     * becomes
     * [5, 4, 3, 2, 1]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverse(int[] numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException(
                    "Array cannot be null"
            );
        }

        for (int i = 0; i < numbers.length / 2; i++) {

            int temp = numbers[i];

            numbers[i] = numbers[numbers.length - 1 - i];

            numbers[numbers.length - 1 - i] = temp;
        }
    }


    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6};

        reverse(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}