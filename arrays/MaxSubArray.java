// Problem: Maximum Subarray
// Link: https://leetcode.com/problems/maximum-subarray/

/*
🔍 Problem Understanding:
Given an integer array nums, find the contiguous subarray
(with at least one element) which has the largest sum,
and return its sum.

------------------------------------------------------------

💡 Approach (Kadane’s Algorithm):

We iterate through the array while maintaining:

1. currentSum → maximum sum of subarray ending at current index
2. maxSum → overall maximum subarray sum found so far

At each step:
- Decide whether to:
  a) Start a new subarray from current element
  b) Continue the previous subarray

------------------------------------------------------------

🧠 Key Insight:
If the current sum becomes negative, it will reduce future sums.
So it's better to start fresh from the current element.

------------------------------------------------------------

⚙️ Algorithm:

1. Initialize:
   - currentSum = nums[0]
   - maxSum = nums[0]

2. Traverse from index 1:
   - currentSum = max(nums[i], currentSum + nums[i])
   - maxSum = max(maxSum, currentSum)

3. Return maxSum

------------------------------------------------------------

📊 Example:

nums = [-2,1,-3,4,-1,2,1,-5,4]

Maximum subarray = [4, -1, 2, 1]
Output = 6

------------------------------------------------------------

⏱️ Time Complexity: O(n)
- Single pass

📦 Space Complexity: O(1)
- No extra space

------------------------------------------------------------

🚀 Pattern:
Kadane’s Algorithm (Greedy + Dynamic Programming)

*/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
