/**
 * LeetCode 371 - Sum of Two Integers (Medium)
 * Day 13 - Bit Manipulation
 *
 * Problem: Given two integers a and b, return a + b without using the
 * + or - operators.
 * Example: a = 1, b = 2 -> 3; a = 2, b = 3 -> 5; a = -1, b = 1 -> 0
 *
 * Approach: Add the way a half-adder does, splitting the sum into
 * "sum without carry" and "carry":
 *   a ^ b        — the digit-wise sum, ignoring carries (1+1 -> 0)
 *   (a & b) << 1 — the carry, one place to the left (only where both
 *                   bits are 1)
 * Replace (a, b) with (a ^ b, (a & b) << 1) and repeat. The carry
 * moves one bit left each round, so after at most 32 rounds it falls
 * off the top of the 32-bit int and b becomes 0 — then a is the sum.
 * Java ints wrap in two's complement, so negative inputs work with
 * no extra masking (unlike Python's unbounded ints).
 *
 * Time: O(1) — at most about 32 iterations, carry shifts left each time
 * Space: O(1) — a few ints
 */
class Solution {
    public int getSum(int a, int b) {
        // While there is still a carry to add in...
        while (b != 0) {
            // Where both bits are 1, a carry is produced.
            int carry = a & b;
            // Sum without carry.
            a = a ^ b;
            // Carry belongs one place to the left.
            b = carry << 1;
        }
        return a;
    }
}
