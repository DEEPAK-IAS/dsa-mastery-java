/**
 * Problem: Valid Palindrome (LeetCode 125)
 * Pattern: Two-Pointer (Opposite Ends / Converging)
 * 
 * Description:
 * Checks whether a given string is a valid palindrome by considering
 * only alphanumeric characters and ignoring case differences.
 * 
 * Time Complexity:  O(n) - Single pass with two converging pointers.
 * Space Complexity: O(1) - In-place comparison without allocating new strings.
 */
public class ValidPalindrome {

    /**
     * Determines if a string is a palindrome ignoring non-alphanumeric characters and case.
     * 
     * @param s Input string to evaluate
     * @return true if s is a valid palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        // Base case: Null input cannot be a valid string
        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Step 1: Advance 'left' pointer to skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Step 2: Decrement 'right' pointer to skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Step 3: Compare characters at left and right pointers in lowercase
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Mismatch found
            }

            // Step 4: Move both pointers inward for the next comparison
            left++;
            right--;
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println("Test 1 (\"" + s1 + "\"): " + isPalindrome(s1)); // Expected: true
        System.out.println("Test 2 (\"" + s2 + "\"): " + isPalindrome(s2)); // Expected: false
    }
}