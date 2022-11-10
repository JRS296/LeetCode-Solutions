//Attempt #1 - 5mins
//Link: https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/

class Solution {
    public int findDuplicate(int[] nums) {
        //Idea 1 - Use Hashset to figure out duplicate
        HashSet<Integer> ans = new HashSet<Integer>();
        for(int x: nums)
        {
            if(!ans.add(x))
            {
                return x;
            }
            ans.add(x);
        }
        return 0;
    }
}

/*
58 / 58 test cases passed.
Status: Accepted
Runtime: 68 ms - beats 7% poor
Memory Usage: 92.5 MB - beats 14`% poor

Time Compleity: O(n)
Space Complexity: O(n)
 */

//Attempt #2 - 5mins

class Solution {
    public int findDuplicate(int[] nums) {
        //Idea 2 - Sorted Array method
        Arrays.sort(nums); //O(nlog n)
        for(int i=0; i<nums.length-1; i++)
        {
            if(nums[i]==nums[i+1])
            {
                return nums[i];
            }
        }
        return 0;
    }
}

/*
58 / 58 test cases passed.
Status: Accepted
Runtime: 45 ms - beats 26%
Memory Usage: 75.6 MB - beats 54% 

Time Compleexity: O(nlogn)
Space Complexity: O(1)
 */

//Optimal Solution - Using Binary Search? (will also use mlogn solution)