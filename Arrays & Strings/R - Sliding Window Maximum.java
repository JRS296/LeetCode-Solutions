//Attempt #1 - 13mins
//Link: 

class Solution { //13mins 22TC/51
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        int ans[] = new int[nums.length - k + 1];
        int maxVal = 0;
        for(int i=0; i<k; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        ans[0]=maxVal;

        for(int i=0; i<nums.length-k+1; i++) {
            maxVal = Math.max(maxVal, nums[i+k-1]);
            ans[i]=maxVal;
        }

        return ans;
    }
}

//21/51 TC passed

//Attempt #2 