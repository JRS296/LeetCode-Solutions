//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/target-sum/description/

class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        helper(nums, target, 0, 0);
        return ans;
    }

    public void helper(int[] nums, int target, int curr, int sum) {
        if(curr == nums.length && sum == target) {
            ans++;
            return;
        }
        else if (curr >= nums.length && sum != target) {
            return;
        }
        else {

            helper(nums, target, curr+1, sum+nums[curr]);
            helper(nums, target, curr+1, sum-nums[curr]);
            return;
        }

    }
}

/*
Runtime
628 ms
Beats
8.20%
Memory
40.7 MB
Beats
59.69%

TC - O(2^n)
SC

Std Recursion
 */

//Top Down + Memo
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      Map<String, Integer> dp = new HashMap<>();
      return explore(nums, target, 0, dp);
    }
    
    public int explore(int[] nums, int target, int currIdx, Map<String, Integer> dp) {
      if(target == 0 && currIdx == nums.length) return 1;
      String key = String.valueOf(target) + "," + String.valueOf(currIdx);
      if(dp.get(key) != null) return dp.get(key);
      if(currIdx >= nums.length) return 0;
      
      
      int res1 = explore(nums, target-nums[currIdx], currIdx+1, dp);
      int res2 = explore(nums, target+nums[currIdx], currIdx+1, dp);
      int ways = res1 + res2;
      
      dp.put(key, ways);
      return ways;
    }
  }

/*
Runtime
163 ms
Beats
44.8%
Memory
44.5 MB
Beats
5.7%
 */

//KnapSack

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
      
      int sum = 0;
      for(int n: nums){
        sum += n;
      }
      if (S < -sum || S > sum) { return 0;}
        
      int[][] dp = new int[nums.length + 1][ 2 * sum + 1];
      dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum,  check below graph
      for(int i = 1; i <= nums.length; i++){
        for(int j = 0; j < 2 * sum + 1; j++){
          
          if(j + nums[i - 1] < 2  * sum + 1) dp[i][j] += dp[i - 1][j + nums[i - 1]];
          if(j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
        }
      }
      return dp[nums.length][sum + S];
    }
}

/*
Runtime
13 ms
Beats
59.36%
Memory
43.2 MB
Beats
23.33%
 */