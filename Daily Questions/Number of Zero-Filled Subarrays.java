//Attempt #1 - 30 mins
//Link: https://leetcode.com/problems/number-of-zero-filled-subarrays/description/

//Idea -> Number of possible subarrays = n*(n+1)/2

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int flag = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                flag = 1;
            else
                flag = 0;

            if (flag == 1)
                count++;
            else if (flag == 0) {
                // System.out.println(count);
                long x = count * (count + 1) / 2;
                count = 0;
                sum += x;
            }
        }
        sum += (count * (count + 1) / 2);

        return sum;
    }
}

/*
 * Runtime
 * 7 ms
 * Beats
 * 12.54%
 * Memory
 * 60.5 MB
 * Beats
 * 16.93%
 * 
 * TC - O(n)
 * SC - O(1)
 */

// Optimal Soln - w/o division time

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, zeroSubarraysEndingAtCurrentIndex = 0;
        for (int n : nums) {
            if (n == 0) {
                cnt += ++zeroSubarraysEndingAtCurrentIndex; // i.e. 1 + 2 + 3 + 4 + 5 .... (1,3,6,10,15...)
            } else {
                zeroSubarraysEndingAtCurrentIndex = 0;
            }
        }
        return cnt;
    }
}

/*
Runtime
3 ms
Beats
99.69%
Memory
59.9 MB
Beats
52.35%

TC - O(n)
SC - O(1)
 */