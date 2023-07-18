//Attempt #1 - DNF
//Link: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

import java.util.Arrays;

class Solution {
    public int numSubseq(int[] A, int target) {
        Arrays.sort(A);
        int res = 0, n = A.length, l = 0, r = n - 1, mod = (int) 1e9 + 7, pows[] = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; ++i)
            pows[i] = pows[i - 1] * 2 % mod;

        while (l <= r) {
            if (A[l] + A[r] > target)
                r--;
            else
                res = (res + pows[r - l++]) % mod;
        }
        return res;
    }
}

//Another Solution

class Solution2 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;

        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int tar = (nums[low] + nums[high])%mod;
            if(tar<=target) {
                ans+=power(2,high-low);
                ans = ans%mod;
                low++;
            }
            else high--;
        }

        return ans%mod;
    }

    int mod = (int)1e9+7;
    long power(long x,long y){
       if(y==1) return x;
       if(y==0) return 1;
       long ans =1;
       if(y%2==0){
           ans = power(x,y/2);
           ans*=ans;
       }
       else{
           ans = power(x,y-1);
           ans*=x;
       }
       return ans%mod;
    }
}