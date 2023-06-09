class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n + 1]; 
        
        for(int i = 0; i <= n; i++){ 
            res[i] = solve(i, res);
        }
        return res;
    }
    public int solve(int n, int memo[]){

        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(memo[n] != 0) return memo[n]; // if memo of n answer is already available we will re-use it & not go further for calculation
        // but if you are coming for the first time then, store that value in memo
        if(n % 2 == 0) {
            memo[n] = solve(n / 2, memo);
            return solve(n / 2, memo);
        }
        else {
            memo[n] = 1 + solve(n / 2, memo);
            return 1 + solve(n / 2, memo);
        } 
    }
}