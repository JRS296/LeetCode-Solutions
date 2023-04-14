//Attempt #1 - 5 mins
//Link: https://leetcode.com/problems/removing-stars-from-a-string/description/

class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder(s);
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '*') {
                str.deleteCharAt(i--);
                str.deleteCharAt(i--);
            }
        }
        return str.toString();
    }
}

/*
Runtime
2046 ms
Beats
5.7%
Memory
43.1 MB
Beats
92.1%

TC - O(n)
SC - O(n)
 */

 //Optimal Soln
class Solution {
    public String removeStars(String s) {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                c.deleteCharAt(c.length() - 1);
            } else {
                c.append(s.charAt(i));
            }
        }
        return c.toString();
    }
}

/*
Runtime
47 ms
Beats
73.55%
Memory
43.3 MB
Beats
87.49%

TC - O(n)
SC - O(n)
 */