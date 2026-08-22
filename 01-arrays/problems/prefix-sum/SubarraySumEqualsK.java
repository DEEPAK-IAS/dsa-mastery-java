import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int currentSum = 0;

        // Map to store (prefixSum -> frequency)
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: To handle subarrays starting from index 0 that equal k directly
        prefixSumMap.put(0, 1);

        // Step 1: Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // TODO: Add nums[i] to currentSum
            currentSum += nums[i];
            // TODO: Check if (currentSum - k) exists in prefixSumMap
            // If it does, add its frequency to 'count'

            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // TODO: Update the frequency of currentSum in prefixSumMap
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;

        System.out.println("Subarrays matching sum " + k + ": " + subarraySum(nums, k));
        // Expected output: 2
    }
}