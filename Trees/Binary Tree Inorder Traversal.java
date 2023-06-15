//Attempt #1 - null
//Link: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929

//Recursive (with helper function to avoid reinitializing list every call)
class Solution {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
        preHelper(root.left, pre);
        pre.add(root.val);
        preHelper(root.right, pre);
    }
}

/*
 * 70 / 70 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 43 MB
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

// Iterative - using stack to monitor visited
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> OP = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                OP.add(cur.val);
                cur = cur.right;
            }
        }

        return OP;
    }
}
/*
 * 70 / 70 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 42.7 MB
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */