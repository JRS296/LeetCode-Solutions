//Attempt #1 - 5 mins
//Link: https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/

class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}

// Two methods - directly searching in O(n) or using Binary Search for O(log n)
/*
 * 65 / 65 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms - 5% terrible
 * Memory Usage: 43.2 MB
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// Attempt #2 - 10 mins

class Solution2 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

// Two methods - directly searching in O(n) or using Binary Search for O(log n)
/*
65 / 65 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 43.5 MB

Time Complexity: O(log n)
Space Complexity: O(1)
 */