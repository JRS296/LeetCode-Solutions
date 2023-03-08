//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> OP = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            // System.out.println(cur.val);
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                OP.add(cur.val);
                cur = cur.right;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < OP.size() - 1; i++) {
            ans = Math.min(ans, Math.abs(OP.get(i) - OP.get(i + 1)));
        }

        // System.out.println(OP);

        return ans;
    }
}

/*
 * Runtime
 * 1 ms
 * Beats
 * 16.70%
 * Memory
 * 40.3 MB
 * Beats
 * 8.64%
 */

// Optimal Soln

class Solution { // Need to use Inorder Traversal
    TreeNode previous = null;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (previous != null) {
            min = Math.min(min, root.val - previous.val);
        }
        previous = root;
        inOrder(root.right);
    }
}

/*
 * Runtime
 * 0 ms
 * Beats
 * 100%
 * Memory
 * 39.9 MB
 * Beats
 * 61.40%
 */