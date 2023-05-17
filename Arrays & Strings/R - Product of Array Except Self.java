//Attempt #1 - Completed it, but used division
//Link: https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int flag=0;
        for(int x:nums) {
            if(x==0) {
                flag++;
                continue;
            }
            prod*=x;
        }

        int arr[] = new int[nums.length]; 
        if(flag>1) return arr; //If more than one 0, all ans will be 0

        for(int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
                 arr[i] = prod;
                 continue;
            }
            if(flag>=1) {
                arr[i] = 0;
                continue;
            }
            arr[i] = prod/nums[i];
        }

        return arr;
    }
}

/*
Runtime
2 ms
Beats
50.26%
Memory
50.6 MB
Beats
76.51%
 */

 //Optimal Way

 class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Approach: Using prefix and postfix
        //Idea: Just find prefix and postfix product and keep them in the ans array

        int ans[] = new int[nums.length];
        int pre = 1, post = 1;
        
        //find pre product
        for(int i=0;i<nums.length;i++){
            ans[i] = pre;
            pre*=nums[i];
        }
        System.out.println(Arrays.toString(ans));

        //find post product
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=post;
            post*=nums[i];
        }

        return ans;
    }
}

/*
Runtime
16 ms
Beats
7.61%
Memory
53.8 MB
Beats
6.4%
 */