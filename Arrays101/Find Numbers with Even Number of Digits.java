class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++)
        {
            int x = nums[i];
            String s = String.valueOf(x);
            int l = s.length();
            if(l%2==0)
            {
                ans++;
            }
        }
        return ans;
    }
}