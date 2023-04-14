//Attempt #1 - 25mins
//Link: https://leetcode.com/problems/validate-stack-sequences/description/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean ans = true;
        int j = 0;
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0; i<pushed.length; i++) {
            stk.push(pushed[i]);
            if(stk.peek()==popped[j]) {
                while(!stk.isEmpty()) {
                    if(stk.peek()==popped[j++]) stk.pop();
                    else {
                        j--;
                        break;
                    };
                }
            }
        }

        while(!stk.isEmpty()) {
            if(stk.peek() == popped[j++]) {
                stk.pop();
                continue;
            } 
            else {
                return false;
            }
        }
        return ans;
    }
}

/*
Runtime
3 ms
Beats
85.86%
Memory
42 MB
Beats
75.74%

TC - O(n)
SC - O(n)
 */