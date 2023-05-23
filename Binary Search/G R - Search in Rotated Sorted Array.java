//Attempt #1 - 5mins
//Link: https://leetcode.com/submissions/detail/834860564/?from=explore&item_id=952

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (target == nums[i])
                return i;
        }
        return -1;

    }
}

/*
 * 195 / 195 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 42 MB
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// Solution using Binary Search
class Solution {
    public int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx])
            return minIdx;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}

/*
195 / 195 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 42.1 MB
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

//Another Attempt - 30mins

class Solution {
    public int search(int[] nums, int target) {
      int start=0;
        int end=nums.length-1;
        
        while(start<=end){
        int mid= start+(end-start) /2;
        if(nums[mid]==target) return mid;
        if(nums[start]<=nums[mid]){
            if(target<=nums[mid] && target>=nums[start]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        else{
            if(target>=nums[mid] && target<=nums[end]){  
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        }
        return -1;
    }
    
}

/*
Runtime
0 ms
Beats
100%
Memory
41.1 MB
Beats
98.46%
 */