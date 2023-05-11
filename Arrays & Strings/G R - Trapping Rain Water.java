//Attempt #1 - 28mins
//Needed a small hint for handling the other side, otherwise got the basic intuition in less than 15 mins
//Link: https://leetcode.com/problems/trapping-rain-water/description/

class Solution {
    public int trap(int[] height) {
        int totalVol = 0;
        int arr[] = new int[height.length];

        int ii=0;
        for(int i=0; i<height.length; i++) {
            if(height[i]>ii) ii=height[i];
            int vol1 = ii-height[i];
            //System.out.println(ii + " " + vol1);
            arr[i] = vol1;
        }

        int jj=0;
        for(int j=height.length-1; j>-1; j--) {
            if(height[j]>jj) jj=height[j];
            int vol2 = jj-height[j];
            arr[j] = Math.min(arr[j],vol2);
        }

        for(int x: arr) totalVol+=x;

        return totalVol;
    }
}

/*
Runtime
1 ms
Beats
99.6%
Memory
42.5 MB
Beats
99.34%

TC - O(n)
SC - O(n)
 */