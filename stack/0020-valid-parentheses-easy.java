/**
 * LeetCode 20 - Valid Parentheses (Easy)
 * Day 4 - Stack
 *
 * Problem: Given a string s containing only the characters '(', ')', '{',
 * '}', '[' and ']', determine if it is valid. A string is valid if every
 * open bracket is closed by the same type of bracket, brackets are closed
 * in the correct order, and every close bracket has a matching open bracket.
 * Example: "()[]{}" -> true, "(]" -> false, "([)]" -> false
 *
 * Approach: A stack tracks open brackets. Push every opener. When a closer
 * arrives, the only opener it may legally close is the one on top of the
 * stack — pop it and check it matches. If the stack is empty at that point,
 * or the types don't match, the string is invalid. At the end, the stack
 * must be empty, otherwise some bracket was never closed.
 *
 * Time: O(n) | Space: O(n)
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        for (char c : s.toCharArray()) {
            if (pairs.containsValue(c)) {
                // Opening bracket — wait for its closer
                stack.push(c);
            } else {
                // Closing bracket — must match the most recent opener
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
