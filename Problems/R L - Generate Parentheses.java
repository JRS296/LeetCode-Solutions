//Attempt #1 - 45mins

class Solution {
    public List<String> generateParenthesis(int n) {
        // Simple Logic - there should be equal ( to ). Rest is combinations of given
        // sequence
        char ch1 = '(', ch2 = ')';
        String st = "";
        for (int i = 0; i < n; i++) {
            st += ch1;
            st += ch2;
        }
        // System.out.println(st);
        List<String> ans = new ArrayList<String>();
        if (n > 1) {
            generatePermutation(st, 0, st.length(), ans);
            // return ans;
        } else {
            ans.add(st);
            // return ans;
        }
        List<String> finAns = new ArrayList<String>();
        for (int i = 0; i < ans.size(); i++) {
            if (!finAns.contains(ans.get(i))) {
                finAns.add(ans.get(i));
            }
        }

        return finAns;
    }

    // Function to get all permutations of a string
    public static void generatePermutation(String str, int start, int end, List<String> ans) {
        if (start == end - 1) {
            int flag = 0;
            if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
                Stack<Character> stack = new Stack<Character>();
                for (int i = 0; i < str.length(); i++) {
                    // System.out.println(stack);
                    if (str.charAt(i) == '(') {
                        stack.push(str.charAt(i));
                        continue;
                    }
                    if (str.charAt(i) == ')' && !stack.empty()) {
                        stack.pop();
                        continue;
                    }
                    if (str.charAt(i) == ')' && stack.empty()) {
                        flag = 1;
                        break;
                    }
                }
                if (flag != 1) {
                    ans.add(str);
                }
            }
        }

        else {
            for (int i = start; i < end; i++) {
                str = swapString(str, start, i);
                generatePermutation(str, start + 1, end, ans);
                str = swapString(str, start, i);
            }
        }
    }

    private static String swapString(String stri, int i, int j) {
        char[] str = stri.toCharArray();
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        return String.valueOf(str);
    }
}

/*
Time Limit Exceeded
 */