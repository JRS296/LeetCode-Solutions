//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left != null && root.right != null)
            return Math.min(left, right) + 1;

        return Math.max(left, right) + 1;
    }
}

/*
Runtime
14 ms
Beats
25.85%
Memory
62.2 MB
Beats
62.94%

TC - O(n)
SC - O(1)
 */