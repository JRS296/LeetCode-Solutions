//Attempt #1 - 8mins
//Link: https://leetcode.com/problems/sign-of-the-product-of-an-array/description/

class Solution {
    public int arraySign(int[] nums) {
        long product = 1;
        for(int x:nums) {
            if(x>0) product*=1;
            else if(x==0) {
                product*=0;
                break;
            }
            else product *=-1;
        }

        if(product>0) return 1;
        else if (product==0) return 0;
        else return -1;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
42.2 MB
Beats
50.18%

TC - O(n)
SC - O(1)
 */