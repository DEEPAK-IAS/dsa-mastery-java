import java.util.Arrays;

public class MinSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        // Step 1: Expand the window using the 'right' pointer
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Step 2: While the window satisfies the condition, shrink from the left
            while (currentSum >= target) {
                //  Update minLength with the current window size (right - left + 1)

                minLength = Math.min(minLength, right-left + 1);
                
                // Subtract nums[left] from currentSum and increment left
                currentSum -= nums[left];
                left++;
            }
        }

        // Step 3: If minLength was never updated, return 0; otherwise return minLength
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println("Target: " + target);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Min Subarray Length: " + minSubArrayLen(target, nums)); 
        // Expected output: 2 (from subarray [4, 3])
    }
}