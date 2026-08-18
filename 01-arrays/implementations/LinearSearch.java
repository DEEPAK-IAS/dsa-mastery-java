import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    /*
     * ============================================================
     * 1. LINEAR SEARCH
     * ============================================================
     *
     * Finds the first occurrence of target.
     *
     * Example:
     * numbers = {10, 20, 30, 40}
     * target  = 30
     * result  = 2
     *
     * Time Complexity:
     * Best Case    : O(1)
     * Average Case : O(n)
     * Worst Case   : O(n)
     *
     * Space Complexity:
     * O(1)
     */
    public static int linearSearch(int[] numbers, int target) {

        if (numbers == null) {
            return -1;
        }

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {
                return i;
            }
        }

        return -1;
    }


    /*
     * ============================================================
     * 2. FIND ALL OCCURRENCES
     * ============================================================
     *
     * Finds all indexes where target occurs.
     *
     * Example:
     * numbers = {1, 5, 3, 5, 7, 5}
     * target  = 5
     *
     * result = [1, 3, 5]
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(k)
     *
     * k = number of occurrences of target
     */
    public static List<Integer> findAllOccurrences(
            int[] numbers,
            int target) {

        List<Integer> indexes = new ArrayList<>();

        if (numbers == null) {
            return indexes;
        }

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {
                indexes.add(i);
            }
        }

        return indexes;
    }


    /*
     * ============================================================
     * 3. COUNT OCCURRENCES
     * ============================================================
     *
     * Counts how many times target appears in the array.
     *
     * Example:
     * numbers = {1, 5, 3, 5, 7, 5}
     * target  = 5
     *
     * result = 3
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     */
    public static int countOccurrences(
            int[] numbers,
            int target) {

        if (numbers == null) {
            return 0;
        }

        int count = 0;

        for (int element : numbers) {

            if (element == target) {
                count++;
            }
        }

        return count;
    }


    /*
     * ============================================================
     * 4. FIND MAXIMUM
     * ============================================================
     *
     * Finds the largest element in the array.
     *
     * Example:
     * numbers = {10, 5, 30, 20}
     * result  = 30
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     */
    public static int findMax(int[] numbers) {

        validateArray(numbers);

        int max = numbers[0];

        for (int element : numbers) {

            if (element > max) {
                max = element;
            }
        }

        return max;
    }


    /*
     * ============================================================
     * 5. FIND MINIMUM
     * ============================================================
     *
     * Finds the smallest element in the array.
     *
     * Example:
     * numbers = {10, 5, 30, 20}
     * result  = 5
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     */
    public static int findMin(int[] numbers) {

        validateArray(numbers);

        int min = numbers[0];

        for (int element : numbers) {

            if (element < min) {
                min = element;
            }
        }

        return min;
    }


    /*
     * ============================================================
     * ARRAY VALIDATION
     * ============================================================
     *
     * Used by findMax() and findMin().
     *
     * Time Complexity:
     * O(1)
     *
     * Space Complexity:
     * O(1)
     */
    private static void validateArray(int[] numbers) {

        if (numbers == null || numbers.length == 0) {

            throw new IllegalArgumentException(
                    "Array cannot be null or empty"
            );
        }
    }


    /*
     * ============================================================
     * MAIN METHOD
     * ============================================================
     */
    public static void main(String[] args) {

        int[] numbers = {
                1, 2, 3, 4, 5,
                5, 6, 5, 7, 5
        };


        // 1. Linear Search
        System.out.println(
                "First occurrence of 3: "
                        + linearSearch(numbers, 3)
        );


        // 2. Find All Occurrences
        System.out.println(
                "Indexes of 5: "
                        + findAllOccurrences(numbers, 5)
        );


        // 3. Count Occurrences
        System.out.println(
                "Count of 5: "
                        + countOccurrences(numbers, 5)
        );


        // 4. Find Maximum
        System.out.println(
                "Maximum value: "
                        + findMax(numbers)
        );


        // 5. Find Minimum
        System.out.println(
                "Minimum value: "
                        + findMin(numbers)
        );
    }
}