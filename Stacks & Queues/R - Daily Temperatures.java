//Attempt #1 - 15mins
//Link: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[] = new int[temperatures.length];
        for(int i=0; i<temperatures.length-1; i++)
        {
            ans[i]=0;
        }
        for(int i=0; i<temperatures.length-1; i++)
        {
            int x = temperatures[i];
            // while(temperatures[i]<temperatures[j])
            // {
            //     j++;
            // }
            // ans[i] = j;
            for (int j=i+1; j<temperatures.length; ++j) {
                if (temperatures[j] > x) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}

/*
Time Limit Exceeded - O(n^2)
 */

//Optimal Solution - using Stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] ret = new int[temperatures.length];
    for(int i = 0; i < temperatures.length; i++) {
        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int idx = stack.pop();
            ret[idx] = i - idx;
        }
        stack.push(i);
    }
    return ret;
}
}
//READ CAREFULLY!!!
/*
Runtime
144 ms
Beats
68.59%
Memory
54.2 MB
Beats
92.38%
 */