/*
LeetCode: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Approach:
- Use Binary Search to find the minimum element in a rotated sorted array.
- The minimum element is the point where the rotation happens.

Steps:
1. Initialize two pointers: left = 0 and right = n - 1.
2. While left < right:
   - Find mid index.
   - If nums[mid] > nums[right], the minimum lies in the right half → move left to mid + 1.
   - Else, the minimum lies in the left half (including mid) → move right to mid.
3. When loop ends, left points to the minimum element.

Edge Cases:
- Array not rotated → first element is minimum.
- Single element array.
- Works efficiently for all rotated cases.

Complexity:
- Time Complexity: O(log n)
- Space Complexity: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
