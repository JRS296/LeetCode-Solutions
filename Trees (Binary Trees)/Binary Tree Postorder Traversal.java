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
68 / 68 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 42.3 MB
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

// Iterative - using stack to monitor visited
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            } 
        }
        return ans;
    }
}
/*
68 / 68 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 40.6 MB
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */