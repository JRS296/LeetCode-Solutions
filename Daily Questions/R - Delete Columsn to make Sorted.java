//Attempt #1 - 30mins
//Link:https://leetcode.com/problems/delete-columns-to-make-sorted/submissions/870179756/

class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int ans = 0;
        char arr[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = strs[i].charAt(j);
                // System.out.print(" "+arr[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> ar = new ArrayList<Integer>();
            ArrayList<Integer> ar2 = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                ar.add((int) arr[j][i]);
                ar2.add((int) arr[j][i]);
            }
            // Collections.copy(ar2, ar);
            Collections.sort(ar2);
            if (!ar.equals(ar2)) {
                ans++;
            }

            // System.out.println();
        }
        return ans;
    }
}

/*
 * Runtime
 * 125 ms
 * Beats
 * 5.17%
 * Memory
 * 71.5 MB
 * Beats
 * 5.17%
 * 
 * Time Complexity: O(mxn)
 * Space Complexity: O(n^2)
 */

// Simple SOlutions:
class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs.length;
        int wordlen = strs[0].length();
        int ans = 0;

        for (int i = 0; i < wordlen; i++) {
            char prev = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                char ch = strs[j].charAt(i);
                if (ch < prev) {
                    ans++;
                    break;
                }
                prev = ch;
            }
        }
        return ans;
    }
}

/*
Runtime
12 ms
Beats
59.33%
Memory
47.5 MB
Beats
54.38%

 * Time Complexity: O(mxn)
 * Space Complexity: O(1)
 */