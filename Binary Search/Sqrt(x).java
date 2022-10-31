//Attempt #1 - 
//Link: https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/

class Solution {
    public int mySqrt(int x) {
	if (x == 0) return 0;
	int start = 1, end = x;
	while (start < end) { 
		int mid = start + (end - start) / 2;
		if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
			return mid; 
		else if (mid > x / mid)// Keep checking the left part
			end = mid;
		else
			start = mid + 1;// Keep checking the right part
	}
	return start;
}
}

/*
1017 / 1017 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 39.2 MB

Time Complexity: O(log n)
Space Complexity: O(n)
 */