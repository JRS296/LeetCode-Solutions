class Solution {
    public void reverseString(char[] s) {
        int a = 0;
        int b = s.length - 1;
        char temp;
        while(a<b)
        {
            temp = ' ';
            temp = s[b];
            s[b] = s[a];
            s[a] = temp;
            a++;
            b--;
        }
        
    }
}
/*
Runtime: 1 ms
Memory Usage: 49.3 MB
Good solution

Time Complexity: O(n/2) = O(n)
 */