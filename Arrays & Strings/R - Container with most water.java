//Attempt #Most recent - 6mins
//Link: https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int ans = 0;

        while(i<j) {
            int vol = (height[i]>height[j])? height[j]*(j-i) : height[i]*(j-i);
            ans = Math.max(ans, vol);

            if(height[i]>height[j]) j--;
            else i++;
        }

        return ans;
    }
}

/*
Runtime
4 ms
Beats
80.92%
Memory
52.5 MB
Beats
60.71%

TC - O(logn)
SC - O(1)
 */