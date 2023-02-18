//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/invert-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

//Explanation: https://leetcode.com/problems/invert-binary-tree/solutions/3199351/beats-100-0-ms-beginner-level-easy-solution-java-explained/

/*
Runtime
0 ms
Beats
100%
Memory
39.6 MB
Beats
92.70%

Time: O(n)
Space: O(n) - REcurive STack
 */