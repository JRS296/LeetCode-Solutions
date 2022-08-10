class Solution {
    public int dominantIndex(int[] nums) {
        int g = -9999;
        int pos = -1;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>g)
            {
                g = nums[i];
                pos = i;
            }
        }
        
        int count = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(i==pos)
            {
                continue;
            }
            else if(nums[i]*2 <= g)
            {
                count++;
                //System.out.println(count);
            }
        }
        
        if(count==nums.length-1)
        {
            return pos;
        }
        else
        {
            return -1;
        }
    }
}

/*
Runtime: 1 ms (beats 89%)
Memory Usage: 42.6 MB (beats 11%)

Good Solution: O(n)
 */