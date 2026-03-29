// Problem: Product of Array Except Self
// Link: https://leetcode.com/problems/product-of-array-except-self/

/*
🔍 Problem Understanding:
Given an array nums, return an array such that:
result[i] = product of all elements except nums[i]

⚠️ Constraint:
- Do NOT use division
- Must run in O(n) time

------------------------------------------------------------

💡 Approach (Prefix + Suffix Products):

We avoid division by using two helper arrays:

1. Prefix array (resP):
   - Stores product of all elements to the LEFT of index i

2. Suffix array (resS):
   - Stores product of all elements to the RIGHT of index i

Final result:
- result[i] = resP[i] * resS[i]

------------------------------------------------------------

🧠 Key Insight:
For each index:
- Multiply product of elements before it
- Multiply product of elements after it

------------------------------------------------------------

⚙️ Algorithm:

1. Initialize:
   - resP[0] = 1 (no elements on left)
   - resS[n-1] = 1 (no elements on right)

2. Build prefix array:
   - resP[i] = resP[i-1] * nums[i-1]

3. Build suffix array:
   - resS[i] = resS[i+1] * nums[i+1]

4. Build result:
   - result[i] = resP[i] * resS[i]

------------------------------------------------------------

📊 Example:

nums = [1, 2, 3, 4]

Prefix (resP):
[1, 1, 2, 6]

Suffix (resS):
[24, 12, 4, 1]

Result:
[24, 12, 8, 6]

------------------------------------------------------------

⏱️ Time Complexity: O(n)
- Three linear passes

📦 Space Complexity: O(n)
- Using extra arrays

------------------------------------------------------------

🚀 Pattern:
Prefix + Suffix (Very Important Pattern in Arrays)

*/
class Solution{
      public int[] productExceptSelf(int[] nums){
        int p=1;
        int s=1;
        int[] resP =new int[nums.length];
        int[] resS =new int[nums.length];
        int[] result =new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                resP[i]=1;
            }else{
                p=p*nums[i-1];
                resP[i]=p;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                resS[i]=1;
            }else{
                s=s*nums[i+1];
                resS[i]=s;
            }
        }
        for(int i=0;i<nums.length;i++){
            result[i]=resP[i]*resS[i];
        }
        return result;
      }
}

