/**
 * LeetCode 155 - Min Stack (Medium)
 * Day 4 - Stack
 *
 * Problem: Design a stack that supports push, pop, top, and retrieving the
 * minimum element — each in O(1) time. pop, top and getMin are only ever
 * called on a non-empty stack.
 * Example: push(-2), push(0), push(-3), getMin() -> -3, pop(), top() -> 0,
 * getMin() -> -2
 *
 * Approach: A plain stack can't give the minimum in O(1), because a single
 * "current min" variable is lost after a pop. So keep a second stack that
 * mirrors the main one: at every level it stores the minimum of everything
 * at or below that level. On push, push min(val, current min) alongside val.
 * On pop, pop both stacks together. getMin is then just the top of the
 * min stack — the previous minimum is always waiting underneath.
 *
 * Time: O(1) per operation | Space: O(n)
 */
import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
    }

    public void push(int val) {
        stack.push(val);
        // Minimum of everything at or below this level
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
