//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/longest-palindromic-substring/description/?envType=study-plan-v2&id=dynamic-programming

class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        int table[][] = new int[n][n];
 
        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = 1;
 
        // Check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = 1;
                start = i;
                maxLength = 2;
            }
        }

      // Check for lengths greater than 2.
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1]>=1  && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = j-i;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        String ans = str.substring(start, start + maxLength);

        // for(int i=0; i<table.length; i++) {
        //     for(int j=0; j<table[0].length; j++) {
        //         System.out.print(table[i][j] + " ");
        //     }
        //     System.out.println();
        // }
 
        // Return length of LPS
        // return maxLength;
    return ans;
    }
}

/*
Runtime
130 ms
Beats
35.54%
Memory
55 MB
Beats
5%
 */