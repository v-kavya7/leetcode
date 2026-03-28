// Problem: Contains Duplicate
// Link: https://leetcode.com/problems/contains-duplicate/

/*
🔍 Problem Understanding:
Given an integer array nums, return true if any value appears
at least twice, and return false if every element is distinct.

------------------------------------------------------------

💡 Approach (Sorting):

1. First, sort the array.
2. After sorting, duplicate elements will be adjacent.
3. Traverse the array and check:
   - If nums[i] == nums[i + 1] → duplicate found → return true
4. If no duplicates found, return false

------------------------------------------------------------

🧠 Key Insight:
Sorting brings equal elements next to each other,
making duplicate detection easy.

------------------------------------------------------------

⚙️ Algorithm:
1. Sort the array
2. Loop from i = 0 to n-2:
   - If nums[i] == nums[i+1] → return true
3. Return false

------------------------------------------------------------

⏱️ Time Complexity: O(n log n)
- Due to sorting

📦 Space Complexity: O(1)
- No extra space (ignoring sort implementation)

------------------------------------------------------------

🚀 Pattern:
Sorting + Linear Scan

*/
import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
          if(nums[i]==nums[i+1]){
             return true;
          }
        }
        return false;
    }
}
