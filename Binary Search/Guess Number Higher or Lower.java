//Attempt #1 - 10mins
//Link: https://leetcode.com/explore/learn/card/binary-search/125/template-i/951

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}

/*
25 / 25 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 40.7 MB
 */