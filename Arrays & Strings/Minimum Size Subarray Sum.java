import java.util.Arrays;

//Attempt #1 - 20mins
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Arrays.sort(nums, Collections.reverseOrder());
        Arrays.sort(nums);
        reverse(nums);
        // System.out.println(Arrays.toString(nums));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target)
                return i + 1;
        }

        return 0;
    }

    public static void reverse(int[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }
}
/*
17/20 test cases
Time Complexity: O(nlogn)
 */

// Solution:
class Solution2 {
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
/*
20 / 20 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 58.5 MB

Time Complexity: O(n)
 */