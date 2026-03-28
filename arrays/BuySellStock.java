// Problem: Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
🔍 Problem Understanding:
We are given an array where prices[i] is the stock price on day i.
We need to find the maximum profit by choosing one day to buy
and a later day to sell.

------------------------------------------------------------

💡 Approach (Optimized - One Pass):

Instead of checking all pairs (brute force),
we track:

1. Minimum price seen so far (buying price)
2. Maximum profit possible at each step

At each day:
- Assume we sell on that day
- Calculate profit = current price - minimum price so far
- Update max profit if needed

------------------------------------------------------------

🧠 Key Insight:
We must always BUY before we SELL.
So we keep track of the lowest price BEFORE current day.

------------------------------------------------------------

⚙️ Algorithm:
1. Initialize:
   - minPrice = prices[0]
   - maxProfit = 0

2. Traverse array:
   - If current price < minPrice → update minPrice
   - Else → calculate profit = price - minPrice
   - Update maxProfit if profit is higher

3. Return maxProfit

------------------------------------------------------------

⏱️ Time Complexity: O(n)
- Single pass through array

📦 Space Complexity: O(1)
- No extra space used

------------------------------------------------------------

❌ Why Brute Force Fails:
Checking all pairs takes O(n²), which is inefficient.

------------------------------------------------------------

🚀 Pattern:
This problem follows the "Greedy + Tracking Minimum" pattern.

*/
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update minimum price so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if sold today
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
