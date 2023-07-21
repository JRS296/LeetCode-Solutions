//Attempt #1 - DNA
//Links: https://leetcode.com/problems/maximum-product-subarray/

class Solution { // Kadane's
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int prod = 1;

        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            maxi = Math.max(prod, maxi);
            if (prod == 0)
                prod = 1;
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];

            maxi = Math.max(prod, maxi);
            if (prod == 0)
                prod = 1;
        }
        return maxi;
    }
}