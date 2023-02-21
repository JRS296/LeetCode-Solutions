//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/single-element-in-a-sorted-array/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            if (mid % 2 == 0){
                if (nums[mid] == nums[mid-1]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if (nums[mid] == nums[mid-1]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return nums[start];
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
48.1 MB
Beats
60.82%
 */