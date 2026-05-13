// Problem: Find Peak Element
// Link: https://leetcode.com/problems/find-peak-element/

/*
🔍 Problem Understanding:
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, return the index of any peak element.

⚠️ Important:
- The array may contain multiple peaks
- We can return any one of them
- nums[-1] and nums[n] are considered negative infinity

------------------------------------------------------------

💡 Approach (Binary Search):

We use binary search to efficiently locate a peak element.

At each step:
- Compare nums[mid] with nums[mid + 1]

------------------------------------------------------------

🧠 Key Insight:

1. If nums[mid] > nums[mid + 1]:
   → We are in the descending part
   → A peak exists on the LEFT side (including mid)

   So:
   e = mid

2. If nums[mid] < nums[mid + 1]:
   → We are in the ascending part
   → A peak exists on the RIGHT side

   So:
   s = mid + 1

Eventually, start and end converge to the peak index.

------------------------------------------------------------

⚙️ Algorithm:

1. Initialize:
   - s = 0
   - e = n - 1

2. While s < e:
   - mid = s + (e - s) / 2

   - If nums[mid] > nums[mid + 1]:
       → move left
       → e = mid

   - Else:
       → move right
       → s = mid + 1

3. Return s (or e)

------------------------------------------------------------

📊 Example:

nums = [1,2,3,1]

mid = 1 → nums[1] < nums[2]
Move right

Eventually:
Peak = index 2 (value = 3)

------------------------------------------------------------

⏱️ Time Complexity: O(log n)
- Binary search

📦 Space Complexity: O(1)
- No extra space

------------------------------------------------------------

🚀 Pattern:
Binary Search on Answer / Peak Finding

*/
class Solution {
    public int findPeakElement(int[] arr) {
         int s=0;
        int e=arr.length-1;
        while(s<e){
            int m=s+(e-s)/2;
            if(arr[m]>arr[m+1]){
                e=m;
            }else{
                s=m+1;
            }
        }
        return s;
    }
}
