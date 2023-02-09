//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/climbing-stairs/description/

class Solution { //Basically Fibonacci Sequence, not sure how tho
    public int climbStairs(int N) {
        if(N==0 || N==1 || N==2)
            return N;
        int arr[] = new int[N+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        
        
        int ans = 0;
        for(int i=3; i<N+1; i++)
        {
            arr[i] = arr[i-1] + arr[i-2];
        }
        
        return arr[N];
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
38.9 MB
Beats
80.90%
 */