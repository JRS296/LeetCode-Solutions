class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // XOR of [0,n] is 0^1^2^3^4^5^6^7
            // XOR of input is 0^1^2^3^4^5^7
            // ans = (0^1^2^3^4^5^7) ^(0^1^2^3^4^5^6^7) = 0^0^1^1^2^2^3^3^4^4^5^5^6^7^7 = 6
            // вычленяем то число, которого нет в массиве, а в итерации оно учавствует т.к. i++
            // и в таком случае аждому числу найдется пара, а отсутствующему в массиве пара не найдется
            // такое число и будет отсутствующим в массиве

            //Cool Russian stuff XD
            ans = ans ^ i ^ nums[i];
        }
        return ans;
    }
}