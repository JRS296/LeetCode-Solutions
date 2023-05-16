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

//Attempt #2 - 25mins
//YT LINK: https://www.youtube.com/watch?v=CZQGRp93K4k

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int arr[] = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<Integer>();

        for(int i=0; i<nums.length; i++) {
            //System.out.println(dq + " " + i);
            //Remove out of range stuff from the front
            if(!dq.isEmpty() && dq.peek()==i-k) {
                dq.poll(); //from front of deque
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast(); //from back of deque
            }

            dq.offer(i);
            if(i>=k-1) arr[i-k+1] = nums[dq.peek()];
        }

        return arr;
    }
}

/*
Runtime
38 ms
Beats
57.55%
Memory
63.4 MB
Beats
5.37%

TC - O(n) 
SC - O(k)
 */