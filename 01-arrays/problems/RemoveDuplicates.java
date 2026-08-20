
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0; // Tracks the position of unique elements

        for (int fast = 1; fast < nums.length; fast++) {
            if(nums[slow] != nums[fast]) {
              slow++;
              nums[slow] = nums[fast];

            }
        }

        return slow + 1; // Number of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 4, 4};
        
        int k = removeDuplicates(nums);

        System.out.println("Unique count: " + k);
        System.out.print("Modified Array: [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + (i < k - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}