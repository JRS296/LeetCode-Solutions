//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/add-digits/description/

class Solution {
    public int addDigits(int num) {
        String n = Integer.toString(num);
        if(n.length()==1) return num;

        int sum = 0;
        for(int i=0; i<n.length(); i++) {
            int x = n.charAt(i)-'0';
            sum+=x;
        } 

        return addDigits(sum);
    }
}

/*
Runtime
1 ms
Beats
100%
Memory
39.7 MB
Beats
85.75%

TC - O(nlogn)
SC - O(log n)
 */