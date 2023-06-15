//Attempt #1 - null
//Link: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928

//Recursive (with helper function to avoid reinitializing list every call)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
        pre.add(root.val);
        preHelper(root.left, pre);
        preHelper(root.right, pre);
    }
}

/*
 * 69 / 69 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 42.3 MB
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

// Iterative - using stack to monitor visited
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> OP = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                OP.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return OP;
    }
}
/*
 * 69 / 69 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 42.6 MB
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */