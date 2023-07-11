class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len = nums.length;
        if (len == 1) {
            if (nums[0] % 2 == 0 && nums[0] <= threshold)
                return 1;
            else
                return 0;
        }
        
        int max = 0;
        int count = 0;
        int currLen = 0;
        
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] % 2 == 0) {
                if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                    if (1 > max)
                        max = 1;
                }
                for (int j = i; j < len - 1; j++) {
                    if (nums[j] % 2 != nums[j + 1] % 2) {
                        if (nums[j] <= threshold && nums[j + 1] <= threshold) {
                            count++;
                            currLen = 1;
                            if (count > max)
                                max = count;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            count = 0;
        }
        
        if (max > 0 && currLen == 1)
            return max + 1;
        else if (max == 1) {
            return 1;
        } else {
            if (nums[len - 1] % 2 == 0 && nums[len - 1] <= threshold)
                return 1;
            else if (nums[0] % 2 == 0 && nums[0] <= threshold)
                return 1;
            else
                return 0;
        }
    }
}