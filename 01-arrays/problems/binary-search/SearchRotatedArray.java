import java.util.Arrays;

public class SearchRotatedArray {

  public static int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[right] >= target && target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;

        }
      }

    }

    return -1; // Target not found
  }

  public static void main(String[] args) {
    int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    int target = 0;

    System.out.println("Array: " + Arrays.toString(nums));
    System.out.println("Target: " + target);
    System.out.println("Found at index: " + search(nums, target));
    // Expected output: 4
  }
}