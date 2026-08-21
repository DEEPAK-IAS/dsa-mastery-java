/**
 * Problem: Container With Most Water (LeetCode 11)
 * Pattern: Two-Pointer (Opposite Ends / Converging)
 * 
 * Description:
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * Time Complexity:  O(n) - Single pass through the array from both ends.
 * Space Complexity: O(1) - Constant auxiliary space used for pointers.
 */
public class ContainerWithMostWater {

    /**
     * Calculates the maximum area of water a container can store.
     * 
     * @param height Array representing line heights
     * @return Maximum area calculated
     */
    public static int maxArea(int[] height) {
        // Base case: Need at least 2 lines to form a container
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Step 1: Calculate area using current width and shorter boundary height
            int currentWidth = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = currentWidth * currentHeight;

            // Step 2: Keep track of maximum area seen so far
            maxArea = Math.max(maxArea, area);

            // Step 3: Greedily move the shorter boundary inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int result = maxArea(height);
        System.out.println("Max Water Area: " + result); // Output: 49
    }
}