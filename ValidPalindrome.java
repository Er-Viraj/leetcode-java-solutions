/**
 * LeetCode 125 - Valid Palindrome (Easy)
 * Day 2 - Two Pointers
 *
 * Problem: A phrase is a palindrome if, after converting all uppercase
 * letters to lowercase and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Return true if s is a
 * palindrome, false otherwise.
 * Example: "A man, a plan, a canal: Panama" -> true
 *
 * Approach: Two pointers, one at each end, moving inward. Skip any
 * character that is not a letter or digit; compare the rest in
 * lowercase. First mismatch means it is not a palindrome.
 *
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare the two characters, ignoring case
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
