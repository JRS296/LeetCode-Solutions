//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/add-to-array-form-of-integer/description/

//Explanation: https://leetcode.com/problems/add-to-array-form-of-integer/solutions/3187080/simplest-solution-full-explanation-c-python3-java/

class Solution {
    public List<Integer> addToArrayForm(int[] num, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; --i) {
            res.add(0, (num[i] + K) % 10);
            K = (num[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}

/*
 * Runtime
 * 4 ms
 * Beats
 * 84.63%
 * Memory
 * 43.9 MB
 * Beats
 * 55.33%
 * 
 * Time: O(n)
 * Space: O(1)
 */