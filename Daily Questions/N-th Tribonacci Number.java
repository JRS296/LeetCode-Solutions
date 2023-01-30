//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/n-th-tribonacci-number/description/

class Solution {
    public int tribonacci(int n) {

        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else if(n==2)
            return 1;

        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        
        for(int i=3; i<n+1; i++)
        {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }


        return arr[n];
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
80.79%

Time: O(n)
Space (O(n+1))
 */