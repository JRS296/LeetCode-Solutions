//Attemp #1 - 15mins
//Link: https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            int tmp = n;
            int sum = 0;
            while (tmp > 0) {
                int digit = tmp % 10;
                sum += digit * digit;
                tmp /= 10;
            }
            n = sum;
            if (set.contains(n))
                return false;
            else
                set.add(n);
        }
        return true;
    }
}

/*
 * 404 / 404 test cases passed.
 * Status: Accepted
 * Runtime: 4 ms (beats 24%)
 * Memory Usage: 41.7 MB (beats 18%)
 * 
 * Time Complexity:
 * Space Complexity: O(m)
 */

// Alternate Solution - Leetcode Soln
class Solution {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}

/*
404 / 404 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 41.3 MB

Time Complexity: 
Space Complexity: O(n)
 */