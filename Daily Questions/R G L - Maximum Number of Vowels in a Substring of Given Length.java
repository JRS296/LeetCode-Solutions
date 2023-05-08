//Attempt #1 - 8mins
//Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

class Solution {
    public int maxVowels(String s, int k) {
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<s.length()-k+1; i++) {
            int tempVal = 0;
            String temp = s.substring(i,i+k);
            for(int j=0; j<temp.length(); j++) {
                char ch = temp.charAt(j);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') tempVal++;
            }

            ans = Math.max(ans,tempVal);
        }

        return ans;
    }
}

//TLE - 102/106

//Attempt #2 - 15mins (Overall 25)

class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;

        int winVal = 0;

        for(int i=0; i<k; i++) {
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') winVal++;
        }

        ans = winVal;

        //Window
        for(int i=1; i<s.length()-k+1; i++) {
            
            char rear = s.charAt(i-1);
            char front = s.charAt(i+k-1);

           //System.out.println(rear+" "+front);

            if(rear=='a'||rear=='e'||rear=='i'||rear=='o'||rear=='u') winVal--;
            if(front=='a'||front=='e'||front=='i'||front=='o'||front=='u') winVal++;

            //System.out.println(winVal);
            ans = Math.max(ans,winVal);
        }

        return ans;
    }
}

/*
Runtime
14 ms
Beats
77.91%
Memory
43.3 MB
Beats
46.29%

TC - O(n)
SC - O(1)
 */