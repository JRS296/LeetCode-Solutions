//Attempt #1 - null
//Link: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/

//Recursive (with helper function to avoid reinitializing list every call)
class Solution {
    public List<Integer> PostOrder(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
        preHelper(root.left, pre);
        preHelper(root.right, pre);
        pre.add(root.val);
    }
}

/*
 * 68 / 68 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 42.3 MB
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

// Iterative - using stack to monitor visited
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> OP = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        if (root == null)
            return OP;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                if (stack.peek().right == null) {
                    TreeNode temp = stack.pop();
                    OP.add(temp.val);
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        OP.add(temp.val);
                    }
                } else {
                    cur = stack.peek().right;
                }
            }
        }
        return OP;
    }
}
/*
 * 68 / 68 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 40.6 MB
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */