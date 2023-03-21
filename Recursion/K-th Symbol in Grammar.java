//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/k-th-symbol-in-grammar/

class Solution {
    public int kthGrammar(int n, int k) {
        StringBuilder x = helper(new StringBuilder("0"), 1, n);
        return x.charAt(k-1) - '0';
    }

    public StringBuilder helper(StringBuilder str, int curr, int n)
    {
        if(curr==n) return str;

        //Make new StringBuilder to store version where all 0=1 and all 1=0. Then append to original
        StringBuilder temp = new StringBuilder(str.toString());
        for(int i=0; i<temp.length(); i++)
        {
            if(temp.charAt(i)=='0')
                temp.setCharAt(i,'1');
            else
                temp.setCharAt(i,'0');
        }

        return helper(str.append(temp),++curr,n);
    }
}

/*
MLE - 15/55
*/

//Optimal Soln: https://leetcode.com/problems/k-th-symbol-in-grammar/solutions/365364/java-easy-to-understand-recursion/

class Solution {
    public int kthGrammar(int N, int K) {
        if(N==1) return 0;
        if(K%2==0){
            if (kthGrammar(N-1,K/2)==0) return 1;
            else return 0;
        }
        else{
            if(kthGrammar(N-1,(K+1)/2)==0) return 0;
            else return 1;
        }
    }
}
// think of the problem like this
/*        0
      /       \
     0          1
   /   \      /    \
   0     1    1      0
 / \     / \   / \   / \
 0  1   1   0  1  0  0  1
*/

/*
Runtime
0 ms
Beats
100%
Memory
39.5 MB
Beats
35.20%

TC - O(n) ??
SC - O(log n)
 */

