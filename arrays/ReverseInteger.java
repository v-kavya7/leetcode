/*
Approach:
- Reverse the integer by extracting digits one by one using modulo (%) and division (/).
- Build the reversed number by multiplying the current result by 10 and adding the extracted digit.

Steps:
1. Check if the number is negative and store the sign.
2. Convert the number to positive for easier processing.
3. Extract digits using x % 10 and reduce the number using x / 10.
4. Before updating the result, check for overflow:
   If res > (Integer.MAX_VALUE - digit) / 10, return 0.
5. Add the digit to the result.
6. Restore the original sign at the end.

Edge Cases:
- Handles negative numbers.
- Removes leading zeros automatically (e.g., 120 → 21).
- Returns 0 if the reversed number exceeds 32-bit integer range.

Complexity:
- Time Complexity: O(log10 n)
- Space Complexity: O(1)
*/

class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = -x;
        }

        int res = 0;
        int c;

        while (x > 0) {
            c = x % 10;
            x = x / 10;

            if (res > (Integer.MAX_VALUE - c) / 10) {
                return 0;
            }

            res = (res * 10) + c;
        }

        return isNeg ? -res : res;
    }
}
