import java.util.Arrays;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // Step 1: Calculate the total sum of the entire array
        int totalSum = 0;
        // TODO: write a loop to sum up all elements in nums into totalSum
        for(int i = 0; i < nums.length; i++) {
          totalSum += nums[i];
        }

        int leftSum = 0;

        // Step 2: Iterate through the array to find where leftSum == rightSum
        for (int i = 0; i < nums.length; i++) {
            // Step 3: Calculate rightSum using totalSum, leftSum, and nums[i]
            int rightSum = totalSum - leftSum - nums[i];

            // Step 4: Check if leftSum equals rightSum. If so, return i.
            if(leftSum == rightSum) {
              return i;
            }          
            // Step 5: Update leftSum by adding nums[i] for the next iteration
            leftSum += nums[i];            
        }

        return -1; // Return -1 if no pivot index exists
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Pivot Index: " + pivotIndex(nums)); 
        // Expected output: 3
    }
}