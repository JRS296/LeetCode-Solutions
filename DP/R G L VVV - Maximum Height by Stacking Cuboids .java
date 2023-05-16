//Attempt #1 - had rough idea - took 2 solved examples
//Link: https://leetcode.com/problems/maximum-height-by-stacking-cuboids/description/

class Solution {
    public int maxHeight(int[][] A) {
        for (int[] a : A)
            Arrays.sort(a);
        Arrays.sort(A, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                if (a[1] != b[1])
                    return b[1] - a[1];
                return b[2] - a[2];
            }
        });

        // for(int x[] : A) {
        //     System.out.println(Arrays.toString(x));
        // }

        int ans = 0;
        int dp[] = new int[A.length];
        for(int i=0; i<A.length; i++) {
            dp[i] = A[i][2];
            for(int j=0; j<i; j++) {
                if(A[j][0]>=A[i][0] && A[j][1]>=A[i][1] && A[j][2]>=A[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        //System.out.println(Arrays.toString(dp));
        return ans;
    }
}

/*
STEPS:
1. Sort all in descending order
2. See if previous cuboids can support current cuboid
3. If so, check if current dp value + base is greater, or base is greater, highest val is placed in dp array
4. Return maxima of array
*/

//Optimal #2 

class Solution {
    public int maxHeight(int[][] cuboids) {
        // Sorting all Dimensions
        for(int[] arr : cuboids) Arrays.sort(arr);

        // sort all cuboids on basis of height, if same then breadth,
        // if same then length
        Arrays.sort(cuboids, (a, b) -> (b[2] - a[2] == 0 ? (b[1] - a[1] == 0 ? b[0] - a[0] : b[1] - a[1]) : b[2] - a[2]));

        // use logic of LIS(Longest Increasing Subsequence)
        return helperTab(cuboids);

    }
    public int helperTab(int[][] nums){
        int n = nums.length;
        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        for(int curr = n - 1; curr >= 0; curr--){
            for(int prev = curr - 1; prev >= -1; prev--){
                int take = 0;
                if(prev == -1 || check(nums[curr], nums[prev])) take = nums[curr][2] + nextRow[curr + 1];
                int notTake = 0 + nextRow[prev + 1];
                currRow[prev + 1] = Math.max(take, notTake);
            }
            nextRow = currRow;
        }
        return nextRow[0];
    }
    // These function checks whether current cuboid can be placed above 
    //the below one or not, on the basis on condition given in question.
    public boolean check(int[] a, int[] b){
        if(a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2]) return true;
        else return false;
    }
}