//Attempt #1 - 11mins
//Link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

class Solution {
    int prev = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return ans;
    }
    
    public void inOrder(TreeNode root){
        if(root.left!=null) inOrder(root.left);
        ans = Math.min(ans,Math.abs(root.val-prev));
        prev = root.val;
        if(root.right!=null) inOrder(root.right);
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
43 MB
Beats
65.63%
 */