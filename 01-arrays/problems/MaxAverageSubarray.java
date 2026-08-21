import java.util.Arrays;

public class MaxAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0.0;
        }

        // Step 1: Compute the sum of the first window of size k
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxSum = currentSum;

        // Step 2: Slide the window from index k to the end of the array
        for (int i = k; i < nums.length; i++) {
            // Add the new element entering the window on the right,
            // and subtract the old element leaving the window on the left.
            currentSum = currentSum + nums[i] - nums[i - k];
            
            // Update maxSum if the current window sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        // Step 3: Return the maximum average (maxSum divided by k)
        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("Max Average: " + findMaxAverage(nums, k)); 
        // Expected output: 12.75 (Subarray: [-5, -6, 50, 3] -> sum 42 / 4 = 10.5? Wait, let's trace: [12, -5, -6, 50] -> sum 51 / 4 = 12.75)
    }
}