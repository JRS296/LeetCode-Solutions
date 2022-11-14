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
    public List<Integer> preorderIt(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if (root == null)
            return pre;
        Stack<TreeNode> tovisit = new Stack<TreeNode>();
        tovisit.push(root);
        while (!tovisit.empty()) {
            TreeNode visiting = tovisit.pop();
            pre.add(visiting.val);
            if (visiting.right != null)
                tovisit.push(visiting.right);
            if (visiting.left != null)
                tovisit.push(visiting.left);
        }
        return pre;
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