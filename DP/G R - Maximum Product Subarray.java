//Attempt #1 
//Link: https://leetcode.com/problems/maximum-product-subarray/description/

class Solution { // https://leetcode.com/problems/maximum-product-subarray/solutions/1608862/java-3-solutions-detailed-explanation-using-image/
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int l = 1, r = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            // if any of l or r become 0 then update it to 1
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= nums[i]; // prefix product
            r *= nums[n - 1 - i]; // suffix product

            ans = Math.max(ans, Math.max(l, r));

        }

        return ans;

    }
}