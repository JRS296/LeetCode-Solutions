//Attempt #1 - 20mins
//Link:

class Solution {
    int dp[];
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        dp = new int[nums.length];
        int nums1[] = Arrays.copyOfRange(nums, 0, nums.length-1);
        int firstLoop = helper(nums1, nums1.length-1);
        Arrays.fill(dp,0);
        int nums2[] = Arrays.copyOfRange(nums, 1, nums.length);
        //System.out.println(Arrays.toString(nums2));
        int secondLoop = helper(nums2, nums2.length-1);

        return Math.max(firstLoop, secondLoop);
    }

    int helper(int[] nums, int x) {
        if(x<0) return 0;
        
        if(dp[x]!=0) return dp[x];

        dp[x] = Math.max(nums[x] + helper(nums, x-2), helper(nums, x-1));

        return dp[x];
    }
}

//TLE - 74/75

//Optimal Soln:

class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int firstTake = count(nums, 0, nums.length-1, dp);
        Arrays.fill(dp, -1);
        int firstNotTake = count(nums, 1, nums.length, dp);
        return Math.max(firstTake, firstNotTake);
    }
    int count(int[] arr, int i, int n, int[] dp) {
        if (i==n-1) return dp[i]=arr[i];
        if (i>=n) return 0;
        if (dp[i]!=-1) return dp[i];
        int take = arr[i]+count(arr, i+2, n, dp);
        int nottake = count(arr, i+1, n, dp);
        return dp[i] = Math.max(take, nottake);
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
39.6 MB
Beats
96.65%

TC -O(n)
SC - O(N)
 */

//Attempt #2 - 15mins

class Solution {
    int dp[];
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        dp = new int[nums.length];
        int firstLoop = helper(nums, nums.length-2, 0);
        //System.out.println(Arrays.toString(dp));
        Arrays.fill(dp,0);
        int secondLoop = helper(nums, nums.length-1, 1);
        //System.out.println(firstLoop + " " + secondLoop);
        //System.out.println(Arrays.toString(dp));

        return Math.max(firstLoop, secondLoop);
    }

    int helper(int[] nums, int x, int n) {
        if(x<n) return 0;
        if(x==n-1) return dp[x] = nums[x];

        
        if(dp[x]!=0) return dp[x];

        dp[x] = Math.max(nums[x] + helper(nums, x-2, n), helper(nums, x-1, n));

        return dp[x];
    }
}

//TLE?? I am confusion