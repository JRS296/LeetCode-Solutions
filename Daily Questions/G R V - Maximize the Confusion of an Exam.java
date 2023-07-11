//Attempt #1 - 25mins
//Link: https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/

class Solution { //25
    public int maxConsecutiveAnswers(String s, int k) {
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int tcount = 0;
        int fcount = 0;
        for(right=0; right<s.length(); right++) {
            if(s.charAt(right)=='T') tcount++;
            else fcount++;

            if(Math.min(tcount,fcount)>k) {
                ans = Math.max(ans,right-left);
                if(s.charAt(left++)=='T') tcount--;
                else fcount--;
            }
        }
        ans = Math.max(ans, right - left);

        return ans;
    }
}
/*
Typical sliding window problem. An intuitive way to solve this to keep track of the count of Ts and Fs. The window becomes invalid when the minimum of these 2 counts exceeds k.
*/