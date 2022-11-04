//Attempt #1 - 30mins
//Link:

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x[] = { -1, -1 };
        if (nums == null || nums.length == 0)
            return x;

        if (nums.length == 1 && target == 0) {
            return x;
        } else if (nums.length == 1 && target == nums[0]) {
            int y[] = { 0, 0 };
            return y;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // System.out.println(mid + " " + right + " " + left);
            if (nums[mid] == target) {
                if (nums[mid + 1] == target) {
                    x[0] = mid;
                    x[1] = mid + 1;
                    // System.out.println(x[0]+" SDFSD "+x[1]);
                    return x;
                } else if (nums[mid - 1] == target) {
                    x[0] = mid - 1;
                    x[1] = mid;
                    // System.out.println(x[0]+" SDFSD "+x[1]);
                    return x;
                }
                return x;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return x;
    }
}

/*
 * 35 / 88 test cases passed.
 */

// Optimal Solution 1 - Using 2 Binary Searches
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}

/*

88 / 88 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 47.2 MB

Time Complexity: O(log n)
Space Complexity: O(1)
 */

//Optimal Solution 2: Using 1 Binary Search