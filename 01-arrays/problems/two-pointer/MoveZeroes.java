import java.util.Arrays;

public class MoveZeroes {

    /*
     * 
     * Complexity AnalysisTime Complexity: $O(n)$ — The fast loop runs $n$ times,
     * and the while loop fills at most $n$ zeroes. Total iterations $\le 2n$, which
     * simplifies to linear $O(n)$ time.Auxiliary Space Complexity: $O(1)$ —
     * Performs all modifications in-place using only two integer pointers.
     */

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int slow = 0; // Tracks placement position for non-zero values

        // Step 1: Shift non-zero elements forward
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // Step 2: Fill remaining elements with zeroes from `slow` to end
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };

        System.out.println("Original: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Result:   " + Arrays.toString(nums));
    }
}