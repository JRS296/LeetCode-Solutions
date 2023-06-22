//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/palindromic-substrings/description/

class Solution {
    public int countSubstrings(String str) {
        int n = str.length();
        int table[][] = new int[n][n];
        int total = 0;
 
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; ++i) {
            table[i][i] = 1;
            total += 1;
        }
            
        // Check for sub-string of length 2.
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = 1;
                total += 1;
            }
        }

      // Check for lengths greater than 2.
        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1]>=1  && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = j-i;
                    total += 1;
                }
            }
        }
 
    return total;
    }
}

/*
Runtime
11 ms
Beats
46.68%
Memory
44.9 MB
Beats
7.34%
 */