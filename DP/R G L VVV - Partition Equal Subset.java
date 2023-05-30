//Attempt #1 - 10mins (with hints)
//Link: https://leetcode.com/problems/partition-equal-subset-sum/description/

class Solution { //Simple Hset solution
    public boolean canPartition(int[] nums) {
        ArrayList<Integer> hset = new ArrayList<Integer>();
        hset.add(0); hset.add(nums[0]);

        int sum = 0;
        for(int x: nums) {
            sum += x;
        }
        if(sum%2==1) return false;
        sum/=2;

        int hsetLen = 0;
        for(int i=1; i<nums.length; i++) {
            hsetLen = hset.size();
            for(int j=0; j<hsetLen; j++) {
                if(hset.contains(nums[i] + hset.get(j))) continue;
                hset.add(nums[i] + hset.get(j));
                if(hset.contains(sum)) {
                    return true;
                };
            }
        }

        return false;
    }
}

//TLE - 61 / 141 testcases passed

//Attempt #2 - Using Knapsack (didnt quite understand what happened tho)

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x:nums) sum+=x;
        
        //Check if odd
        if(sum % 2 == 1) return false;

        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum/2 + 1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum/2; j++) {
                if(i==0 || j==0) dp[i][j] = false;
                else if(nums[i-1] > j) dp[i][j] = dp[i-1][j];
                else if(nums[i-1] == j) dp[i][j] = true;
                else dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]]; 

                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }

        /*
        0     1     2      3     4      5    6      7    8      9    10    11
        ---------------------------------------------------------------------------
 0     false false false false false false false false false false false false 
 1     false true false false false true true false false false false false 
 5     false true false false false false false false false false false false 
11     false true false false false true true false false false true true 
 5     false true false false false true true false false false false true 
         */

        return dp[n][sum/2];
    }
}

/*
This problem is essentially let us to find whether there are several numbers in a set which 
are able to sum to a specific value (in this problem, the value is sum/2).

Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not. Let us 
assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers. 
If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise 
it is false.

Base case: dp[0][0] is true; (zero number consists of sum 0 is true)

Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j], which means
 if the first i-1 elements has made it to j, dp[i][j] would also make it to j (we can just 
 ignore nums[i]). If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j
  is composed of the current value nums[i] and the remaining composed of other previous numbers.
   Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
 */

/*
Runtime
100 ms
Beats
28.43%
Memory
46.9 MB
Beats
39.32%
 */

//Attempt #3 - Backtracking

class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int half = sum /2;
        if(sum%2==1){ //IF sum is odd, then the two equal subsets are not possible
            return false;
        }
        if(nums[nums.length-1]==half){ //If the last element is half the array, then no need to traverse remaining 
            return true;
        }
        return doDfs(nums, half - nums[nums.length-1],0,0); // backtracking using recursion for all other cases
    }
    
    public boolean doDfs(int nums[], int sum, int curr, int start){
        if(curr > sum){
            return false;
        }
        if(curr == sum){
            return true;
        }
        for(int i = start;i<nums.length-1;i++){
            if(i-1>=start && i-1>=0 && nums[i]==nums[i-1]){ // if the array has 1,2,2, if you already covered 2 in the recursion, do not do 2 again in the same for loop as it wold have covered all the cases in the previous iteration. 
                continue;
            }
            
            if(doDfs(nums, sum, curr+nums[i],i+1)){
                return true;
            }
        }
        return false;
    }
}

//TLE - 61

//Optimal

class Solution {
  public boolean canPartition(int[] nums) {
    int val = Arrays.stream(nums).sum();
    // val must be a even number, or else return false
    if (val % 2 == 1) { return false; }
    val /= 2;
    boolean[] dp = new boolean[val + 1];
    dp[0] = true;
    // 0-1 knapsack: given a bag of size val, can we pick elements from nums to fill the bag full?
    for (int num: nums) {
      for (int cand = val; cand >= num; cand--) {
        dp[cand] = dp[cand] || dp[cand - num];
      }
    }
    return dp[val];
  }
}

/*
System.out.println(cand + " " + num + " " + Arrays.toString(dp));

11 1 [true, false, false, false, false, false, false, false, false, false, false, false]
10 1 [true, false, false, false, false, false, false, false, false, false, false, false]
9 1 [true, false, false, false, false, false, false, false, false, false, false, false]
8 1 [true, false, false, false, false, false, false, false, false, false, false, false]
7 1 [true, false, false, false, false, false, false, false, false, false, false, false]
6 1 [true, false, false, false, false, false, false, false, false, false, false, false]
5 1 [true, false, false, false, false, false, false, false, false, false, false, false]
4 1 [true, false, false, false, false, false, false, false, false, false, false, false]
3 1 [true, false, false, false, false, false, false, false, false, false, false, false]
2 1 [true, false, false, false, false, false, false, false, false, false, false, false]
1 1 [true, true, false, false, false, false, false, false, false, false, false, false]
11 5 [true, true, false, false, false, false, false, false, false, false, false, false]
10 5 [true, true, false, false, false, false, false, false, false, false, false, false]
9 5 [true, true, false, false, false, false, false, false, false, false, false, false]
8 5 [true, true, false, false, false, false, false, false, false, false, false, false]
7 5 [true, true, false, false, false, false, false, false, false, false, false, false]
6 5 [true, true, false, false, false, false, true, false, false, false, false, false]
5 5 [true, true, false, false, false, true, true, false, false, false, false, false]
11 11 [true, true, false, false, false, true, true, false, false, false, false, true]
11 5 [true, true, false, false, false, true, true, false, false, false, false, true]
10 5 [true, true, false, false, false, true, true, false, false, false, true, true]
9 5 [true, true, false, false, false, true, true, false, false, false, true, true]
8 5 [true, true, false, false, false, true, true, false, false, false, true, true]
7 5 [true, true, false, false, false, true, true, false, false, false, true, true]
6 5 [true, true, false, false, false, true, true, false, false, false, true, true]
5 5 [true, true, false, false, false, true, true, false, false, false, true, true]
 */

/*
Runtime
33 ms
Beats
83.99%
Memory
41 MB
Beats
98.61%
 */
