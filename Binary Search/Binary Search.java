//Attempt #1 - 5mins
//Link: https://leetcode.com/explore/learn/card/binary-search/138/background/1038/

class Solution {
    public int search(int[] nums, int target) {
        int key = target;
        int last = nums.length - 1;
        int ans = binarySearch(nums, 0, last, key);
        return ans;
    }

    public static int binarySearch(int arr[], int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                return mid; // mid is pointer of index value
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            return -1;
        }
        return -1;
    }
}

/*
47 / 47 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 55 MB

Time Complexity: O(log n)
Space Complexity: O(1)
 */