//Attempt #1 - 27mins
//Link: https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int arr[] = new int[l1 + l2];
        for (int i = 0; i < l1 + l2; i++) {
            if (i < l1) {
                arr[i] = nums1[i];
            } else {
                arr[i] = nums2[i - l1];
            }

            // System.out.println(arr[i]);
        }
        Arrays.sort(arr);
        int len = l1 + l2;

        if (len % 2 == 0) {
            // Even median
            int med = (len - 1) / 2;
            double x = arr[med];
            double y = arr[med + 1];
            // System.out.println(x+" "+y);
            return (x + y) / 2;
        } else {
            // Odd
            int med = (len - 1) / 2;
            return arr[med];
        }
    }
}

/*
 * 2094 / 2094 test cases passed.
 * Status: Accepted
 * Runtime: 13 ms - beats 22%
 * Memory Usage: 50.7 MB - beats 14%
 * 
 * Time Complexity: O(nlogn) (due to quick sort, rest is O(1))
 * Space Complexity: O(m+n);
 */

//Optimal Solution:
//Complicated - O(log n) Solution is present, try understanding