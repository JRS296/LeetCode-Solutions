//Attempt #1 - 16mins
//Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Use sliding window
        List<Integer> ans = new ArrayList<Integer>();
        int len = p.length();
        for (int i = 0; i < s.length() - len + 1; i++) {
            String temp = s.substring(i, i + len);
            if (isAnagram(temp, p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isAnagram(String x, String y) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (char temp : x.toCharArray()) {
            cnt1[temp - 'a']++; // Count of characters in a string
        }

        for (char temp : y.toCharArray()) {
            cnt2[temp - 'a']++; // Count of characters in a string
        }

        if (Arrays.equals(cnt1, cnt2))
            return true;

        return false;
    }
}

/*
 * Runtime
 * 1313 ms
 * Beats
 * 8.97%
 * Memory
 * 43.6 MB
 * Beats
 * 41.69%
 */

// Optimal Soln - Link:
// https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/3143318/clean-and-easy-solution-java-beginner-level-explained-with-video/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return ans;
        }
        int[] arrs = new int[26];
        int[] arrp = new int[26];
        for (int i = 0; i < m; i++) {
            arrs[s.charAt(i) - 'a']++;
            arrp[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= n - m; i++) {
            if (iszero(arrs, arrp)) {
                ans.add(i);
            }
            arrs[s.charAt(i) - 'a']--;
            if (i + m < n) {
                arrs[s.charAt(i + m) - 'a']++;
            }
        }
        return ans;
    }

    public boolean iszero(int[] arrs, int[] arrp) {
        for (int j = 0; j < 26; j++) {
            if (arrs[j] != arrp[j]) {
                return false;
            }
        }
        return true;
    }
}

/*
 * Runtime
 * 6 ms
 * Beats
 * 94.78%
 * Memory
 * 43.1 MB
 * Beats
 * 86.12%
 */