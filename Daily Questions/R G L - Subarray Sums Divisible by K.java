//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

class Solution {
    private int count = 0;
    public int subarraysDivByK(int[] nums, int k) {
        printSubArrays(nums, 0, 0, k);
        return count;
    }

    public void printSubArrays(int[] arr, int start, int end, int k) //Time: O(2^n)
    {
        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;
        // Increment the end point and start from 0
        else if (start > end)
            printSubArrays(arr, 0, end + 1, k);
        // Print the subarray and increment the starting
        // point
        else {
            int sum = 0;
            for (int i = start; i < end; i++)
                sum+=arr[i];
            sum+=arr[end];
            if(sum%k==0)
                count++;

            printSubArrays(arr, start + 1, end, k);
        }
        return;
    }
}

/*
Time: O(2^n)
38/73 Passed
 */

//Attempt #2 - 10mins

class Solution {
    private int count = 0;
    public int subarraysDivByK(int[] nums, int k) {
        printSubArrays(nums, 0, 0, k);
        return count;
    }

    public void printSubArrays(int[] arr, int start, int end, int k2) //Time: O(n^3)
    {
        int n = arr.length;
        for (int i=0; i <n; i++)
        {
            // Pick ending point
            for (int j=i; j<n; j++)
            {
                int sum = 0;
                for (int k=i; k<=j; k++)
                {
                    sum+=arr[k];
                }
                if(sum%k2==0)
                {
                    count++;
                }
            }
        }
    }
}

/*
Time: O(n^3)
38/73
 */