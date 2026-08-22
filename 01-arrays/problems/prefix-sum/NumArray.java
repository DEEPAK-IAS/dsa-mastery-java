import java.util.Arrays;

public class NumArray {
    private int[] prefixSum;

    // Constructor to initialize the prefix sum array
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            prefixSum = new int[0];
            return;
        }

        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        // Build the prefix sum array
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // If left is 0, the sum is simply prefixSum[right]
        if (left == 0) {
            return prefixSum[right];
        }
        // Otherwise, subtract the prefix sum before 'left'
        return prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sum range [0, 2]: " + numArray.sumRange(0, 2)); // Expected: 1  (-2 + 0 + 3)
        System.out.println("Sum range [2, 5]: " + numArray.sumRange(2, 5)); // Expected: -1 (3 + -5 + 2 + -1)
        System.out.println("Sum range [0, 5]: " + numArray.sumRange(0, 5)); // Expected: -3
    }
}