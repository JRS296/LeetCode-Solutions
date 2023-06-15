//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

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
    public TreeNode reverseOddLevels(TreeNode root) {
        return ReverseOddLevels(root);
    }

    public TreeNode ReverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null)
            return root;

        queue.offer(root); // queue.add(root) - offer returns false if unsuccessful
        boolean change = false;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            TreeNode t[] = new TreeNode[levelNum];

            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                t[i] = queue.poll();
            }
            
            if(change)
            {
                for(int i =0, j=t.length-1;i<j;i++,j--){
                    int temp = t[i].val;
                    t[i].val = t[j].val;
                    t[j].val = temp;
                }
            }
            change = !change;
        }
        return root;
    }
}

/*
Runtime
11 ms
Beats
30.16%
Memory
47.2 MB
Beats
62.90%
 */