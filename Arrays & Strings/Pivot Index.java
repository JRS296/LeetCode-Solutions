class Solution {
    public int pivotIndex(int[] nums) {
        int lsum = 0;
        int rsum = 0;
        
        for(int i=0; i<nums.length; i++)
        {
            lsum = 0; rsum = 0;
            for(int j=0; j<nums.length; j++)
            {
                if(j<i)
                {
                    lsum+=nums[j];
                }
                else if(j>i)
                {
                    rsum+=nums[j];
                }
            }
            System.out.println(lsum+" "+rsum);
            if(lsum == rsum)
            {
                return i;
            }
        }
        return -1;
    }
}

/*
Runtime: 1378 ms
Memory Usage: 55.3 MB

Overall Poor Solution, Time Complexity: O(n^2)
 */

class Solution2 {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}

/*
Runtime: 2 ms, faster than 79%
Memory Usage: 52.3 MB, better than 40%

Good Solution, O(n)
 */