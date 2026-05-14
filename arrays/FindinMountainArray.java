// Problem: Find in Mountain Array
// Link: https://leetcode.com/problems/find-in-mountain-array/

/*
🔍 Problem Understanding:
A mountain array is an array where:
- Elements first strictly increase
- Then strictly decrease

Given a target value, return its index in the mountain array.
If target does not exist, return -1.

⚠️ Important:
The array is accessed using the MountainArray API:
- get(index)
- length()

------------------------------------------------------------

💡 Approach:

The solution is divided into 3 steps:

1. Find the peak element
2. Perform binary search on the ascending part
3. If not found, perform binary search on the descending part

------------------------------------------------------------

🧠 Key Insight:

A mountain array consists of:
- Left half → sorted ascending
- Peak element
- Right half → sorted descending

Since both halves are sorted,
binary search can be applied separately.

------------------------------------------------------------

⚙️ Step 1 — Find Peak Element

Use binary search to locate the peak index.

If:
arr[mid] > arr[mid + 1]
→ peak lies on left side (including mid)

Else:
→ peak lies on right side

------------------------------------------------------------

⚙️ Step 2 — Binary Search on Left Half

Search target in:
0 → peak

This part is sorted in ascending order,
so normal binary search is used.

------------------------------------------------------------

⚙️ Step 3 — Binary Search on Right Half

Search target in:
peak + 1 → end

This part is sorted in descending order,
so binary search conditions are reversed.

------------------------------------------------------------

📊 Example:

Array:
[2,4,5,6,8,7,3,1]

Peak = 8

Target = 3

Left Search:
[2,4,5,6,8] → not found

Right Search:
[7,3,1] → found at index 6

------------------------------------------------------------

⏱️ Time Complexity: O(log n)
- Peak finding: O(log n)
- Left binary search: O(log n)
- Right binary search: O(log n)

Overall:
O(log n)

------------------------------------------------------------

📦 Space Complexity: O(1)
- No extra space used

------------------------------------------------------------

🚀 Pattern:
- Peak Element Binary Search
- Order Agnostic Binary Search
- Mountain Array Search

*/
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeak(mountainArr);

        int firstTry = binarySearchAsc(mountainArr, target, 0, peak);

        if (firstTry != -1) {
            return firstTry;
        }

        return binarySearchDesc(
            mountainArr,
            target,
            peak + 1,
            mountainArr.length() - 1
        );
    }

    // Find peak index
    private int findPeak(MountainArray arr) {
        int s = 0;
        int e = arr.length() - 1;

        while (s < e) {
            int m = s + (e - s) / 2;

            if (arr.get(m) > arr.get(m + 1)) {
                e = m;
            } else {
                s = m + 1;
            }
        }

        return s;
    }

    // Binary search on ascending part
    private int binarySearchAsc(
        MountainArray arr,
        int target,
        int s,
        int e
    ) {

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target < arr.get(m)) {
                e = m - 1;
            } else if (target > arr.get(m)) {
                s = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }

    // Binary search on descending part
    private int binarySearchDesc(
        MountainArray arr,
        int target,
        int s,
        int e
    ) {

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target > arr.get(m)) {
                e = m - 1;
            } else if (target < arr.get(m)) {
                s = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeak(mountainArr);

        int firstTry = binarySearchAsc(mountainArr, target, 0, peak);

        if (firstTry != -1) {
            return firstTry;
        }

        return binarySearchDesc(
            mountainArr,
            target,
            peak + 1,
            mountainArr.length() - 1
        );
    }

    // Find peak index
    private int findPeak(MountainArray arr) {
        int s = 0;
        int e = arr.length() - 1;

        while (s < e) {
            int m = s + (e - s) / 2;

            if (arr.get(m) > arr.get(m + 1)) {
                e = m;
            } else {
                s = m + 1;
            }
        }

        return s;
    }

    // Binary search on ascending part
    private int binarySearchAsc(
        MountainArray arr,
        int target,
        int s,
        int e
    ) {

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target < arr.get(m)) {
                e = m - 1;
            } else if (target > arr.get(m)) {
                s = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }

    // Binary search on descending part
    private int binarySearchDesc(
        MountainArray arr,
        int target,
        int s,
        int e
    ) {

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target > arr.get(m)) {
                e = m - 1;
            } else if (target < arr.get(m)) {
                s = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}
