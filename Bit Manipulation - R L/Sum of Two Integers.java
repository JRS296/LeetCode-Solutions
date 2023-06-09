//Link: https://leetcode.com/problems/sum-of-two-integers/submissions/967595683/

class Solution {
    public int getSum(int a, int b) {
        System.out.println(a + " " + b);
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1); // be careful about the terminating condition;
    }
}

/*
Remember: ^ = XOR; & = AND
3!=0 - getSum(1, 4)
4!=0 - getSum(5, 0)
0==0 Therefore 5
 */