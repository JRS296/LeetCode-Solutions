import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int alternatingSubarray(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stk = new Stack<Integer>();

        for (int i = 1; i < nums.length; i++) {
            ans.add(nums[i] - nums[i - 1]);
        }

        int ansVal = 0;

        for (int i = 0; i < ans.size(); i++) {

            int val = ans.get(i);
            if (stk.size() == 0 && val == 1) {
                stk.push(val);
                if (1 > ansVal)
                    ansVal = 1;
            } else if (stk.size() > 0) {
                int top = stk.peek();
                if (val == 1) {
                    if (top == -1) {
                        stk.push(1);
                        if (stk.size() > ansVal)
                            ansVal = stk.size();
                    } else {
                        if (stk.size() > ansVal)
                            ansVal = stk.size();
                        stk = new Stack<>();
                        stk.push(1);
                        if (1 > ansVal)
                            ansVal = 1;
                    }
                } else if (val == -1) {
                    if (top == 1) {
                        stk.push(-1);
                        if (stk.size() > ansVal)
                            ansVal = stk.size();
                    } else {
                        stk = new Stack<Integer>();

                    }
                } else {
                    if (stk.size() > ansVal)
                        ansVal = stk.size();
                    stk = new Stack<Integer>();
                }
            }
        }

        return ansVal>0 ? ansVal+1 : -1;
    }
}