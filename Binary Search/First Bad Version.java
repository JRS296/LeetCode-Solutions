//Attempt #1 - 25mins
//Link: https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid) == true) {
                right = mid;
            } else if (isBadVersion(mid) == false) {
                left = mid + 1;
            }
        }

        if (left != n && isBadVersion(left) == true)
            return left;
        return n;
    }
}

/*
24 / 24 test cases passed.
Status: Accepted
Runtime: 37 ms
Memory Usage: 40.9 MB

Time Complexity: O(log n)
Space Complexity: O(1)
 */

//Optimal #1 - 
public int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
        int mid = start + (end-start) / 2;
        if (!isBadVersion(mid)) start = mid + 1;
        else end = mid;            
    }        
    return start;
}

/*
24 / 24 test cases passed.
Status: Accepted
Runtime: 22 ms
Memory Usage: 40.4 MB
 */

//Optimal #2