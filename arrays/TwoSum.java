// Problem: Two Sum
// Link: https://leetcode.com/problems/two-sum/
// Approach:
// We use a brute-force method by checking every pair of elements in the array.
// For each element, we compare it with every other element after it.
// If the sum of the two elements equals the target, we return their indices.
//
// Time Complexity: O(n^2) – due to two nested loops
// Space Complexity: O(1) – no extra space used

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target){
                return new int[]{i,j};
            }
            }
        }
       return new int[]{};
    }
}

// method 2: optimized

// Problem: Two Sum
// Link: https://leetcode.com/problems/two-sum/
// Approach:
// We use a HashMap to store elements and their indices as we iterate.
// For each element, we calculate the complement (target - current value).
// If the complement already exists in the map, we return the indices.
// Otherwise, we store the current element and its index in the map.
//
// Time Complexity: O(n) – single pass through the array
// Space Complexity: O(n) – for storing elements in HashMap

import java.util.HashMap;
import java.util.Map;
class Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int c=target-nums[i];
            if(mp.containsKey(c)){
                return new int[]{mp.get(c),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{};
     }
}
