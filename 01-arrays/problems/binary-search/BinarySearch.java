import java.util.Arrays;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // TODO: Check if nums[mid] == target
            if(nums[mid] == target) {
              return mid;
            }
            // TODO: Adjust left or right pointers based on comparison

            if(nums[mid] < target) {
              left = mid + 1; 
            }

            if(nums[mid] > target) {
              right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Found at index: " + search(nums, target)); 
        // Expected output: 4
    }
}