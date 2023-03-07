//Attempt #1 - null
//Link: https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 0, end = n-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] - (mid + 1) < k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start + k;
    }
}

/*
Intuition of this Problem:
First thing is how we can find number of mission element ?, so below is the magic statement :
arr[i] - (i + 1) : this statement will give us number of missing element before each arr[i] element, here i is nothing but mid used in the code.
For example, for the array [2,3,4,7,11], the number of missing positive integers before each element is [1,1,1,3,6] using above statement.
Second thing is after finding number of missing element before each element, how we can find that element which is missing ? :
*/

/*
Runtime
0 ms
Beats
100%
Memory
42 MB
Beats
48.81%
 */