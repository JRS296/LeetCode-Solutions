//Attempt #1 
//Link: https://leetcode.com/problems/word-break/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    boolean flag = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordhash = new HashSet<>(wordDict);
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        recurse(s, 0, wordhash, dp);
        return flag;
    }

    public void recurse(String s, int start, HashSet<String> wordhash, int[] dp) {
        if (start > s.length() - 1) {
            flag = true;
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordhash.contains(s.substring(start, i + 1)) && dp[i + 1] != 2) {
                dp[start] = 1;

                recurse(s, i + 1, wordhash, dp);
            }
            if (i >= s.length() - 1) {
                dp[start] = 2;
                return;
            }
        }
        return;
    }

}

class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean check[] = new boolean[s.length() + 1];
        check[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (check[j] && words.contains(s.substring(j, i))) {
                    check[i] = true;
                    break;
                }

            }
        }
        return check[s.length()];
    }
}