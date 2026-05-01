// Problem: Find Smallest Letter Greater Than Target
// Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/

/*
🔍 Problem Understanding:
Given a sorted array of characters letters and a target character,
we need to find the smallest character in the array that is strictly
greater than the target.

⚠️ Important:
The array is circular.
If no character is greater than target, return the first element.

------------------------------------------------------------

💡 Approach (Binary Search):

Since the array is sorted, we use binary search to efficiently
find the smallest character greater than target.

We maintain:
- s (start)
- e (end)
- ans (stores the current best answer)

------------------------------------------------------------

🧠 Key Idea:
Whenever we find a character greater than target:
- It could be a valid answer
- But we try to find a smaller one on the left side

So:
- Update ans = letters[mid]
- Move left (e = mid - 1)

If letters[mid] <= target:
- Move right (s = mid + 1)

------------------------------------------------------------

⚙️ Algorithm:

1. Initialize:
   - s = 0, e = n-1
   - ans = letters[0] (default for circular case)

2. While s <= e:
   - mid = s + (e - s) / 2
   - If letters[mid] > target:
       → update ans
       → search left
   - Else:
       → search right

3. Return ans

------------------------------------------------------------

📊 Example:

letters = ['c','f','j'], target = 'a'
Output = 'c'

letters = ['c','f','j'], target = 'j'
Output = 'c' (circular)

------------------------------------------------------------

⏱️ Time Complexity: O(log n)
- Binary search

📦 Space Complexity: O(1)
- No extra space

------------------------------------------------------------

🚀 Pattern:
Binary Search (Lower Bound Variant)

*/


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s=0;
        int e=letters.length-1;
        char ans=letters[0];
        while(s<=e){
            int m=s+(e-s)/2;
            if(letters[m]>target){
                ans=letters[m];
                e=m-1;
            }else{
                s=m+1;
            }
        }
         return ans;
    }
}
