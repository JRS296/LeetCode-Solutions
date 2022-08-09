class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++)
        {
            int x  = nums[i];
            x*=x;
            nums[i]=x;
        }
        
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[i]>nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}

/*
Runtime: 1017 ms
Memory Usage: 54.7 MB(beats 83%)

Horrifying Time Complexity, Good space complexity
 */

class Solution2 {
    public int[] sortedSquares(int[] A) {
    int[] res = new int[A.length];
    int start = 0, end = A.length-1;
    int resIndex = A.length-1;
    
    while(start <= end){
        if(A[start]*A[start] > A[end]*A[end]){
            res[resIndex--] = A[start]*A[start];
            start++;
        }else{
            res[resIndex--] = A[end]*A[end];
            end--;
        }
    }
    
    return res;
}
}
/*
Runtime: 2 ms (above 86%)
Memory Usage: 56.1 MB (above 14%)

Good time Complexity, but space complexity
 */