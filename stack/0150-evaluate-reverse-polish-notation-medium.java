/**
 * LeetCode 150 - Evaluate Reverse Polish Notation (Medium)
 * Day 4 - Stack
 *
 * Problem: Given tokens forming an arithmetic expression in Reverse Polish
 * Notation (postfix), evaluate it and return the integer result. Operators
 * are '+', '-', '*' and '/'; division truncates toward zero. The expression
 * is always valid and there is no division by zero.
 * Example: ["2", "1", "+", "3", "*"] -> 9, because ((2 + 1) * 3) = 9
 *
 * Approach: In RPN an operator always applies to the two most recent
 * unused values — exactly what a stack gives you. Push numbers as they
 * come. On an operator, pop the second operand first, then the first
 * operand (order matters for '-' and '/'), apply the operator and push the
 * result back. One value remains at the end: the answer. Java's int
 * division already truncates toward zero, so no extra handling is needed.
 *
 * Time: O(n) | Space: O(n)
 */
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(apply(first, second, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/");
    }

    private int apply(int first, int second, String op) {
        switch (op) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second; // truncates toward zero in Java
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
