//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/target-sum/description/

class Solution {
  int ans = 0;

  public int findTargetSumWays(int[] nums, int target) {
    helper(nums, target, 0, 0);
    return ans;
  }

  public void helper(int[] nums, int target, int curr, int sum) {
    if (curr == nums.length && sum == target) {
      ans++;
      return;
    } else if (curr >= nums.length && sum != target) {
      return;
    } else {

      helper(nums, target, curr + 1, sum + nums[curr]);
      helper(nums, target, curr + 1, sum - nums[curr]);
      return;
    }

  }
}

/*
 * Runtime
 * 628 ms
 * Beats
 * 8.20%
 * Memory
 * 40.7 MB
 * Beats
 * 59.69%
 * 
 * TC - O(2^n)
 * SC
 * 
 * Std Recursion
 */

// Top Down + Memo
class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    Map<String, Integer> dp = new HashMap<>();
    return explore(nums, target, 0, dp);
  }

  public int explore(int[] nums, int target, int currIdx, Map<String, Integer> dp) {
    if (target == 0 && currIdx == nums.length)
      return 1;
    String key = String.valueOf(target) + "," + String.valueOf(currIdx);
    if (dp.get(key) != null)
      return dp.get(key);
    if (currIdx >= nums.length)
      return 0;

    int res1 = explore(nums, target - nums[currIdx], currIdx + 1, dp);
    int res2 = explore(nums, target + nums[currIdx], currIdx + 1, dp);
    int ways = res1 + res2;

    dp.put(key, ways);
    return ways;
  }
}

/*
 * Runtime
 * 163 ms
 * Beats
 * 44.8%
 * Memory
 * 44.5 MB
 * Beats
 * 5.7%
 */

// KnapSack

class Solution {
  public int findTargetSumWays(int[] nums, int S) {

    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    if (S < -sum || S > sum) {
      return 0;
    }

    int[][] dp = new int[nums.length + 1][2 * sum + 1];
    dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum, check below graph
    for (int i = 1; i <= nums.length; i++) {
      for (int j = 0; j < 2 * sum + 1; j++) {

        if (j + nums[i - 1] < 2 * sum + 1)
          dp[i][j] += dp[i - 1][j + nums[i - 1]];
        if (j - nums[i - 1] >= 0)
          dp[i][j] += dp[i - 1][j - nums[i - 1]];
      }
    }
    return dp[nums.length][sum + S];
  }
}

/*
 * Runtime
 * 13 ms
 * Beats
 * 59.36%
 * Memory
 * 43.2 MB
 * Beats
 * 23.33%
 */

class TUF {
  static int countPartitionsUtil(int ind, int target, int[] arr, int[][] dp) {

    if (ind == 0) {
      if (target == 0 && arr[0] == 0)
        return 2;
      if (target == 0 || target == arr[0])
        return 1;
      return 0;
    }

    if (dp[ind][target] != -1)
      return dp[ind][target];

    int notTaken = countPartitionsUtil(ind - 1, target, arr, dp);

    int taken = 0;
    if (arr[ind] <= target)
      taken = countPartitionsUtil(ind - 1, target - arr[ind], arr, dp);

    return dp[ind][target] = (notTaken + taken);
  }

  static int targetSum(int n, int target, int[] arr) {
    int totSum = 0;
    for (int i = 0; i < arr.length; i++) {
      totSum += arr[i];
    }

    // Checking for edge cases
    if (totSum - target < 0)
      return 0;
    if ((totSum - target) % 2 == 1)
      return 0;

    int s2 = (totSum - target) / 2;

    int dp[][] = new int[n][s2 + 1];
    for (int row[] : dp)
      Arrays.fill(row, -1);
    return countPartitionsUtil(n - 1, s2, arr, dp);
  }

  public static void main(String args[]) {

    int arr[] = { 1, 2, 3, 1 };
    int target = 3;

    int n = arr.length;
    System.out.println("The number of ways found is " + targetSum(n, target, arr));
  }
}

class TUF2 {
  static int mod = (int) (Math.pow(10, 9) + 7);

  static int findWays(int[] num, int tar) {
    int n = num.length;

    int[][] dp = new int[n][tar + 1];

    if (num[0] == 0)
      dp[0][0] = 2; // 2 cases -pick and not pick
    else
      dp[0][0] = 1; // 1 case - not pick

    if (num[0] != 0 && num[0] <= tar)
      dp[0][num[0]] = 1; // 1 case -pick

    for (int ind = 1; ind < n; ind++) {
      for (int target = 0; target <= tar; target++) {

        int notTaken = dp[ind - 1][target];

        int taken = 0;
        if (num[ind] <= target)
          taken = dp[ind - 1][target - num[ind]];

        dp[ind][target] = (notTaken + taken) % mod;
      }
    }
    return dp[n - 1][tar];
  }

  static int targetSum(int n, int target, int[] arr) {
    int totSum = 0;
    for (int i = 0; i < n; i++) {
      totSum += arr[i];
    }

    // Checking for edge cases
    if (totSum - target < 0 || (totSum - target) % 2 == 1)
      return 0;

    return findWays(arr, (totSum - target) / 2);
  }

  public static void main(String args[]) {

    int arr[] = { 1, 2, 3, 1 };
    int target = 3;

    int n = arr.length;
    System.out.println("The number of ways found is " + targetSum(n, target, arr));
  }
}