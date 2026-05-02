// Problem: Find First and Last Position of Element in Sorted Array
// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/*
🔍 Problem Understanding:
Given a sorted array nums and a target value,
find the starting and ending position of the target.

If the target is not found, return [-1, -1].

------------------------------------------------------------

💡 Approach (Binary Search - Two Passes):

We use binary search twice:
1. To find the FIRST occurrence of target
2. To find the LAST occurrence of target

------------------------------------------------------------

🧠 Key Idea:
When target is found at mid:

- For FIRST occurrence:
  → continue searching on the LEFT side
  → (e = mid - 1)

- For LAST occurrence:
  → continue searching on the RIGHT side
  → (s = mid + 1)

This ensures we get the boundary positions.

------------------------------------------------------------

⚙️ Algorithm:

1. Create a helper function find():
   - Performs binary search
   - Takes a boolean flag:
     → true → find first occurrence
     → false → find last occurrence

2. In find():
   - If nums[mid] == target:
       → store index in ans
       → move left or right based on flag

3. Call find() twice:
   - start = find(nums, target, true)
   - end   = find(nums, target, false)

4. Return [start, end]

------------------------------------------------------------

📊 Example:

nums = [5,7,7,8,8,10], target = 8
Output = [3, 4]

------------------------------------------------------------

⏱️ Time Complexity: O(log n)
- Binary search done twice

📦 Space Complexity: O(1)
- No extra space

------------------------------------------------------------

🚀 Pattern:
Binary Search (Boundary Finding / First & Last Occurrence)

*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        int start = find(nums, target, true);
        int end = find(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    public int find(int[] nums, int target, boolean findS) {
        int ans = -1;
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < nums[m]) {
                e = m - 1;
            }

            else if (target > nums[m]) {
                s = m + 1;
            } else {
                ans = m;
                if (findS) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
        }
        return ans;
    }
}
