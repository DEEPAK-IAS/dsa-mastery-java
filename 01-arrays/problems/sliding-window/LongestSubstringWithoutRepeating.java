import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int maxLength = 0;
        Set<Character> windowSet = new HashSet<>();

        // Step 1: Expand the window using 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Step 2: If duplicate found, shrink the window from the left until unique
            while (windowSet.contains(currentChar)) {
                windowSet.remove(s.charAt(left));
                left++;
            }

            // Step 3: Add the new character and update maxLength
            windowSet.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("String: " + s);
        System.out.println("Longest Substring Length: " + lengthOfLongestSubstring(s)); 
        // Expected output: 3
    }
}