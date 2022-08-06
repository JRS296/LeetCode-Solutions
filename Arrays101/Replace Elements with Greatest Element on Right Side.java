class Solution {
    public int[] replaceElements(int[] arr) {
        int l = arr.length;

        int great = -99999;
        for(int i=0; i<l; i++)
        {
            for(int j=i+1; j<l; j++)
            {
                if(arr[j]>=great)
                {
                    great = arr[j];
                }
            }
            System.out.println(great);
            arr[i] = great;
            great = 0;
        }
        
        arr[l-1]=-1;
        return arr;
    }
}
/*
Runtime: 433 ms
Memory Usage: 55.2 MB

Very poorly optimized
 */

class Solution2 {
    public int[] replaceElements(int[] arr) {
        int maxSoFar = -1;        
        for(int i=arr.length-1;i>=0;i--){
            int temp = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar,temp);                       
        }
        return arr;
    }
}

 /*
Runtime: 1 ms
Memory Usage: 44 MB

Highly Optimised - only 1 for loop
 */