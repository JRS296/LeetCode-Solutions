//Attempt #1 - 30s ><
//Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}