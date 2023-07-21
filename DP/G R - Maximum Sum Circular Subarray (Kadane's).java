//Attempt #1 - DNA
//Link: https://leetcode.com/problems/maximum-sum-circular-subarray/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // calculating max Subarray sum using kadane's Algo (linear array)
        int max = Integer.MIN_VALUE, sum = 0, total = 0;
        for (int x : nums) {
            sum += x;
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
            total += x; // calculating sum of elements of nums
        }

        int max2 = 0;
        sum = 0;
        for (int x : nums) {
            max = Math.max(max, total + max2); // updating max when right sum + x + max left sum>max
            total -= x; // right sum
            sum += x; // left sum
            max2 = Math.max(max2, sum); // maximum left sum
        }
        return max;
    }
}