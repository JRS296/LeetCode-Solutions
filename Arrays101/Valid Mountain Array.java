class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean ans = false;
        int x = -99999;
        int pos = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>x)
            {
                x =arr[i];
                pos = i;
            }
        }
        
        System.out.println(x+" "+pos);
        
        if(arr[0] == x || arr[arr.length-1]==x)
        {
            ans = false;
            return ans;
        }
        
        for(int i=0; i<pos; i++)
        {
            if(arr[i]>=arr[i+1])
            {
                ans = false;
                return ans;
            }
            else
            {
                ans = true;
                continue;
            }
        }
        
        for(int i=arr.length-1; i>pos; i--)
        {
            if(arr[i]>=arr[i-1])
            {
                ans = false;
                return ans;
            }
            else
            {
                ans = true;
                continue;
            }
        }
        
        System.out.println(x);
        return ans;
    }
}

/*
Runtime: 15 ms
Memory Usage: 54.1 MB

Not as optimised as this soln
 */

class Solution2 {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }
}

/*
Runtime: 1 ms
Memory Usage: 43 MB

Highly Optimised
 */