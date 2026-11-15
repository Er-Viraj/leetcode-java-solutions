/**
 * LeetCode 121 - Best Time to Buy and Sell Stock (Easy)
 * Day 3 - Sliding Window
 *
 * Problem: You are given prices[i], the price of a stock on day i. Buy on
 * one day and sell on a later day to maximise profit. Return the maximum
 * profit, or 0 if no profit is possible.
 * Example: [7, 1, 5, 3, 6, 4] -> 5 (buy at 1, sell at 6)
 *
 * Approach: A sliding window of size two in spirit — keep the lowest price
 * seen so far as the buy point. For each day, the best profit if we sell
 * today is price - minPrice, and we update minPrice as we go. One pass,
 * no nested loops.
 *
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Cheapest day to buy so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Best profit if we sell today
            int profitToday = price - minPrice;
            if (profitToday > maxProfit) {
                maxProfit = profitToday;
            }
        }

        return maxProfit;
    }
}
