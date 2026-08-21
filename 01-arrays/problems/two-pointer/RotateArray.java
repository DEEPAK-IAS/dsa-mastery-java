import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return;
        }

        int n = nums.length;
        k = k % n; // Handle k larger than array size

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining n - k elements
        reverse(nums, k, n - 1);
    }

    // Helper method using two pointers
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original: " + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("Rotated:  " + Arrays.toString(nums));
    }
}